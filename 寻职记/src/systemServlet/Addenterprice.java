package systemServlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import systemService.ISystem;
import systemService.SystemImpl;

/**
 * Servlet implementation class Addenterprice
 */
public class Addenterprice extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ISystem iSystem=new SystemImpl();
		// ��ͼƬ�ù�������D�̣�xunzhiji�µ�images�ļ�������
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8 ");
		boolean is=ServletFileUpload.isMultipartContent(request);//��ȡǰ̨�Ĳ���
		String uid = null;
		String upwd= null;
		
		String ulicense=null;// Ӫҵִ��
		String uname = null;// ��ҵ����
		
		
		String uaddr = null;// ��ҵ��ַ
		// �ֶλ�ȡ
		
		
		String utel= null; // ��ҵ���껪
		String umail= null;// ��ҵ����
		String ujianjie= null ;// ��ҵ���
		
		// ���ñ���
//		System.out.println("ѧУ��"+request.getParameter("uschool"));
//		System.out.println(request.getCharacterEncoding());
		
		//boolean is=ServletFileUpload.isMultipartContent(request);//��ȡǰ̨�Ĳ���
		// ��������
		if(is)// �ж�ǰ̨�Ƿ���partipart
		{
			FileItemFactory factory=new DiskFileItemFactory();
			ServletFileUpload upload=new ServletFileUpload(factory);
			try {
				List<FileItem> items=(List<FileItem>)upload.parseRequest(request);
				Iterator<FileItem> item=items.iterator();
				System.out.println("��ѯ��ֵΪ:");
				while(item.hasNext())
				{
					FileItem it=item.next();
										
					if(it.isFormField())// ��������
					{
						
						String itemname=it.getFieldName();
						if(itemname.equals("uid"))
						{
							uid=new String(it.getString().getBytes("ISO-8859-1"),"utf-8");
						}	
						if(itemname.equals("upwd"))
						{
							upwd=new String(it.getString().getBytes("ISO-8859-1"),"utf-8");
						}	
						else if(itemname.equals("ulicense"))
						{
							ulicense=new String(it.getString().getBytes("ISO-8859-1"),"utf-8");
							
						}
						else if(itemname.equals("uname"))
						{
							uname=new String(it.getString().getBytes("ISO-8859-1"),"utf-8");
							System.out.println(uname);
						}
						else if(itemname.equals("province"))
						{
							
							uaddr+=new String(it.getString().getBytes("ISO-8859-1"),"utf-8");
						}
						else if(itemname.equals("city"))
						{
							
							uaddr+=new String(it.getString().getBytes("ISO-8859-1"),"utf-8");
						}
						else if(itemname.equals("town"))
						{
							
							uaddr+=new String(it.getString().getBytes("ISO-8859-1"),"utf-8");
						}
						else if(itemname.equals("utel"))
						{
							utel=new String(it.getString().getBytes("ISO-8859-1"),"utf-8");
							
						}
						else if(itemname.equals("umail"))
						{
							
							umail=new String(it.getString().getBytes("ISO-8859-1"),"utf-8");
						}
						else if(itemname.equals("ujianjie"))
						{
							
							ujianjie=new String(it.getString().getBytes("ISO-8859-1"),"utf-8");
						}
						
					
		
					}
					else {
//						System.out.println("�ļ���Ϊ��"+request.getSession().getAttribute("uid")+".png");
						// ��ͼƬ�����ļ�����ȥ
						//File temp=new File("D:\\xunzhiji\\images/", (String) request.getSession().getAttribute("uid")+".png");
//						String str1=request.getRealPath("images");
//						System.out.println(str1);
//						File temp=new File(str1+ (String) request.getSession().getAttribute("uid")+".png");
//						File temp=new File("../images"+ (String) request.getSession().getAttribute("uid")+".png");
						System.out.println(uid+"ѧ�����");
						File temp=new File("D:\\xunzhiji\\images/",uid+".png");
						//File temp=File.createTempFile("D:\\xunzhiji\\images/",uid+".png");
						try {
							temp.createNewFile();
							it.write(temp);
							
							
							if(temp.exists())System.out.println("�ļ�����");
							
					
						} catch (Exception e) {
							
							e.printStackTrace();
						}
						
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		String sql="insert enterprice values(?,?,?,?,?,?,?,?,?);";
		Object object[]= {uid,upwd,ulicense,uname,uaddr,utel,umail,ujianjie,0};
		boolean result=iSystem.addStudent(sql, object);
		if(result)System.out.println("�ύ��ҵ��Ϣ�ɹ�");
		else System.out.println("�ύ��ҵ��Ϣʧ��");
		response.sendRedirect("login.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
