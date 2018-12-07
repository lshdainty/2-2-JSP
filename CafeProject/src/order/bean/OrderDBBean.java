package order.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class OrderDBBean {
	//싱글톤 
	private static OrderDBBean instance = new OrderDBBean();
	
	public static OrderDBBean getInstance() {
		return instance;
	}
	
	private OrderDBBean() {}
	
	//커넥션 풀 객체 생성
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/cafe");
		return ds.getConnection();
	}
	
	public void insertPurchase(String purchase_code, String customer_tel,int purchase_price) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			if((customer_tel==null)||(customer_tel=="")) {
				String sql = "insert into purchase(purchase_code,purchase_price) values(?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, purchase_code);
				pstmt.setInt(2, purchase_price);
				pstmt.executeQuery();
			}else {
				String sql = "insert into purchase(purchase_code,customer_tel,purchase_price) values(?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, purchase_code);
				pstmt.setString(2, customer_tel);
				pstmt.setInt(3, purchase_price);
				pstmt.executeQuery();
			}
		}catch(Exception e) {
			System.out.println("오류가 있습니다.");
		}finally {
			if(rs!=null)try {rs.close();}catch(Exception e) {}
			if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
			if(conn!=null)try {conn.close();}catch(Exception e) {}
		}
	}
	
	public void insertPoint_log(String customer_tel, String purchase_code, String sprice) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			
			String sql = "insert into point_log(customer_tel,purchase_code,use_point) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, customer_tel);
			pstmt.setString(2, purchase_code);
			pstmt.setString(3, sprice);
			rs = pstmt.executeQuery();
		}catch(Exception e) {
			System.out.println("point오류가 있습니다.");
		}finally {
			if(rs!=null)try {rs.close();}catch(Exception e) {}
			if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
			if(conn!=null)try {conn.close();}catch(Exception e) {}
		}
	}
	
	public void updatePoint(int point , String customer_tel) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			
			String sql = "update customer set point = ? where customer_tel = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, point);
			pstmt.setString(2, customer_tel);
			rs = pstmt.executeQuery();
		}catch(Exception e) {
			System.out.println("point오류가 있습니다.");
		}finally {
			if(rs!=null)try {rs.close();}catch(Exception e) {}
			if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
			if(conn!=null)try {conn.close();}catch(Exception e) {}
		}
	}
}