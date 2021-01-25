package studentServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bao.Job;
import studentservice.IStudentService;
import studentservice.StudentServiceImpl;

/**
 * Servlet implementation class findJobby
 */
/*��ѯ�ض��Ĺ���*/
public class findJobby extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("��ҳ��");
		IStudentService iStudentService=new StudentServiceImpl();// ѧ���Ĳ���
		List<Job> jobstemp=null;
		String sql="select * from jobinfo where jobaddr like ?";
		if(request.getParameter("judge").equals("addr"))// ��ַ��ѯ
		{
			
			Object object[]={request.getParameter("text")};
		    jobstemp=iStudentService.findJobs(sql, object);
		    System.out.println("aadr");
			request.setAttribute("jobstemp",jobstemp);
			request.getRequestDispatcher("student/findJob.jsp").forward(request, response);// ����ѯ���Ĺ����Żص�ҳ��
		}
		else if(request.getParameter("judge").equals("post"))// ְλ��ѯ
		{
			sql="select * from jobinfo where post like ?";
			Object object[]={request.getParameter("text")};
			iStudentService.findJobs(sql, object);
			System.out.println("post");
			request.setAttribute("jobstemp",jobstemp);
			request.getRequestDispatcher("student/findJob.jsp").forward(request, response);// ����ѯ���Ĺ����Żص�ҳ��
		}
		else if(request.getParameter("judge").equals("salary"))// нˮ��ѯ
		{
			 sql="select * from jobinfo where salary=?";
			Object object[]={request.getParameter("text")};
			iStudentService.findJobs(sql, object);
			System.out.println("salary");
			request.setAttribute("jobstemp",jobstemp);
			request.getRequestDispatcher("student/findJob.jsp").forward(request, response);// ����ѯ���Ĺ����Żص�ҳ��
		}
		else {
			System.out.println("��ת������Ϊ��ֵ");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
