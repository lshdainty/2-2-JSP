package clogin.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clogin.bean.CLoginDBBean;
import mlogin.command.CommandAction;
import employee.bean.EmployeeDBBean;

public class CustomerAddAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable{
		request.setCharacterEncoding("utf-8");	//인코딩
		
		//넘어온 요청의 데이터를 얻어냄
		String customer_name = request.getParameter("customer_name");
		String customer_tel = request.getParameter("customer_tel");
		
		//db와 연동해서 사용자의 인증을 처리
		CLoginDBBean dbPro = CLoginDBBean.getInstance();
		request.getSession().setAttribute("cMemberCheck",dbPro.userAdd(customer_name, customer_tel));
		
		return null;
	}
}