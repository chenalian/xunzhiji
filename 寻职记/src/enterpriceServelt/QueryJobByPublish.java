package enterpriceServelt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bao.Job;
import enterpriceService.EnterpriceImpl;
import enterpriceService.IEnterpriceService;

/**
 * Servlet implementation class QueryJobByPublish
 */
/*
 * ��ѯ�̼ҷ����Ĺ���
 * */
public class QueryJobByPublish extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���ñ���
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		IEnterpriceService iEnterpriceService=new EnterpriceImpl();
		
		String sql="select * from jobinfo where qid=?";
		Object object[]= {request.getSession().getAttribute("uid")};
		List <Job> jobs=iEnterpriceService.queryJobsByPulish(sql, object);
		
		// ��ѯ�̼ҷ������ض�����
		
		request.setAttribute("jobsByid", jobs);
		
		request.getRequestDispatcher("enterprice/deleteJob.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
