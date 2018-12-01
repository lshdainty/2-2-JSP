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
		String name = request.getParameter("name");
		String passwd = request.getParameter("passwd");
		
		//db와 연동해서 사용자의 인증을 처리
		EmployeeDBBean dbPro = EmployeeDBBean.getInstance();
		dbPro.insertManager(name, passwd);
		request.setAttribute("list",dbPro.allUser());
		
		return "/html/employee/employeeSelect.jsp";
	}
}