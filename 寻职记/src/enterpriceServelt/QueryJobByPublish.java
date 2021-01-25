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
 * 查询商家发布的工作
 * */
public class QueryJobByPublish extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		IEnterpriceService iEnterpriceService=new EnterpriceImpl();
		
		String sql="select * from jobinfo where qid=?";
		Object object[]= {request.getSession().getAttribute("uid")};
		List <Job> jobs=iEnterpriceService.queryJobsByPulish(sql, object);
		
		// 查询商家发布的特定工作
		
		request.setAttribute("jobsByid", jobs);
		
		request.getRequestDispatcher("enterprice/deleteJob.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
