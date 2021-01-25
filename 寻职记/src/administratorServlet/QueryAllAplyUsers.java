package administratorServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bao.Enterprice;
import Bao.Student;
import administratorService.AdministratorImpl;
import administratorService.IAdministrator;

/**
 * Servlet implementation class QueryAllAplyUsers
 */
// 查询所有注册申请的用户
public class QueryAllAplyUsers extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IAdministrator iAdministrator=new AdministratorImpl();
		String sql="select * from student where state=0";
		
		List <Student> students=iAdministrator.queryStudents(sql, null);// 查询注册信息的学生
		request.getSession().setAttribute("students",students);
		sql="select * from enterprice where state=0";
		List <Enterprice> enterprices=iAdministrator.queryEnterprice(sql, null);// 查询提交注册信息企业
		request.getSession().setAttribute("enterprices",enterprices);
		request.getRequestDispatcher("administrator/checkuser.jsp").forward(request, response);// 将查询到的学生和企业发送到管理员审核页面
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
 