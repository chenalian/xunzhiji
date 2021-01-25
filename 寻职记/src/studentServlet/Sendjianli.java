package studentServlet;

import java.io.File;
import java.io.FileInputStream;
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

import Bao.ApplyJob;
import studentservice.IStudentService;
import studentservice.StudentServiceImpl;
/**
 * Servlet implementation class Sendjianli
 */
// �ύ����
public class Sendjianli extends HttpServlet {// �������ļ��������ݿ�
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			�����ļ��ı����ʽ
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=UTF-8 ");
			boolean is=ServletFileUpload.isMultipartContent(request);//��ȡǰ̨�Ĳ���
			// ��������
			ApplyJob applyjob=new ApplyJob();
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
							
							if(itemname.equals("jobid"))
							{
								System.out.println("jobid"+it.getString());
								applyjob.setJobid(it.getString());
								
							}
							else if(itemname.equals("uid"))
							{
								System.out.println("uid"+it.getString());
								applyjob.setUid(it.getString());
								
							}
							else if(itemname.equals("qid"))
							{
								System.out.println("qid"+it.getString());
								applyjob.setQid(it.getString());
								
							}
			
						}
						else {// �ļ�
							String itemname=it.getName();
//							applyjob.setAinfoname(itemname);
							System.out.println("�ļ���Ϊ��"+itemname);
							// ���ļ���ȡ���������������
							File temp=File.createTempFile("D:\\360Downloads", itemname);
							try {
								it.write(temp);
								
								// ��ȡ�ļ���Ϣ�������ֽ�����
								FileInputStream in=new FileInputStream(temp);
								byte a[]=new byte[10024];
								in.read(a);
								applyjob.setJianli(a);
								
								in.close();// �ر�������
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							temp.delete();// ɾ����ʱ�ļ�
							
						}
						
					}
				} catch (FileUploadException e) {
					e.printStackTrace();
				}
			}
			// ���������ݴ������ݿ���
			IStudentService iStudentService=new StudentServiceImpl();// ѧ���Ĳ���
			String sql="insert applyjob values(?,?,?,?,?)";
			Object object[]= {applyjob.getJobid(),applyjob.getQid(),applyjob.getUid(),applyjob.getJianli(),0}; // 0��ʾ�ո��ύ����
			boolean result=iStudentService.sendJianli(sql, object);
			if(result)
			{
				System.out.println("������Ϣ���ͳɹ�");
			}
			else System.out.println("��������ʧ��ʧ��");
			response.sendRedirect("student/user.jsp");
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}
	}
