package enterpriceServelt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bao.ApplyJob;
import enterpriceService.EnterpriceImpl;
import enterpriceService.IEnterpriceService;

/**
 * Servlet implementation class QrecevieJL
 */
/*
 * ��ѯ�̼ҽ��յ��ļ���
 * */
public class QrecevieJL extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// ���ñ���
//		System.out.println("��ת���յ��ļ���");
		IEnterpriceService iEnterpriceService=new EnterpriceImpl();
		String sql="select * from applyjob where qid=? and state=0";
//		System.out.println("��ѯuid"+request.getSession().getAttribute("uid"));
		Object object[]= {request.getSession().getAttribute("uid")};
		
		
		// ����ѯ���ļ��� ���� /images/ Ŀ¼����
		
		
		List<ApplyJob> applyjobs=iEnterpriceService.queryApplyInfo(sql, object);
		request.setAttribute("applyjob",applyjobs);
//		if(applyjobs==null) System.out.println("applyjobΪ��");
		
		
//		System.out.println(applyjobs.size());
		request.getRequestDispatcher("enterprice/recevieJL.jsp").forward(request, response);// ����ѯ���ļ���ת��
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
