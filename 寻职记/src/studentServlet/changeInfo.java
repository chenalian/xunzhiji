package studentServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentservice.IStudentService;
import studentservice.StudentServiceImpl;

/**
 * Servlet implementation class changeInfo
 */
/*
 * �޸ĸ�����Ϣ
 * 
 * */
public class changeInfo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IStudentService iStudentService=new StudentServiceImpl();// ѧ���Ĳ���
		String sql="update student set unicheng=?,utouxiang=?,utel=?,umail=? where uid=?";
		System.out.println("�������޸�ѧ��ҳ��");
		Object object[]= {request.getParameter("unicheng"),request.getParameter("utouxiang"),request.getParameter("utel"),request.getParameter("umail"),request.getParameter("uid")};
		
		boolean result=iStudentService.changeinfo(sql, object);// �޸�ѧ��������Ϣ
		
		if(result)
		{
			System.out.println("�޸ĳɹ�");
		}
		else{
			System.out.println("�޸�ʧ��");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
