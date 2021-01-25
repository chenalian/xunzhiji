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
// ����Ա���ͨ��ѧ��
public class PassStudents extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("��ת��ѧ�����Һ��");
		List<Student> students=(List<Student>)request.getSession().getAttribute("students");
		Object object[]=new Object[1];
		/*����Ա��������*/
		IAdministrator iAdministrator=new AdministratorImpl();
		String sql="";
		for(Student user:students)
		{
			if(request.getParameter(user.getUid())!=null)
			{
				// �ǹ���Ա���͹���
				if(request.getParameter(user.getUid()).equals("tg"))//��ʾ����Ա�Ѿ�����ΪӦͨ�����״̬
				{
					System.out.println("�Ѿ��޸ĸù���״̬"+user.getUid());
					sql="update student set state='1' where uid=?";
					object[0]=user.getUid();
					boolean result=iAdministrator.passStudent(sql, object);
					if(result)System.out.println("ѧ��ע����Ϣ��˹���");
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
