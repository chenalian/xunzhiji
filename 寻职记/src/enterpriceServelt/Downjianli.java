package enterpriceServelt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enterpriceService.EnterpriceImpl;
import enterpriceService.IEnterpriceService;

/**
 * Servlet implementation class Downjianli
 */
// 下载简历
public class Downjianli extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("跳转到文件下载页面");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// 根据jobid qid uid 将简历查询出来
		IEnterpriceService iEnterpriceService=new EnterpriceImpl();
		
		String sql="select * from applyjob where jobid=? and qid=? and uid=?";
		Object object[]= {request.getParameter("jobid"),request.getParameter("qid"),request.getParameter("uid")};
		
		File temp=new File("C:\\Users\\Public\\Downloads","temp.doc");
		
		FileOutputStream out =new FileOutputStream(temp);
		
	
		
		out.write(iEnterpriceService.queryJianli(sql, object));
		// 文件已.doc 形式存入 Downloads文件夹下面 
		
		response.sendRedirect("enterprice/user.jsp");
		
//		iEnterpriceService.queryJianli(sql, object);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
