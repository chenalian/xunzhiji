package enterpriceServelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enterpriceService.EnterpriceImpl;
import enterpriceService.IEnterpriceService;

/**
 * Servlet implementation class QDeleteJobs
 */
// É¾³ý¹¤×÷Ò³Ãæ
public class QupdateJL extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// ÉèÖÃ±àÂë
		
		IEnterpriceService iEnterpriceService=new EnterpriceImpl();
		
		String sql="update applyjob set state=? where jobid=?";
		
		Object object[]= {request.getParameter("jobidtemp")};
		boolean result=iEnterpriceService.deleteJobs(sql, object);
		
		if(result)System.out.println("É¾³ý³É¹¦");
		else System.out.println("É¾³ýÊ§°Ü");
		response.sendRedirect("enterprice/user.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
