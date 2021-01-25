package enterpriceServelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enterpriceService.EnterpriceImpl;
import enterpriceService.IEnterpriceService;

/**
 * Servlet implementation class PublishJob
 */
// 商家发布工作
public class PublishJob extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		IEnterpriceService iEnterpriceService=new EnterpriceImpl();
		String sql="insert jobinfo(jobid,qid,qname,post,postneed,jobaddr,salary,sTime,eTime,nsm,pstate) values(?,?,?,?,?,?,?,?,?,?,?);";
		
		String dizhi=request.getParameter("province")+request.getParameter("city")+request.getParameter("town");
		String jobid=radioJobidTostring();
		Object object[]= {jobid,request.getParameter("qid"),request.getParameter("qname"),request.getParameter("post"),request.getParameter("postneed"),dizhi,request.getParameter("salary"),request.getParameter("stime"),request.getParameter("etime"),request.getParameter("nms"),0};
		boolean result=iEnterpriceService.publishJob(sql, object);
		if(result)
		{
			System.out.println("商家发布信息成功");
		}
		else System.out.println("商家发布信息失败");
		response.sendRedirect("enterprice/user.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public String radioJobidTostring()
	{
		String temp="0123456789";
		String aim="";
		for(int i=0;i<=8;i++)
		{
			int index=(int)(Math.random()*temp.length());
			aim+=temp.charAt(index);
		}
		return aim;
	}

}
