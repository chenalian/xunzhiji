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
 * Servlet implementation class PassJobs
 */
public class PassJobs extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取所用管理员通过id1号
		System.out.println("跳转到高该液面");
		List<Job> jobs=(List<Job>)request.getSession().getAttribute("jobs");
		Object object[]=new Object[1];
		/*管理员操作功能*/
		IAdministrator iAdministrator=new AdministratorImpl();
		String sql="";
		for(Job job:jobs)
		{
			if(request.getParameter(job.getJobid())!=null)
			{
				// 是管理员发送过来
				if(request.getParameter(job.getJobid()).equals("tg"))//表示管理员已经设置为应通过审核状态
				{
					System.out.println("已经修改该工作状态"+job.getJobid());
					sql="update jobinfo set pstate='1' where jobid=?";
					object[0]=job.getJobid();
					boolean result=iAdministrator.setJobState(sql, object);
					if(result)System.out.println("修改成功");
				}
			}
		}
		response.sendRedirect("administrator/user.jsp");//../systemServlet/
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
