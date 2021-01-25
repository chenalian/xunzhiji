package studentServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bao.ApplyJob;
import Bao.Job;
import studentservice.IStudentService;
import studentservice.StudentServiceImpl;

/**
 * Servlet implementation class findapplystate
 */
/*
 * ��ѯ�ύ�ļ�����״̬
 * */
public class findapplystate extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IStudentService iStudentService=new StudentServiceImpl();// ѧ���Ĳ���
		
		String sql="select * from applyjob where uid=?";
		Object object[]= {request.getSession().getAttribute("uid")};
		List<ApplyJob> applyjobs=iStudentService.findJLstate(sql, object);
		// ��ȡ������Ĺ���
		if(applyjobs==null)System.out.println("applyjobsΪ��");
		
//		else System.out.println(applyjobs.size());
		request.setAttribute("applyjobs",applyjobs);
		request.getRequestDispatcher("student/findApplyJobs.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
