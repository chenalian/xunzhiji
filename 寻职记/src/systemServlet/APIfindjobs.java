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

// ��ѯ�����Ѿ������Ĺ������ص��ٶȵ�ͼAPI�У���ʾ����
public class APIfindjobs extends HttpServlet {	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���ñ���
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("�ٶ�API��ѯ����ҳ��");
		String tiaojian=request.getParameter("tiaojian");
		String shaixuan=request.getParameter("shaixuan");
		System.out.println(tiaojian);
		
		
		// ��ȡ��ǰ ҳ�룬��ҳ���С
		String currPage=request.getParameter("page");
		if(currPage==null)
		{
			currPage="1";
			System.out.println("��ʼʱֵΪ:"+currPage);
		}
		else System.out.println("���ݹ�����ֵΪ��"+currPage);
		// ��ǰҳ��
		int curpage=Integer.parseInt(currPage);
		
		
		Page a=new Page();// ��ǰҳ��洢����Ϣ
		/*ϵͳ����*/ 
		ISystem iSystem=new SystemImpl();
		if(tiaojian!=null)
		if(tiaojian.equals("ְλ"))
		{
			String sql="select count(*) from jobinfo where pstate=1 and post like ? order by pstate desc";
			// ��ʾ1��ǰ 0�ں�������� �ڽ��в�ѯ
			Object object[]= {shaixuan};
			int totalNms=iSystem.queryJobnumsbytiaojian(sql, object); // ��ȡĿ������������
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
			
			a.setJobs(b);// ����ҳ�鵽�����ݷ��ص���ҳ����ȥ
			
			request.setAttribute("searchjobs",b);
			request.getRequestDispatcher("student/studentsearchjob.jsp").forward(request, response);// ����
		}
		else if(tiaojian.equals("��н"))
		{
			String sql="select count(*) from jobinfo where pstate=1 and salary> ? and salary < ? order by pstate desc";
			// ��ʾ1��ǰ 0�ں�������� �ڽ��в�ѯ
			String temp=shaixuan;
			String money1=shaixuan.substring(0,shaixuan.indexOf(" "));
			String money2=shaixuan.substring(shaixuan.indexOf(" "),shaixuan.length()-1);
			Object object[]= {Integer.parseInt(money1),Integer.parseInt(money2)};
			
			System.out.println(money1+" "+money2);
			int totalNms=iSystem.queryJobnums(sql, object); // ��ȡĿ������������
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
			
			a.setJobs(b);// ����ҳ�鵽�����ݷ��ص���ҳ����ȥ
			
			request.setAttribute("searchjobs",b);
			request.getRequestDispatcher("student/studentsearchjob.jsp").forward(request, response);// ����
		}
		else if(tiaojian.equals("�ص�"))
		{
			String sql="select count(*) from jobinfo where pstate=1 and jobaddr like ? order by pstate desc";
			// ��ʾ1��ǰ 0�ں�������� �ڽ��в�ѯ
			Object object[]= {shaixuan};
			int totalNms=iSystem.queryJobnumsbytiaojian(sql, object); // ��ȡĿ������������
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
			
			a.setJobs(b);// ����ҳ�鵽�����ݷ��ص���ҳ����ȥ
			
			request.setAttribute("searchjobs",b);
			request.getRequestDispatcher("student/studentsearchjob.jsp").forward(request, response);// ����
		}
		else if(tiaojian.equals("��˾"))
		{
			String sql="select count(*) from jobinfo where pstate=1 and qname like ? order by pstate desc";
			// ��ʾ1��ǰ 0�ں�������� �ڽ��в�ѯ
			Object object[]= {shaixuan};
			int totalNms=iSystem.queryJobnumsbytiaojian(sql, object); // ��ȡĿ������������
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
			
			a.setJobs(b);// ����ҳ�鵽�����ݷ��ص���ҳ����ȥ
			
			request.setAttribute("searchjobs",b);
			request.getRequestDispatcher("student/studentsearchjob.jsp").forward(request, response);// ����
		}
		else if(tiaojian.equals("����"))
		{
			String sql="select count(*) from jobinfo where pstate=1 and nsn = ? order by pstate desc";
			// ��ʾ1��ǰ 0�ں�������� �ڽ��в�ѯ
			Object object[]= {Integer.parseInt(shaixuan)};
			int totalNms=iSystem.queryJobnums(sql, object); // ��ȡĿ������������
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
			
			a.setJobs(b);// ����ҳ�鵽�����ݷ��ص���ҳ����ȥ
			
			request.setAttribute("searchjobs",b);
			request.getRequestDispatcher("student/studentsearchjob.jsp").forward(request, response);// ����
		}
		else System.out.println("����Ϊ��");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
