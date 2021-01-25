package administratorServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bao.Job;
import Bao.Student;
import administratorService.AdministratorImpl;
import administratorService.IAdministrator;

/**
 * Servlet implementation class PassStudents
 */
// 管理员审核通过学生
public class PassStudents extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("跳转到学生审核液面");
		List<Student> students=(List<Student>)request.getSession().getAttribute("students");
		Object object[]=new Object[1];
		/*管理员操作功能*/
		IAdministrator iAdministrator=new AdministratorImpl();
		String sql="";
		for(Student user:students)
		{
			if(request.getParameter(user.getUid())!=null)
			{
				// 是管理员发送过来
				if(request.getParameter(user.getUid()).equals("tg"))//表示管理员已经设置为应通过审核状态
				{
					System.out.println("已经修改该工作状态"+user.getUid());
					sql="update student set state='1' where uid=?";
					object[0]=user.getUid();
					boolean result=iAdministrator.passStudent(sql, object);
					if(result)System.out.println("学生注册信息审核工作");
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
