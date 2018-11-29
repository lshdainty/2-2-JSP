package sales.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mlogin.command.CommandAction;

public class SalesMainFormAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable{
		return "/html/sales/salesMain.jsp";	//응답 페이지
	}
}
