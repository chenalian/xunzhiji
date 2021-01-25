package studentServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bao.ApplyJob;
import Bao.Job;
import studentservice.IStudentService;
import studentservice.StudentServiceImpl;

/**
 * Servlet implementation class findapplystate
 */
/*
 * 查询提交的简历的状态
 * */
public class findapplystate extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IStudentService iStudentService=new StudentServiceImpl();// 学生的操作
		
		String sql="select * from applyjob where uid=?";
		Object object[]= {request.getSession().getAttribute("uid")};
		List<ApplyJob> applyjobs=iStudentService.findJLstate(sql, object);
		// 获取到申请的工作
		if(applyjobs==null)System.out.println("applyjobs为空");
		
//		else System.out.println(applyjobs.size());
		request.setAttribute("applyjobs",applyjobs);
		request.getRequestDispatcher("student/findApplyJobs.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
