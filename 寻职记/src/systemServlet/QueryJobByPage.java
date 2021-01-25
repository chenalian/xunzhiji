package systemServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bao.Job;
import Bao.Page;
import systemService.ISystem;
import systemService.SystemImpl;

/**
 * Servlet implementation class QueryJobByPage
 */
public class QueryJobByPage extends HttpServlet {
	// 通过页面查询 指定页面的工作
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// 设置编码
		System.out.println("到达分页页面");
		// 获取当前 页码，和页码大小
		String currPage=request.getParameter("page");
		if(currPage==null)
		{
			currPage="1";
			System.out.println("初始时值为:"+currPage);
		}
		else System.out.println("传递过来的值为："+currPage);
		// 当前页面
		int curpage=Integer.parseInt(currPage);
		
		
		Page a=new Page();// 当前页面存储的信息
	
		
		ISystem iSystem=new SystemImpl();
		String sql="select count(*) from jobinfo where pstate=1 order by pstate desc";
		// 表示1在前 0在后面排序好 在进行查询
		int totalNms=iSystem.queryJobnums(sql, null);// 获取目标表的总数据量
		System.out.println("总工作数"+totalNms);
		
		a.setCurrentPage(curpage);
		a.setTotalPage(totalNms);
		if(totalNms%curpage==0)
		{
			a.setTotalNus(totalNms%curpage);
		}
		else {
			a.setTotalNus(totalNms%curpage+1);
		}
		a.setPageSize(8);
		
		sql="select * from jobinfo where pstate=1 LIMIT ?,?";
		Object object[]= {(curpage-1)*8,8};
		
		
		List <Job> b=iSystem.queryAllJobs(sql, object);
		System.out.println("当前页面的工作数量:"+b.size());
		
		a.setJobs(b);// 将分页查到的数据返回到主页面中去
		
		request.setAttribute("jobs",a);
		request.getRequestDispatcher("main2.jsp").forward(request, response);// 返回
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
