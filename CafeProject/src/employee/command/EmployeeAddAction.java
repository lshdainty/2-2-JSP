package employee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mlogin.command.CommandAction;
import employee.bean.EmployeeDBBean;

public class EmployeeAddAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable{
		request.setCharacterEncoding("utf-8");	//인코딩
		
		//넘어온 요청의 데이터를 얻어냄
		String manager_name = request.getParameter("manager_name");
		String manager_passwd = request.getParameter("manager_passwd");
		String manager_tel = request.getParameter("manager_tel");
		
		//db와 연동해서 사용자의 인증을 처리
		EmployeeDBBean dbPro = EmployeeDBBean.getInstance();
		dbPro.insertManager(manager_name, manager_passwd, manager_tel);
		request.setAttribute("elist",dbPro.allUser());
		
		return "/html/employee/employeeSelect.jsp";
	}
}