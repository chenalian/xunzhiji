package systemServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import systemService.ISystem;
import systemService.SystemImpl;

/**
 * Servlet implementation class CheckStudentuid
 */
// ����ѧ����id�Ƿ�Ψһ
public class CheckStudentuid extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uid=request.getParameter("uid");
		
		/*ϵͳ����*/ 
		ISystem iSystem=new SystemImpl();
		
		String sql="select uid from student";
		
		List <String> allUsersUid=iSystem.queryAllUsersUid(sql,null);
		
		if(allUsersUid.contains(uid))// �Ѿ���ע��
		{
			response.getWriter().print("�ܱ�Ǹ,���û����Ѿ���ע��");
		}
		else {
			response.getWriter().print("��ϲ�������û���δ��ע��");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
