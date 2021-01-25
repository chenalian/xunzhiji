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
 * Servlet implementation class SearchJobs
 */

// 查询所有已经发布的工作返回到百度地图API中，显示出来
public class SearchJobs extends HttpServlet {	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		System.out.println("百度API页面");
		
		/*系统功能*/ 
		ISystem iSystem=new SystemImpl();
		String sql="select * from jobinfo where pstate='1'";
		List <Job> searchjobs=iSystem.queryAllJobs(sql, null);
		request.setAttribute("searchjobs",searchjobs);
		if(searchjobs==null)System.out.println("searchjobs为空");
		request.getRequestDispatcher("student/studentsearchjob.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
