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
 * Servlet implementation class SearchJobs
 */

// 查询所有已经发布的工作返回到百度地图API中，显示出来
public class APIfindjobs extends HttpServlet {	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("百度API查询工作页面");
		String tiaojian=request.getParameter("tiaojian");
		String shaixuan=request.getParameter("shaixuan");
		System.out.println(tiaojian);
		
		
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
		/*系统功能*/ 
		ISystem iSystem=new SystemImpl();
		if(tiaojian!=null)
		if(tiaojian.equals("职位"))
		{
			String sql="select count(*) from jobinfo where pstate=1 and post like ? order by pstate desc";
			// 表示1在前 0在后面排序好 在进行查询
			Object object[]= {shaixuan};
			int totalNms=iSystem.queryJobnumsbytiaojian(sql, object); // 获取目标表的总数据量
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
			sql="select * from jobinfo where pstate=1 and post like  ?  LIMIT ?,?";
			Object object1[]= {shaixuan,(curpage-1)*8,8};
			List <Job> b=iSystem.queryAllJobsbytiaojian(sql, object1);
			
			a.setJobs(b);// 将分页查到的数据返回到主页面中去
			
			request.setAttribute("searchjobs",b);
			request.getRequestDispatcher("student/studentsearchjob.jsp").forward(request, response);// 返回
		}
		else if(tiaojian.equals("月薪"))
		{
			String sql="select count(*) from jobinfo where pstate=1 and salary> ? and salary < ? order by pstate desc";
			// 表示1在前 0在后面排序好 在进行查询
			String temp=shaixuan;
			String money1=shaixuan.substring(0,shaixuan.indexOf(" "));
			String money2=shaixuan.substring(shaixuan.indexOf(" "),shaixuan.length()-1);
			Object object[]= {Integer.parseInt(money1),Integer.parseInt(money2)};
			
			System.out.println(money1+" "+money2);
			int totalNms=iSystem.queryJobnums(sql, object); // 获取目标表的总数据量
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
			sql="select * from jobinfo where pstate=1 and salary> ? and salary < ?  LIMIT ?,?";
			Object object1[]= {Integer.parseInt(request.getParameter("money1")),Integer.parseInt(request.getParameter("money2")),(curpage-1)*8,8};
			List <Job> b=iSystem.queryAllJobs(sql, object1);
			
			a.setJobs(b);// 将分页查到的数据返回到主页面中去
			
			request.setAttribute("searchjobs",b);
			request.getRequestDispatcher("student/studentsearchjob.jsp").forward(request, response);// 返回
		}
		else if(tiaojian.equals("地点"))
		{
			String sql="select count(*) from jobinfo where pstate=1 and jobaddr like ? order by pstate desc";
			// 表示1在前 0在后面排序好 在进行查询
			Object object[]= {shaixuan};
			int totalNms=iSystem.queryJobnumsbytiaojian(sql, object); // 获取目标表的总数据量
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
			sql="select * from jobinfo where pstate=1 and jobaddr like  ?  LIMIT ?,?";
			Object object1[]= {shaixuan,(curpage-1)*8,8};
			List <Job> b=iSystem.queryAllJobsbytiaojian(sql, object1);
			
			a.setJobs(b);// 将分页查到的数据返回到主页面中去
			
			request.setAttribute("searchjobs",b);
			request.getRequestDispatcher("student/studentsearchjob.jsp").forward(request, response);// 返回
		}
		else if(tiaojian.equals("公司"))
		{
			String sql="select count(*) from jobinfo where pstate=1 and qname like ? order by pstate desc";
			// 表示1在前 0在后面排序好 在进行查询
			Object object[]= {shaixuan};
			int totalNms=iSystem.queryJobnumsbytiaojian(sql, object); // 获取目标表的总数据量
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
			sql="select * from jobinfo where pstate=1 and qname like  ?  LIMIT ?,?";
			Object object1[]= {shaixuan,(curpage-1)*8,8};
			List <Job> b=iSystem.queryAllJobsbytiaojian(sql, object1);
			
			a.setJobs(b);// 将分页查到的数据返回到主页面中去
			
			request.setAttribute("searchjobs",b);
			request.getRequestDispatcher("student/studentsearchjob.jsp").forward(request, response);// 返回
		}
		else if(tiaojian.equals("人数"))
		{
			String sql="select count(*) from jobinfo where pstate=1 and nsn = ? order by pstate desc";
			// 表示1在前 0在后面排序好 在进行查询
			Object object[]= {Integer.parseInt(shaixuan)};
			int totalNms=iSystem.queryJobnums(sql, object); // 获取目标表的总数据量
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
			sql="select * from jobinfo where pstate=1 and nsm =  ?  LIMIT ?,?";
			Object object1[]= {Integer.parseInt(shaixuan),(curpage-1)*8,8};
			List <Job> b=iSystem.queryAllJobs(sql, object1);
			
			a.setJobs(b);// 将分页查到的数据返回到主页面中去
			
			request.setAttribute("searchjobs",b);
			request.getRequestDispatcher("student/studentsearchjob.jsp").forward(request, response);// 返回
		}
		else System.out.println("条件为空");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
