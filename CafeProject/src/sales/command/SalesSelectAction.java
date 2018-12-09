package sales.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mlogin.command.CommandAction;
import sales.bean.SalesDBBean;

public class SalesSelectAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	
		//사용자 연도 입력값(파라미터로)을 받아옴
		String year = request.getParameter("year");
		
		// db와 연동해서 사용자의 인증을 처리
		SalesDBBean dbPro = SalesDBBean.getInstance();

		// 해당 뷰로 보낼 내용을 request 속성에 지정
		request.setAttribute("slist", dbPro.selectYear(year));

		return "/html/sales/salesSelect.jsp";
	}
	
}
