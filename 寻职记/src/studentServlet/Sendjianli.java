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
// 提交简历
public class Sendjianli extends HttpServlet {// 将申请文件存入数据库
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			处理文件的编码格式
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=UTF-8 ");
			boolean is=ServletFileUpload.isMultipartContent(request);//获取前台的参数
			// 申请表参数
			ApplyJob applyjob=new ApplyJob();
			if(is)// 判断前台是否有partipart
			{
				FileItemFactory factory=new DiskFileItemFactory();
				ServletFileUpload upload=new ServletFileUpload(factory);
				try {
					List<FileItem> items=(List<FileItem>)upload.parseRequest(request);
					Iterator<FileItem> item=items.iterator();
					System.out.println("查询的值为:");
					while(item.hasNext())
					{
						FileItem it=item.next();
						
						
						if(it.isFormField())// 其他参数
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
						else {// 文件
							String itemname=it.getName();
//							applyjob.setAinfoname(itemname);
							System.out.println("文件名为："+itemname);
							// 将文件读取存入二进制数组中
							File temp=File.createTempFile("D:\\360Downloads", itemname);
							try {
								it.write(temp);
								
								// 读取文件信息，存入字节数组
								FileInputStream in=new FileInputStream(temp);
								byte a[]=new byte[10024];
								in.read(a);
								applyjob.setJianli(a);
								
								in.close();// 关闭输入流
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							temp.delete();// 删除临时文件
							
						}
						
					}
				} catch (FileUploadException e) {
					e.printStackTrace();
				}
			}
			// 在请求数据存入数据库中
			IStudentService iStudentService=new StudentServiceImpl();// 学生的操作
			String sql="insert applyjob values(?,?,?,?,?)";
			Object object[]= {applyjob.getJobid(),applyjob.getQid(),applyjob.getUid(),applyjob.getJianli(),0}; // 0表示刚刚提交简历
			boolean result=iStudentService.sendJianli(sql, object);
			if(result)
			{
				System.out.println("简历信息发送成功");
			}
			else System.out.println("简历发送失败失败");
			response.sendRedirect("student/user.jsp");
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}
	}
