package systemServlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileOutputStream;
  
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
  

/**
 * Servlet implementation class AddChatInfo
 */
// 用于存储 特定的的学生和商家的聊天信息


public class AddChatInfo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		System.out.println(request.getParameter("fabuid"));
//		
//		System.out.println(request.getParameter("message"));
		
		String uid=(String)request.getSession().getAttribute("uid");
		
		String qid=request.getParameter("fabuid");
		
		String message=request.getParameter("message");
		
		
		
		/*在D：盘中创建xml文件夹，（如果存在就不用创建）在该文件夹下面创建xml文件，（如果存在就不用创建）*/
		
		
		File xml=new File("\\xunzhiji/xml");
		
		/*用于判断xml文件夹是否存在*/
		if(xml.isDirectory())
		{
//			System.out.println("xml file exit");
		}
		else {
			xml.mkdir();// 不存在就创建文件夹
		}
		
		// 用于判断文件是否存在
		File file=new File("\\xunzhiji/xml/"+uid+"$"+qid+".xml");
		if(!file.exists())// 如果文件不存在
		{
			file.createNewFile();
		}
		
		
		response.setContentType("text/html");
		
		//String fileURL=request.getRealPath("xml/temm.xml");// 文件路径
		
		//File xmlFilePath = new File(request.getContextPath() + "/WebContent/xml/temm.xml");
		//System.out.println(xmlFilePath.getAbsolutePath());
		

		
	
		// 读取聊天信息xml文件是否存在 不存在则创建
		Document doc =null;
		 SAXReader reader = new SAXReader();
		 try {
			 doc = reader.read(file);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 /*如果不存在文档对象则创建一个文档对象*/
		if(doc==null) doc = DocumentHelper.createDocument();
		
		 
		 Element messages=doc.getRootElement();// 获取文档的根节点
		 
		 if(messages==null)
		 {
			 messages=DocumentHelper.createElement("messages");// 创建普通结点
			 doc.setRootElement(messages);// 设置为根节点
		 }
		 
		 
//		 Element messages=DocumentHelper.createElement("messages");// 创建普通结点
//		 
//		 doc.setRootElement(messages);// 设置为根节点
		 
//		 messages.appendAttributes(arg0);
		 
	
		
		 
		 
		 
		 Element message1 =messages.addElement("message1");
		 
		 message1.setAttributeValue("uisread","false");// 为每条信息标志位未读
		 message1.setAttributeValue("qisread","false");// 为每条信息标志位未读
		 
//		 messages.appendAttributes(message1);
		 //messages.appendContent(message1);
		 //messages.appendAttributes(message1);
		 
		 
		 
		 message1.setAttributeValue("id", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		 
		 message1.addElement("message").setText(uid+"对"+qid+"说:"+message);
		 
		 
		 message1.addElement("SendTime").addText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));// 添加时间
		 
		 
		 OutputFormat format=OutputFormat.createPrettyPrint();
		 format.setEncoding("GBK");
		 
		
		 
//		 XMLWriter writer=new XMLWriter(new FileOutputStream(new File(request.getRealPath("xml/"),"Text.xml")),format);
		 XMLWriter writer=new XMLWriter(new FileOutputStream(file),format);


		 
		 writer.write(doc);
		 
		 writer.close();
		 
//		 System.out.println("成功添加聊天信息");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
//private static void addNewBookToXMLDocument(Document document) {
//    Element root = document.getRootElement();
//    
//    Element newBook = root.addElement("book");
//    newBook.addAttribute("id", "book3");
//    Element title = newBook.addElement("title");
//    title.setText("凤姐玉照");
//    Element price = newBook.addElement("price");
//    price.setText("10000.01");
//}
