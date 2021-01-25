package studentServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bao.Job;
import studentservice.IStudentService;
import studentservice.StudentServiceImpl;

/**
 * Servlet implementation class findJobby
 */
/*查询特定的工作*/
public class findJobby extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("该页面");
		IStudentService iStudentService=new StudentServiceImpl();// 学生的操作
		List<Job> jobstemp=null;
		String sql="select * from jobinfo where jobaddr like ?";
		if(request.getParameter("judge").equals("addr"))// 地址查询
		{
			
			Object object[]={request.getParameter("text")};
		    jobstemp=iStudentService.findJobs(sql, object);
		    System.out.println("aadr");
			request.setAttribute("jobstemp",jobstemp);
			request.getRequestDispatcher("student/findJob.jsp").forward(request, response);// 将查询到的工作放回到页面
		}
		else if(request.getParameter("judge").equals("post"))// 职位查询
		{
			sql="select * from jobinfo where post like ?";
			Object object[]={request.getParameter("text")};
			iStudentService.findJobs(sql, object);
			System.out.println("post");
			request.setAttribute("jobstemp",jobstemp);
			request.getRequestDispatcher("student/findJob.jsp").forward(request, response);// 将查询到的工作放回到页面
		}
		else if(request.getParameter("judge").equals("salary"))// 薪水查询
		{
			 sql="select * from jobinfo where salary=?";
			Object object[]={request.getParameter("text")};
			iStudentService.findJobs(sql, object);
			System.out.println("salary");
			request.setAttribute("jobstemp",jobstemp);
			request.getRequestDispatcher("student/findJob.jsp").forward(request, response);// 将查询到的工作放回到页面
		}
		else {
			System.out.println("流转过来的为空值");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
