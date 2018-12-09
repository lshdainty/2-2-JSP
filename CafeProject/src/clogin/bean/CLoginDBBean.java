package clogin.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CLoginDBBean {
	//싱글톤 
	private static CLoginDBBean instance = new CLoginDBBean();
	
	public static CLoginDBBean getInstance() {
		return instance;
	}
	
	private CLoginDBBean() {}
	
	//커넥션 풀 객체 생성
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/cafe");
		return ds.getConnection();
	}
	
	//고객 인증 메소드
	public int userCheck(String customer_name, String customer_tel) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		
		try {
			conn = getConnection();
			
			String sql = "select customer_name from customer where customer_tel=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, customer_tel);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbname = rs.getString("customer_name");
				if(dbname.equals(customer_name)) {
					x=1;	//로그인 성공
				}
				else {
					x=0;	//이름이 다름
				}
			}
			else {
				x=-1;	//전화번호가 없음
			}
		}catch(Exception e) {
			System.out.println("고객 인증에 문제가 있습니다.");
		}finally {
			if(rs!=null)try {rs.close();}catch(Exception e) {}
			if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
			if(conn!=null)try {conn.close();}catch(Exception e) {}
		}
		return x;
	}
	
	//고객 회원가입
	public int userAdd(String customer_name, String customer_tel) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 1;
		
		try {
			conn = getConnection();
			
			String sql = "select * from customer where customer_tel=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, customer_tel);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				x=1;	//아이디가 존재하여 가입 불가
			}
			else {
				String sql1 = "insert into customer values(?,?,0)";
				pstmt = conn.prepareStatement(sql1);
				pstmt.setString(1, customer_tel);
				pstmt.setString(2, customer_name);
				pstmt.executeUpdate();
				x=2;	//아이디가 존재하지 않아 가입 가능
			}
		}catch(Exception e) {
			System.out.println("회원 가입에 문제가 있습니다.");
		}finally {
			if(rs!=null)try {rs.close();}catch(Exception e) {}
			if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
			if(conn!=null)try {conn.close();}catch(Exception e) {}
		}
		return x;
	}
	
	//고객 결제 내역 조회
	public JSONArray selectPay(String customer_tel){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JSONObject jsonObject;
		JSONArray jsonArray = new JSONArray();
			
		try {
			conn = getConnection();
				
			String sql = "select p.purchase_date, p.purchase_price, a.use_point\r\n" + 
					"from purchase p, point_log a\r\n" + 
					"where p.purchase_code = a.purchase_code\r\n" + 
					"and p.customer_tel=?\r\n" + 
					"and substring(a.use_point,'1','1')= '+';";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, customer_tel);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				jsonObject = new JSONObject();
				jsonObject.put("purchase_date",rs.getTimestamp("p.purchase_date"));
				jsonObject.put("purchase_price",rs.getString("p.purchase_price"));
				jsonObject.put("add_point",rs.getString("a.use_point"));
				jsonArray.add(jsonObject);
			}
		}catch(Exception e) {
			System.out.println("고객 결제 내역 조회에 문제가 있습니다.");
		}finally {
			if(rs!=null)try {rs.close();}catch(Exception e) {}
			if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
			if(conn!=null)try {conn.close();}catch(Exception e) {}
		}
		return jsonArray;
	}
	
	//고객 포인트 내역 조회
		public JSONArray selectPoint(String customer_tel){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			JSONObject jsonObject;
			JSONArray jsonArray = new JSONArray();
				
			try {
				conn = getConnection();
					
				String sql = "select use_date,use_point from point_log where customer_tel=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, customer_tel);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					jsonObject = new JSONObject();
					jsonObject.put("use_date",rs.getTimestamp("use_date"));
					jsonObject.put("use_point",rs.getString("use_point"));
					jsonArray.add(jsonObject);
				}
			}catch(Exception e) {
				System.out.println("고객 포인트 내역 조회에 문제가 있습니다.");
			}finally {
				if(rs!=null)try {rs.close();}catch(Exception e) {}
				if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
				if(conn!=null)try {conn.close();}catch(Exception e) {}
			}
			return jsonArray;
		}
}
