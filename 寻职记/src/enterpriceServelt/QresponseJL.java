package enterpriceServelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enterpriceService.EnterpriceImpl;
import enterpriceService.IEnterpriceService;

/**
 * Servlet implementation class QDeleteJobs
 */
// ɾ������ҳ��
public class QresponseJL extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// ���ñ���
		
		IEnterpriceService iEnterpriceService=new EnterpriceImpl();
		
		String jobid=request.getParameter("jobid");
		String qid=request.getParameter("qid");
		String uid=request.getParameter("uid");
		
		
		
		
		
		String sql="update applyjob set state=1 where jobid=? and qid =? and uid=?";
		Object object[]= {jobid,qid,uid};
		boolean result=iEnterpriceService.changeInfo(sql, object);
		
		if(result)System.out.println("�޸ļ����ɹ�");
		else System.out.println("�޸ļ���ʧ��");
		response.sendRedirect("enterprice/user.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
