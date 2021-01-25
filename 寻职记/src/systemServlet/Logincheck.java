package systemServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bao.Enterprice;
import Bao.Student;
import systemService.ISystem;
import systemService.SystemImpl;

/**
 * Servlet implementation class Checklogin
 */
// 登录检测
public class Logincheck extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*获取登录信息*/
		String uid=request.getParameter("uid");
		String upwd=request.getParameter("upwd");
		
		System.out.println(uid+" "+upwd);
		
		Object object[]= {uid,upwd};// 登录信息
		String state=null;// 用户权限
		boolean result=false;//登录状态
		/*系统功能*/ 
		ISystem iSystem=new SystemImpl();
		
		// 查询三个表判断是否存在
		String sql="select * from student where uid=? and upwd=? and state=1";// 先查询学生表
	    result=iSystem.checkuser(sql, object);
		if(result)// 查询成功
		{
			state="student";
			request.getSession().setAttribute("uid", uid);// 用户id
			request.getSession().setAttribute("state", state);//用户权限
			
			Student user=null;
			user =iSystem.querystu(sql, object);// 查询学生单个信息
			
			
			request.getSession().setAttribute("user", user);// 将信息存入 user
			
			response.sendRedirect("QueryJobByPage");//从定向
			System.out.println("学生页面");
		}
		else 
		{
			sql="select * from enterprice where uid=? and upwd=? and state=1";// 查询企业表
			result=iSystem.checkuser(sql, object);
			if(result)// 查询成功
			{
				state="enterprice";
				request.getSession().setAttribute("uid", uid);// 用户id
				request.getSession().setAttribute("state", state);//用户权限
				
				Enterprice user=null;
				user =iSystem.queryent(sql, object);// 查询学生单个信息
				
				
				request.getSession().setAttribute("user", user);// 将信息存入 user
				
				response.sendRedirect("QueryJobByPage");//从定向
				System.out.println("企业页面");
			}
			else {
				sql="select * from administrator where uid=? and upwd=?";// 查询管理员表
				result=iSystem.checkuser(sql, object);
				if(result)// 查询成功
				{
					state="administrator";
					request.getSession().setAttribute("uid", uid);// 用户id
					request.getSession().setAttribute("state", state);//用户权限
					response.sendRedirect("QueryJobByPage");//从定向
					System.out.println("管理员页面");
				}
				else
				{
					System.out.println("爷曾今来过");
					response.sendRedirect("login.jsp");//放回登录页面
				}
			}
			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
