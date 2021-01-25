package systemServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import systemService.ISystem;
import systemService.SystemImpl;

/**
 * Servlet implementation class CheckStudentuid
 */
// 检验学生的id是否唯一
public class CheckStudentuid extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uid=request.getParameter("uid");
		
		/*系统功能*/ 
		ISystem iSystem=new SystemImpl();
		
		String sql="select uid from student";
		
		List <String> allUsersUid=iSystem.queryAllUsersUid(sql,null);
		
		if(allUsersUid.contains(uid))// 已经被注册
		{
			response.getWriter().print("很抱歉,该用户名已经被注册");
		}
		else {
			response.getWriter().print("恭喜您，该用户名未被注册");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
