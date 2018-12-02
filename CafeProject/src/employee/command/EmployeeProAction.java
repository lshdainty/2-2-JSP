package employee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.bean.EmployeeDBBean;
import mlogin.command.CommandAction;

public class EmployeeProAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable{
		request.setCharacterEncoding("utf-8");	//인코딩
		
		//db와 연동해서 사용자의 인증을 처리
		EmployeeDBBean dbPro = EmployeeDBBean.getInstance();
		
		//해당 뷰로 보낼 내용을 request 속성에 지정
		request.setAttribute("elist",dbPro.allUser());
		
		return "/html/employee/employeeSelect.jsp";
	}
}