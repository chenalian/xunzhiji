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
// 删除工作页面
public class QDeleteJobs extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 设置编码
		
		System.out.println("商家删除工作页面"+request.getParameter("jobidtemp")+"        #############");
		IEnterpriceService iEnterpriceService=new EnterpriceImpl();
		String sql="delete from jobinfo where jobid=?";
		Object object[]= {request.getParameter("jobidtemp")};
		boolean result=iEnterpriceService.deleteJobs(sql, object);
		if(result)System.out.println("删除成功");
		else System.out.println("删除失败");
		response.sendRedirect("enterprice/user.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
