package systemServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bao.Job;
import systemService.ISystem;
import systemService.SystemImpl;

/**
 * Servlet implementation class SearchJobs
 */

// ��ѯ�����Ѿ������Ĺ������ص��ٶȵ�ͼAPI�У���ʾ����
public class SearchJobs extends HttpServlet {	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���ñ���
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		System.out.println("�ٶ�APIҳ��");
		
		/*ϵͳ����*/ 
		ISystem iSystem=new SystemImpl();
		String sql="select * from jobinfo where pstate='1'";
		List <Job> searchjobs=iSystem.queryAllJobs(sql, null);
		request.setAttribute("searchjobs",searchjobs);
		if(searchjobs==null)System.out.println("searchjobsΪ��");
		request.getRequestDispatcher("student/studentsearchjob.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
