package order.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.bean.CustomerDBBean;
import menu.bean.MenuDBBean;
import mlogin.command.CommandAction;
import order.bean.OrderDBBean;

public class OrderStandardAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable{
		request.setCharacterEncoding("utf-8");	//인코딩
		
		String standard = request.getParameter("standard");	//포인트 사용 가능 기준
		
		//db와 연동해서 사용자의 인증을 처리
		OrderDBBean dbPro = OrderDBBean.getInstance();
		int dbStandard = dbPro.selectStandard();
		if(standard!=null||standard!="") {
			dbPro.updateStandard(Integer.parseInt(standard), dbStandard);
		}

		//해당 뷰로 보낼 내용을 request 속성에 지정
		request.setAttribute("standard",dbPro.selectStandard());		
		
		return "/html/order/orderSelect.jsp";
	}
}