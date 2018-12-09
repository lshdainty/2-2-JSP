package clogin.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clogin.bean.CLoginDBBean;
import mlogin.command.CommandAction;

public class CustomerLoginProAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable{
		request.setCharacterEncoding("utf-8");	//인코딩
		
		//넘어온 요청의 데이터를 얻어냄
		String customer_name = request.getParameter("customer_name");
		String customer_tel = request.getParameter("customer_tel");
		
		//db와 연동해서 사용자의 인증을 처리
		CLoginDBBean dbPro = CLoginDBBean.getInstance();
		int check = dbPro.userCheck(customer_name, customer_tel);
		
		//해당 뷰로 보낼 내용을 request 속성에 지정
		request.setAttribute("check", check);
		request.setAttribute("tel", customer_tel);
		request.setAttribute("cname", customer_name);
		request.setAttribute("pay", dbPro.selectPay(customer_tel));
		request.setAttribute("point", dbPro.selectPoint(customer_tel));
		
		return "/html/clogin/cLoginPro.jsp";
	}
}