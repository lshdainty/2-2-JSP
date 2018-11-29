package bookshop.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MngrDBBean {
	//싱글톤 
	private static MngrDBBean instance = new MngrDBBean();
	
	public static MngrDBBean getInstance() {
		return instance;
	}
	
	private MngrDBBean() {}
	
	//커넥션 풀 객체 생성
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("oracle");
		return ds.getConnection();
	}
	
	//관리자 인증 메소드
	public int userCheck(String id, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		try {
			conn = getConnection();
			
			String sql = "select managerpasswd from manager where managerid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbpasswd = rs.getString("managerpasswd");
				if(dbpasswd.equals(passwd)) {
					x=1;	//로그인 성공
				}
				else {
					x=0;	//비번틀림
				}
			}
			else {
				x=-1;	//아이디 없음
			}
		}catch(Exception e) {
			System.out.println("오류가 있습니다.");
		}finally {
			if(rs!=null)try {rs.close();}catch(Exception e) {}
			if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
			if(conn!=null)try {conn.close();}catch(Exception e) {}
		}
		return x;
	}
}
