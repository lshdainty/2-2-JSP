package employee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mlogin.command.CommandAction;
import mlogin.bean.MngrDBBean;

public class EmployeeAddAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable{
		request.setCharacterEncoding("utf-8");	//인코딩
		
		//넘어온 요청의 데이터를 얻어냄
		String name = request.getParameter("name");
		String passwd = request.getParameter("passwd");
		System.out.println("name,passwd받아오기 성공");
		
		//db와 연동해서 사용자의 인증을 처리
		MngrDBBean dbPro = MngrDBBean.getInstance();
		dbPro.insertManager(name, passwd);
		System.out.println("insert 성공");
		
		return "/html/employee/employeeInsert.jsp";
	}
}