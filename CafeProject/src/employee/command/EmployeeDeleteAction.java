package employee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.bean.EmployeeDBBean;
import mlogin.command.CommandAction;

public class EmployeeDeleteAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable{
		request.setCharacterEncoding("utf-8");	//인코딩
		
		//넘어온 요청의 데이터를 얻어냄
		String manager_code = request.getParameter("manager_code");
		
		//db와 연동해서 사용자의 인증을 처리
		EmployeeDBBean dbPro = EmployeeDBBean.getInstance();
		dbPro.deleteManager(manager_code);
		request.setAttribute("elist",dbPro.allUser());
		
		return "/html/employee/employeeSelect.jsp";
	}
}