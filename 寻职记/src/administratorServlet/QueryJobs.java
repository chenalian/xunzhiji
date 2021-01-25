package administratorServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bao.Job;
import administratorService.AdministratorImpl;
import administratorService.IAdministrator;

/**
 * Servlet implementation class QueryJobs
 */
public class QueryJobs extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IAdministrator iAdministrator=new AdministratorImpl();
		String sql="select * from jobinfo where pstate='0'";
		List<Job> jobs= iAdministrator.receive(sql, null);
		if(jobs==null)System.out.println("jobs为空");
		request.getSession().setAttribute("jobs",jobs);
		request.getRequestDispatcher("administrator/checkJobs.jsp").forward(request, response);
		/*将商家申请的工作全部流向杀怪加处理审核工作页面*/
//		request.getRequestDispatcher("../main.jsp").forward(request, response);
//		response.sendRedirect("administrator/checkJobs.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
