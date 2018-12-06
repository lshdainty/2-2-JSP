package menu.command;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import menu.bean.MenuDBBean;
import mlogin.command.CommandAction;

public class MenuUpdateAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable{
		String realFolder="";	//웹 애플리케이션 절대경로
		String saveFolder="/upload";	//파일이 저장되는 폴더명
		String encType="utf-8";	//인코딩
		int maxSize=10*1024*1024;	//최대 파일 업로드 크기
		String name="";	//파라미터명
		String pgroup_code="";	//그룹코드
		int product_price=0;	//상품가격
		String product_name="";	//상품이름
		String product_picture="";	//서버에 저장된 이미지명
		int product_number=0;
		String backup_image_name="";	//수정시 기본 올라와있는 사진명
		MultipartRequest upload = null;
		
		ServletContext context = request.getSession().getServletContext();
		realFolder = context.getRealPath(saveFolder);
		
		try {
			upload = new MultipartRequest(request,realFolder,maxSize,encType,new DefaultFileRenamePolicy());
			
			//이미지가 아닌 나머지 text부분
			pgroup_code = upload.getParameter("pgroup_code");
			product_price = Integer.parseInt(upload.getParameter("product_price"));
			product_name = upload.getParameter("product_name");
			product_number = Integer.parseInt(upload.getParameter("product_number"));
			backup_image_name = upload.getParameter("backup_image_name");
			backup_image_name = backup_image_name.substring(backup_image_name.lastIndexOf("/")+1);
			
			//이미지 업로드부분
			Enumeration<?> files = upload.getFileNames();
			while(files.hasMoreElements()) {
				name = (String)files.nextElement();	//파라미터명
				product_picture = upload.getFilesystemName(name);	//서버 업로드명
			}
			if(product_picture.equals("")||product_picture==null) {
				product_picture = backup_image_name;
			}
		}catch(Exception e) {
			
		}

		MenuDBBean dbPro = MenuDBBean.getInstance();
		dbPro.updateMenu(product_number,product_name, product_price, pgroup_code, product_picture);
		request.setAttribute("mlist",dbPro.allMenu());
		
		return "/html/menu/menuSelect.jsp";
	}
}