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
	// ͨ��ҳ���ѯ ָ��ҳ��Ĺ���
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// ���ñ���
		System.out.println("�����ҳҳ��");
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
	
		
		ISystem iSystem=new SystemImpl();
		String sql="select count(*) from jobinfo where pstate=1 order by pstate desc";
		// ��ʾ1��ǰ 0�ں�������� �ڽ��в�ѯ
		int totalNms=iSystem.queryJobnums(sql, null);// ��ȡĿ������������
		System.out.println("�ܹ�����"+totalNms);
		
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
		System.out.println("��ǰҳ��Ĺ�������:"+b.size());
		
		a.setJobs(b);// ����ҳ�鵽�����ݷ��ص���ҳ����ȥ
		
		request.setAttribute("jobs",a);
		request.getRequestDispatcher("main2.jsp").forward(request, response);// ����
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
