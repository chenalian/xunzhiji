package studentServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentservice.IStudentService;
import studentservice.StudentServiceImpl;

/**
 * Servlet implementation class changeInfo
 */
/*
 * 修改个人信息
 * 
 * */
public class changeInfo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IStudentService iStudentService=new StudentServiceImpl();// 学生的操作
		String sql="update student set unicheng=?,utouxiang=?,utel=?,umail=? where uid=?";
		System.out.println("来到了修改学生页面");
		Object object[]= {request.getParameter("unicheng"),request.getParameter("utouxiang"),request.getParameter("utel"),request.getParameter("umail"),request.getParameter("uid")};
		
		boolean result=iStudentService.changeinfo(sql, object);// 修改学生个人信息
		
		if(result)
		{
			System.out.println("修改成功");
		}
		else{
			System.out.println("修改失败");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
