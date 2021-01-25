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
 * 查询商家接收到的简历
 * */
public class QrecevieJL extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 设置编码
//		System.out.println("跳转到收到的简历");
		IEnterpriceService iEnterpriceService=new EnterpriceImpl();
		String sql="select * from applyjob where qid=? and state=0";
//		System.out.println("查询uid"+request.getSession().getAttribute("uid"));
		Object object[]= {request.getSession().getAttribute("uid")};
		
		
		// 将查询到的简历 存入 /images/ 目录下面
		
		
		List<ApplyJob> applyjobs=iEnterpriceService.queryApplyInfo(sql, object);
		request.setAttribute("applyjob",applyjobs);
//		if(applyjobs==null) System.out.println("applyjob为空");
		
		
//		System.out.println(applyjobs.size());
		request.getRequestDispatcher("enterprice/recevieJL.jsp").forward(request, response);// 将查询到的简历转发
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
