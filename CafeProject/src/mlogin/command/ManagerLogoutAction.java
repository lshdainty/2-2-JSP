package mlogin.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManagerLogoutAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request ,HttpServletResponse response) throws Throwable{
		return "/html/mlogin/mLogout.jsp";
	}
}