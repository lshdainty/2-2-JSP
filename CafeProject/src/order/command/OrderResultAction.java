package order.command;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.bean.CustomerDBBean;
import menu.bean.MenuDBBean;
import mlogin.command.CommandAction;
import order.bean.OrderDBBean;

public class OrderResultAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable{
		request.setCharacterEncoding("utf-8");	//인코딩
		
		Random r = new Random();
		int code =r.nextInt(100000);	//난수 발생으로 주문코드 생성
		
//*******************************************************************************
		
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyyMMdd", Locale.KOREA );
		Date currentTime = new Date ();
		String mTime = mSimpleDateFormat.format (currentTime);
		String purchase_code = mTime + code;	//주문코드 생성
		while(purchase_code.length()>=13) {
			purchase_code = purchase_code + "0";
		}

//*******************************************************************************
		
		int purchase_price = Integer.parseInt(request.getParameter("purchase_price"));	//결제가격
		String customer_tel = request.getParameter("customer_tel");	//고객 전화번호
		int point = Integer.parseInt(request.getParameter("point"));	//고객이 보유한 포인트
		String usepoint = request.getParameter("sprice");	//고객이 사용한 포인트
		String addpoint = "";
	
//*******************************************************************************
		
		//db와 연동해서 정보처리
		OrderDBBean dbPro = OrderDBBean.getInstance();
		dbPro.insertPurchase(purchase_code, customer_tel, purchase_price);
		if((customer_tel!=null)&&(customer_tel!="")) {	//휴대폰 번호가 null값이 아니면 회원이므로 포인트를 적립한다.
			addpoint = "+" + (int)(purchase_price * 0.1);
			dbPro.insertPoint_log(customer_tel, purchase_code, addpoint);	//사용자에게 들어온 포인트 내역 기록
			dbPro.updatePoint(point+(int)(purchase_price * 0.1), customer_tel);	//사용자에게 적립된 포인트 업데이트
			System.out.println(point+(int)(purchase_price * 0.1));
		}
		if(!usepoint.equals("0")&&!usepoint.equals("")) {	//사용 포인트가 0이 아니면 포인트를 사용한것이므로 기록한다.
			usepoint = "-" + usepoint;
			dbPro.insertPoint_log(customer_tel,purchase_code,usepoint);	//사용자가 사용한 포인트 내역 기록
			dbPro.updatePoint(point-Integer.parseInt(usepoint), customer_tel);	//고객 포인트 업데이트
		}
		CustomerDBBean dbCPro = CustomerDBBean.getInstance();
		MenuDBBean dbMPro = MenuDBBean.getInstance();
		request.setAttribute("clist",dbCPro.allUser());
		request.setAttribute("mlist",dbMPro.allMenu());
		
		return "/html/order/orderSelect.jsp";
	}
}