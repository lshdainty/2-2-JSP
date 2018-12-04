package employee.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class EmployeeDBBean {
	//싱글톤 
	private static EmployeeDBBean instance = new EmployeeDBBean();
	
	public static EmployeeDBBean getInstance() {
		return instance;
	}
	
	private EmployeeDBBean() {}
	
	//커넥션 풀 객체 생성
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/cafe");
		return ds.getConnection();
	}
	
	//특정 직원 조회
	public JSONArray selectUser(String manager_name){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JSONObject jsonObject;
		JSONArray jsonArray = new JSONArray();
			
		try {
			conn = getConnection();
				
			String sql = "select * from manager where manager_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, manager_name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				jsonObject = new JSONObject();
				jsonObject.put("manager_code",rs.getInt("manager_code"));
				jsonObject.put("manager_name",rs.getString("manager_name"));
				jsonObject.put("manager_passwd",rs.getString("manager_passwd"));
				jsonObject.put("manager_tel",rs.getString("manager_tel"));
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
	
	//직원 추가
	public void insertManager(String manager_name, String manager_passwd, String manager_tel) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			
			///*maria db용
			String sql = "insert into manager(manager_name,manager_passwd,manager_tel) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, manager_name);
			pstmt.setString(2, manager_passwd);
			pstmt.setString(3, manager_tel);
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
	
	//직원 수정
		public void updateEmployee(int manager_code, String manager_name,String manager_passwd,String manager_tel) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = getConnection();
					
				String sql = "update manager set manager_name=?,manager_passwd=?,manager_tel=? where manager_code=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, manager_name);
				pstmt.setString(2, manager_passwd);
				pstmt.setString(3, manager_tel);
				pstmt.setInt(4, manager_code);
				pstmt.executeUpdate();
			}catch(Exception e) {
				System.out.println("오류가 있습니다.");
			}finally {
				if(rs!=null)try {rs.close();}catch(Exception e) {}
				if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
				if(conn!=null)try {conn.close();}catch(Exception e) {}
			}
		}
	
	//전체 직원 조회
	public JSONArray allUser(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JSONObject jsonObject;
		JSONArray jsonArray = new JSONArray();
		
		try {
			conn = getConnection();
			
			String sql = "select * from manager";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				jsonObject = new JSONObject();
				jsonObject.put("manager_code",rs.getInt("manager_code"));
				jsonObject.put("manager_name",rs.getString("manager_name"));
				jsonObject.put("manager_passwd",rs.getString("manager_passwd"));
				jsonObject.put("manager_tel",rs.getString("manager_tel"));
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
	public void deleteManager(String manager_code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int deleteId = Integer.parseInt(manager_code);
		try {
			conn = getConnection();
			
			String sql = "delete from manager where manager_code=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deleteId);
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