package customer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.bean.CustomerDBBean;
import mlogin.command.CommandAction;

public class CustomerDeleteAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable{
		request.setCharacterEncoding("utf-8");	//인코딩
		
		//넘어온 요청의 데이터를 얻어냄
		String customer_tel = request.getParameter("customer_tel");
		
		//db와 연동해서 사용자의 인증을 처리
		CustomerDBBean dbPro = CustomerDBBean.getInstance();
		dbPro.deleteCustomer(customer_tel);
		request.setAttribute("clist",dbPro.allUser());
		
		return "/html/customer/customerSelect.jsp";
	}
}