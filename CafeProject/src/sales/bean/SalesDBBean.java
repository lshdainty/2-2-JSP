package sales.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class SalesDBBean {
	
	
	
	//싱글톤 
		private static SalesDBBean instance = new SalesDBBean();
		
		public static SalesDBBean getInstance() {
			return instance;
		}
		
		private SalesDBBean() {}
		
		//커넥션 풀 객체 생성
		private Connection getConnection() throws Exception{
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/cafe");
			return ds.getConnection();
		}
		
		//월별 총 매출 조회
		public JSONArray allSales(){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			JSONObject jsonObject;
			JSONArray jsonArray = new JSONArray();
			
			//현재 연도를 저장
			Date today = new Date();
			SimpleDateFormat date = new SimpleDateFormat("yyyy");
			String year = date.format(today);
		
			try {
				conn = getConnection();
				
				String sql = "select substring(purchase_date, 1, 7) as month,\r\n" + 
						"month(purchase_date),\r\n" + 
						"sum(purchase_price) as totalSales\r\n" + 
						"from purchase\r\n" + 
						"where purchase_date like ?\r\n" + 
						"group by month";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, year+"%");
				
				rs = pstmt.executeQuery(); 
				
				while(rs.next()) {
					jsonObject = new JSONObject();
					jsonObject.put("month", rs.getString("month"));
					jsonObject.put("totalSales", rs.getInt("totalSales"));
					jsonArray.add(jsonObject);
				}
			}catch(Exception e) {
				System.out.println("매출 조회 오류가 있습니다.");
			}finally {
				if(rs!=null)try {rs.close();}catch(Exception e) {}
				if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
				if(conn!=null)try {conn.close();}catch(Exception e) {}
			}
			return jsonArray;
		}

		
		//특정 연도 조회
		public Object selectYear(String year) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			JSONObject jsonObject;
			JSONArray jsonArray = new JSONArray();
		
			try {
				conn = getConnection();
				
				String sql = "select substring(purchase_date, 1, 7) as month,\r\n" + 
						"month(purchase_date),\r\n" + 
						"sum(purchase_price) as totalSales\r\n" + 
						"from purchase\r\n" + 
						"where purchase_date like ?\r\n" + 
						"group by month";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, year+"%");
				
				rs = pstmt.executeQuery(); 
				
				while(rs.next()) {
					jsonObject = new JSONObject();
					jsonObject.put("month", rs.getString("month"));
					jsonObject.put("totalSales", rs.getInt("totalSales"));
					jsonArray.add(jsonObject);
				}
			}catch(Exception e) {
				System.out.println("연도 조회 오류가 있습니다.");
				e.printStackTrace();
			}finally {
				if(rs!=null)try {rs.close();}catch(Exception e) {}
				if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
				if(conn!=null)try {conn.close();}catch(Exception e) {}
			}
			return jsonArray;
		}
		
}
