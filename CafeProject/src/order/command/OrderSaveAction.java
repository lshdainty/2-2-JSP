package order.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.bean.CustomerDBBean;
import menu.bean.MenuDBBean;
import mlogin.command.CommandAction;
import order.bean.OrderDBBean;

public class OrderSaveAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable{
		request.setCharacterEncoding("utf-8");	//인코딩
		
		String save = request.getParameter("save");	//포인트 적립 %
		
		//db와 연동해서 사용자의 인증을 처리
		OrderDBBean dbPro = OrderDBBean.getInstance();
		int dbSave = dbPro.selectSave();
		if(save!=null||save!="") {
			dbPro.updateSave(Integer.parseInt(save), dbSave);
		}
		
		//해당 뷰로 보낼 내용을 request 속성에 지정		
		request.setAttribute("save",dbPro.selectSave());
		
		return "/html/order/orderSelect.jsp";
	}
}