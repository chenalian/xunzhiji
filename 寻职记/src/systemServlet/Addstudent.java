package systemServlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

import Bao.ApplyJob;
import studentservice.IStudentService;
import studentservice.StudentServiceImpl;
import systemService.ISystem;
import systemService.SystemImpl;

/**
 * Servlet implementation class Addstudent
 */
// ѧ��ע��
public class Addstudent extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ISystem iSystem=new SystemImpl();
		// ��ͼƬ�ù�������D�̣�xunzhiji�µ�images�ļ�������
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8 ");
		boolean is=ServletFileUpload.isMultipartContent(request);//��ȡǰ̨�Ĳ���
		String uid = null;
		String upwd= null;
		
		String ident=null;// ���֤
		String xuehao= null;// ѧ��
		String uname = null;// ����
		int uage = 0;
		String sex = null;
		String unicheng= null;
		String uxueli= null;
		String uschool= null ;
		String utel= null;
		String umail= null;
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
						else if(itemname.equals("xuehao"))
						{
							xuehao=new String(it.getString().getBytes("ISO-8859-1"),"utf-8");
							
						}
						else if(itemname.equals("uname"))
						{
							uname=new String(it.getString().getBytes("ISO-8859-1"),"utf-8");
							System.out.println(uname);
						}
						else if(itemname.equals("uage"))
						{
							
							uage=Integer.parseInt(it.getString());
						}
						else if(itemname.equals("sex"))
						{
							sex=new String(it.getString().getBytes("ISO-8859-1"),"utf-8");
							
						}
						else if(itemname.equals("unicheng"))
						{
							
							unicheng=new String(it.getString().getBytes("ISO-8859-1"),"utf-8");
						}
						else if(itemname.equals("uschool"))
						{
							
							uschool=new String(it.getString().getBytes("ISO-8859-1"),"utf-8");
						}
						else if(itemname.equals("utel"))
						{
							utel=new String(it.getString().getBytes("ISO-8859-1"),"utf-8");
							
						}
						else if(itemname.equals("umail"))
						{
							umail=new String(it.getString().getBytes("ISO-8859-1"),"utf-8");
							
						}
						else if(itemname.equals("uxueli"))
						{
							uxueli=new String(it.getString().getBytes("ISO-8859-1"),"utf-8");
							System.out.println("uxueli:"+uxueli);
							
						}
						else if(itemname.equals("ident"))
						{
							ident=new String(it.getString().getBytes("ISO-8859-1"),"utf-8");
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
		
		
		
		
		
		String sql="insert student values(?,?,?,?,?,?,?,?,?,?,?,?,?);";
		Object object[]= {uid, upwd ,ident,xuehao ,uname ,uage ,sex, unicheng ,uxueli ,uschool ,utel ,umail,0};
		boolean result=iSystem.addStudent(sql, object);
		if(result)System.out.println("�ύ��Ϣ�ɹ�");
		else System.out.println("�ύ��Ϣʧ��");
		response.sendRedirect("login.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
