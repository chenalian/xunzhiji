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
// ��¼���
public class Logincheck extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*��ȡ��¼��Ϣ*/
		String uid=request.getParameter("uid");
		String upwd=request.getParameter("upwd");
		
		System.out.println(uid+" "+upwd);
		
		Object object[]= {uid,upwd};// ��¼��Ϣ
		String state=null;// �û�Ȩ��
		boolean result=false;//��¼״̬
		/*ϵͳ����*/ 
		ISystem iSystem=new SystemImpl();
		
		// ��ѯ�������ж��Ƿ����
		String sql="select * from student where uid=? and upwd=? and state=1";// �Ȳ�ѯѧ����
	    result=iSystem.checkuser(sql, object);
		if(result)// ��ѯ�ɹ�
		{
			state="student";
			request.getSession().setAttribute("uid", uid);// �û�id
			request.getSession().setAttribute("state", state);//�û�Ȩ��
			
			Student user=null;
			user =iSystem.querystu(sql, object);// ��ѯѧ��������Ϣ
			
			
			request.getSession().setAttribute("user", user);// ����Ϣ���� user
			
			response.sendRedirect("QueryJobByPage");//�Ӷ���
			System.out.println("ѧ��ҳ��");
		}
		else 
		{
			sql="select * from enterprice where uid=? and upwd=? and state=1";// ��ѯ��ҵ��
			result=iSystem.checkuser(sql, object);
			if(result)// ��ѯ�ɹ�
			{
				state="enterprice";
				request.getSession().setAttribute("uid", uid);// �û�id
				request.getSession().setAttribute("state", state);//�û�Ȩ��
				
				Enterprice user=null;
				user =iSystem.queryent(sql, object);// ��ѯѧ��������Ϣ
				
				
				request.getSession().setAttribute("user", user);// ����Ϣ���� user
				
				response.sendRedirect("QueryJobByPage");//�Ӷ���
				System.out.println("��ҵҳ��");
			}
			else {
				sql="select * from administrator where uid=? and upwd=?";// ��ѯ����Ա��
				result=iSystem.checkuser(sql, object);
				if(result)// ��ѯ�ɹ�
				{
					state="administrator";
					request.getSession().setAttribute("uid", uid);// �û�id
					request.getSession().setAttribute("state", state);//�û�Ȩ��
					response.sendRedirect("QueryJobByPage");//�Ӷ���
					System.out.println("����Աҳ��");
				}
				else
				{
					System.out.println("ү��������");
					response.sendRedirect("login.jsp");//�Żص�¼ҳ��
				}
			}
			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
