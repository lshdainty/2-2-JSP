package mlogin.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.bean.CustomerDBBean;
import menu.bean.MenuDBBean;
import mlogin.bean.MngrDBBean;
import order.bean.OrderDBBean;

public class ManagerLoginProAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable{
		request.setCharacterEncoding("utf-8");	//인코딩
		
		//넘어온 요청의 데이터를 얻어냄
		int manager_code = Integer.parseInt(request.getParameter("managerCode"));
		String manager_passwd = request.getParameter("managerPasswd");
		
		//db와 연동해서 사용자의 인증을 처리
		MngrDBBean dbPro = MngrDBBean.getInstance();
		int check = dbPro.userCheck(manager_code, manager_passwd);
		int authority = dbPro.authorityCheck(manager_code);
		
		CustomerDBBean dbCPro = CustomerDBBean.getInstance();
		MenuDBBean dbMPro = MenuDBBean.getInstance();
		OrderDBBean dbOPro = OrderDBBean.getInstance();
				
		request.setAttribute("clist",dbCPro.allUser());
		request.setAttribute("mlist",dbMPro.allMenu());
		request.setAttribute("standard", dbOPro.selectStandard());
		request.setAttribute("save", dbOPro.selectSave());
		
		//해당 뷰로 보낼 내용을 request 속성에 지정
		request.setAttribute("check", new Integer(check));
		request.setAttribute("id", manager_code);
		request.setAttribute("authority", authority);
		
		return "/html/mlogin/mLoginPro.jsp";
	}
}
