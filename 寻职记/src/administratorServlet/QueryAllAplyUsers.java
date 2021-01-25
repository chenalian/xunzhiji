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
// ��ѯ����ע��������û�
public class QueryAllAplyUsers extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IAdministrator iAdministrator=new AdministratorImpl();
		String sql="select * from student where state=0";
		
		List <Student> students=iAdministrator.queryStudents(sql, null);// ��ѯע����Ϣ��ѧ��
		request.getSession().setAttribute("students",students);
		sql="select * from enterprice where state=0";
		List <Enterprice> enterprices=iAdministrator.queryEnterprice(sql, null);// ��ѯ�ύע����Ϣ��ҵ
		request.getSession().setAttribute("enterprices",enterprices);
		request.getRequestDispatcher("administrator/checkuser.jsp").forward(request, response);// ����ѯ����ѧ������ҵ���͵�����Ա���ҳ��
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
 