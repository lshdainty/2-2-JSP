package order.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.bean.CustomerDBBean;
import menu.bean.MenuDBBean;
import mlogin.command.CommandAction;
import order.bean.OrderDBBean;

public class OrderProAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable{
		request.setCharacterEncoding("utf-8");	//인코딩
		
		//db와 연동해서 사용자의 인증을 처리
		CustomerDBBean dbCPro = CustomerDBBean.getInstance();
		MenuDBBean dbMPro = MenuDBBean.getInstance();
		OrderDBBean dbPro = OrderDBBean.getInstance();
		
		//해당 뷰로 보낼 내용을 request 속성에 지정
		request.setAttribute("clist",dbCPro.allUser());
		request.setAttribute("mlist",dbMPro.allMenu());
		request.setAttribute("standard", dbPro.selectStandard());
		request.setAttribute("save", dbPro.selectSave());
		
		return "/html/order/orderSelect.jsp";
	}
}