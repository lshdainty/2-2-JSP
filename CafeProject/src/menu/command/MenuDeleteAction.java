package menu.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import menu.bean.MenuDBBean;
import mlogin.command.CommandAction;

public class MenuDeleteAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable{
		request.setCharacterEncoding("utf-8");	//인코딩
		
		//넘어온 요청의 데이터를 얻어냄
		int product_number = Integer.parseInt(request.getParameter("product_number"));
		
		//db와 연동해서 사용자의 인증을 처리
		MenuDBBean dbPro = MenuDBBean.getInstance();
		dbPro.deleteMenu(product_number);
		request.setAttribute("mlist",dbPro.allUser());
		
		return "/html/menu/menuSelect.jsp";
	}
}