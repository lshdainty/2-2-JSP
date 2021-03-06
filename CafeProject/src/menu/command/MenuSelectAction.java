package menu.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import menu.bean.MenuDBBean;
import mlogin.command.CommandAction;

public class MenuSelectAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable{
		request.setCharacterEncoding("utf-8");	//인코딩
		
		String product_name = request.getParameter("product_name");
		
		//db와 연동해서 사용자의 인증을 처리
		MenuDBBean dbPro = MenuDBBean.getInstance();
		
		//해당 뷰로 보낼 내용을 request 속성에 지정
		request.setAttribute("mlist",dbPro.selectMenu(product_name));
		return "/html/menu/menuSelect.jsp";
	}
}