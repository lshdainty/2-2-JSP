package mlogin.bean;

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
		DataSource ds = (DataSource)envCtx.lookup("jdbc/cafe");
		return ds.getConnection();
	}
	
	//관리자 인증 메소드
	public int userCheck(int manager_code, String manager_passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		try {
			conn = getConnection();
			
			String sql = "select manager_passwd from manager where manager_code=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, manager_code);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbpasswd = rs.getString("manager_passwd");
				if(dbpasswd.equals(manager_passwd)) {
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
			System.out.println("관리자 인증에 오류가 있습니다.");
		}finally {
			if(rs!=null)try {rs.close();}catch(Exception e) {}
			if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
			if(conn!=null)try {conn.close();}catch(Exception e) {}
		}
		return x;
	}
	
	//관리자/직원 구분
	public int authorityCheck(int manager_code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 2;
		try {
			conn = getConnection();
			
			String sql = "select substr(manager_code,1,1) from manager where manager_code=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, manager_code);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int test = rs.getInt("substr(manager_code,1,1)");
				if(test ==1 ) {
					num=1;	//관리자 권한
				}
				else {
					num=2;	//직원 권한
				}
			}

		}catch(Exception e) {
			System.out.println("관리자/직원 구분에 오류가 있습니다.");
		}finally {
			if(rs!=null)try {rs.close();}catch(Exception e) {}
			if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
			if(conn!=null)try {conn.close();}catch(Exception e) {}
		}
		return num;
	}
}
