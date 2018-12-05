package menu.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class MenuDBBean {
	//싱글톤 
	private static MenuDBBean instance = new MenuDBBean();
	
	public static MenuDBBean getInstance() {
		return instance;
	}
	
	private MenuDBBean() {}
	
	//커넥션 풀 객체 생성
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/cafe");
		return ds.getConnection();
	}
	
	//특정 물품 조회
	public JSONArray selectUser(String product_name){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JSONObject jsonObject;
		JSONArray jsonArray = new JSONArray();
			
		try {
			conn = getConnection();
				
			String sql = "select * from product where product_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product_name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				jsonObject = new JSONObject();
				jsonObject.put("product_number",rs.getInt("product_number"));
				jsonObject.put("product_name",rs.getString("product_name"));
				jsonObject.put("product_price",rs.getInt("product_price"));
				jsonObject.put("pgroup_code",rs.getString("pgroup_code"));
				jsonObject.put("product_picture","/CafeProject/upload/"+rs.getString("product_picture"));
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
	
	//제품 추가
	public void insertMenu(String product_name, int product_price, String pgroup_code, String product_picture) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			
			///*maria db용
			String sql = "insert into product(product_name,product_price,pgroup_code,product_picture) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product_name);
			pstmt.setInt(2, product_price);
			pstmt.setString(3, pgroup_code);
			pstmt.setString(4, product_picture);
			pstmt.executeUpdate();
			//*/
			
			/*oracle
			String sql = "insert into manager values(mid.nextval,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, manager_name);
			pstmt.setString(2, manager_passwd);
			pstmt.setString(3, manager_tel);
			pstmt.executeUpdate();
			*/
		}catch(Exception e) {
			System.out.println("오류가 있습니다.");
		}finally {
			if(rs!=null)try {rs.close();}catch(Exception e) {}
			if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
			if(conn!=null)try {conn.close();}catch(Exception e) {}
		}
	}
	
	//제품 수정
	public void updateMenu(int product_number, String product_name, int product_price,String pgroup_code,String product_picture) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
					
			String sql = "update product set product_name=?, product_price=?, pgroup_code=?, product_picture=? where product_number=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product_name);
			pstmt.setInt(2, product_price);
			pstmt.setString(3, pgroup_code);
			pstmt.setString(4, product_picture);
			pstmt.setInt(5, product_number);
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("오류가 있습니다.");
		}finally {
			if(rs!=null)try {rs.close();}catch(Exception e) {}
			if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
			if(conn!=null)try {conn.close();}catch(Exception e) {}
		}
	}
	
	//전체 제품 조회
	public JSONArray allUser(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JSONObject jsonObject;
		JSONArray jsonArray = new JSONArray();
		
		try {
			conn = getConnection();
			
			String sql = "select * from product";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				jsonObject = new JSONObject();
				jsonObject.put("product_number",rs.getInt("product_number"));
				jsonObject.put("product_name",rs.getString("product_name"));
				jsonObject.put("product_price",rs.getInt("product_price"));
				jsonObject.put("pgroup_code",rs.getString("pgroup_code"));
				jsonObject.put("product_picture","/CafeProject/upload/"+rs.getString("product_picture"));
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
	
	//제품 삭제
	public void deleteMenu(int product_number) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			
			String sql = "delete from product where product_number=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product_number);
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