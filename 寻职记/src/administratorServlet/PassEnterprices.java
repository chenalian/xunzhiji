package administratorServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bao.Enterprice;
import Bao.Job;
import Bao.Student;
import administratorService.AdministratorImpl;
import administratorService.IAdministrator;

/**
 * Servlet implementation class PassStudents
 */
// ����Ա���ͨ��ѧ��
public class PassEnterprices extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("��ת����ҵ��˸߸�Һ��");
		List<Enterprice> enterprices=(List<Enterprice>)request.getSession().getAttribute("enterprices");
		Object object[]=new Object[1];
		/*����Ա��������*/
		IAdministrator iAdministrator=new AdministratorImpl();
		String sql="";
		for(Enterprice user:enterprices)
		{
			if(request.getParameter(user.getUid())!=null)
			{
				// �ǹ���Ա���͹���
				if(request.getParameter(user.getUid()).equals("tg"))//��ʾ����Ա�Ѿ�����ΪӦͨ�����״̬
				{
					System.out.println("�Ѿ��޸ĸù���״̬"+user.getUid());
					sql="update enterprice set state='1' where uid=?";
					object[0]=user.getUid();
					boolean result=iAdministrator.passStudent(sql, object);
					if(result)System.out.println("��ҵע����Ϣ��˹���");
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
