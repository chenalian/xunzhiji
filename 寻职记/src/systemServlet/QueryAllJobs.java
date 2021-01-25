package systemServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bao.Job;
import systemService.ISystem;
import systemService.SystemImpl;

/**
 * Servlet implementation class QueryAllJobs
 */
public class QueryAllJobs extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		/*系统功能*/ 
		ISystem iSystem=new SystemImpl();
		String sql="select * from jobinfo where pstate='1'";
		List <Job> jobs=iSystem.queryAllJobs(sql, null);
		request.setAttribute("jobs",jobs);
		if(jobs==null)System.out.println("jobs为空");
		request.getRequestDispatcher("main3.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
