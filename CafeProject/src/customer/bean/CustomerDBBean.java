package customer.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CustomerDBBean {
	//싱글톤 
	private static CustomerDBBean instance = new CustomerDBBean();
	
	public static CustomerDBBean getInstance() {
		return instance;
	}
	
	private CustomerDBBean() {}
	
	//커넥션 풀 객체 생성
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/cafe");
		return ds.getConnection();
	}
	
	//특정 고객 조회
	public JSONArray selectUser(String customer_tel){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JSONObject jsonObject;
		JSONArray jsonArray = new JSONArray();
			
		try {
			conn = getConnection();
				
			String sql = "select * from customer where customer_tel = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, customer_tel);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				jsonObject = new JSONObject();
				jsonObject.put("customer_tel",rs.getString("customer_tel"));
				jsonObject.put("customer_name",rs.getString("customer_name"));
				jsonObject.put("point",rs.getInt("point"));
				jsonArray.add(jsonObject);
			}
		}catch(Exception e) {
			System.out.println("오류가 있습니다.");
		}finally {
			if(rs!=null)try {rs.close();}catch(Exception e) {}
			if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
			if(conn!=null)try {conn.close();}catch(Exception e) {}
		}
		return jsonArray;
	}
	
	//고객 추가
	public void insertCustomer(String customer_tel, String customer_name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			
			String sql = "insert into customer values(?,?,0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, customer_tel);
			pstmt.setString(2, customer_name);
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("오류가 있습니다.");
		}finally {
			if(rs!=null)try {rs.close();}catch(Exception e) {}
			if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
			if(conn!=null)try {conn.close();}catch(Exception e) {}
		}
	}
	
	//고객 수정
	public void updateCustomer(String customer_tel,String customer_newTel,String customer_name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
				
			String sql = "update customer set customer_tel=?,customer_name=? where customer_tel=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, customer_newTel);
			pstmt.setString(2, customer_name);
			pstmt.setString(3, customer_tel);
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("오류가 있습니다.");
		}finally {
			if(rs!=null)try {rs.close();}catch(Exception e) {}
			if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
			if(conn!=null)try {conn.close();}catch(Exception e) {}
		}
	}
	
	//전체 고객 조회
	public JSONArray allUser(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JSONObject jsonObject;
		JSONArray jsonArray = new JSONArray();
		
		try {
			conn = getConnection();
			
			String sql = "select * from customer";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				jsonObject = new JSONObject();
				jsonObject.put("customer_tel",rs.getString("customer_tel"));
				jsonObject.put("customer_name",rs.getString("customer_name"));
				jsonObject.put("point",rs.getInt("point"));
				jsonArray.add(jsonObject);
			}
		}catch(Exception e) {
			System.out.println("오류가 있습니다.");
		}finally {
			if(rs!=null)try {rs.close();}catch(Exception e) {}
			if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
			if(conn!=null)try {conn.close();}catch(Exception e) {}
		}
		return jsonArray;
	}
	
	//직원 삭제
	public void deleteCustomer(String customer_tel) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			
			String sql = "delete from customer where customer_tel=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, customer_tel);
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("오류가 있습니다.");
		}finally {
			if(rs!=null)try {rs.close();}catch(Exception e) {}
			if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
			if(conn!=null)try {conn.close();}catch(Exception e) {}
		}
	}
}