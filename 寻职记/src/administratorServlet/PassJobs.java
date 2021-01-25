package administratorServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bao.Job;
import administratorService.AdministratorImpl;
import administratorService.IAdministrator;

/**
 * Servlet implementation class PassJobs
 */
public class PassJobs extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ���ù���Աͨ��id1��
		System.out.println("��ת���߸�Һ��");
		List<Job> jobs=(List<Job>)request.getSession().getAttribute("jobs");
		Object object[]=new Object[1];
		/*����Ա��������*/
		IAdministrator iAdministrator=new AdministratorImpl();
		String sql="";
		for(Job job:jobs)
		{
			if(request.getParameter(job.getJobid())!=null)
			{
				// �ǹ���Ա���͹���
				if(request.getParameter(job.getJobid()).equals("tg"))//��ʾ����Ա�Ѿ�����ΪӦͨ�����״̬
				{
					System.out.println("�Ѿ��޸ĸù���״̬"+job.getJobid());
					sql="update jobinfo set pstate='1' where jobid=?";
					object[0]=job.getJobid();
					boolean result=iAdministrator.setJobState(sql, object);
					if(result)System.out.println("�޸ĳɹ�");
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
