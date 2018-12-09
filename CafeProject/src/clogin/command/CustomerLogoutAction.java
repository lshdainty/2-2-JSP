package clogin.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mlogin.command.CommandAction;

public class CustomerLogoutAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request ,HttpServletResponse response) throws Throwable{
		return "/html/clogin/cLogout.jsp";
	}
}
