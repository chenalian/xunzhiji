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
// ���ڴ洢 �ض��ĵ�ѧ�����̼ҵ�������Ϣ


public class AddChatInfo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		System.out.println(request.getParameter("fabuid"));
//		
//		System.out.println(request.getParameter("message"));
		
		String uid=(String)request.getSession().getAttribute("uid");
		
		String qid=request.getParameter("fabuid");
		
		String message=request.getParameter("message");
		
		
		
		/*��D�����д���xml�ļ��У���������ھͲ��ô������ڸ��ļ������洴��xml�ļ�����������ھͲ��ô�����*/
		
		
		File xml=new File("\\xunzhiji/xml");
		
		/*�����ж�xml�ļ����Ƿ����*/
		if(xml.isDirectory())
		{
//			System.out.println("xml file exit");
		}
		else {
			xml.mkdir();// �����ھʹ����ļ���
		}
		
		// �����ж��ļ��Ƿ����
		File file=new File("\\xunzhiji/xml/"+uid+"$"+qid+".xml");
		if(!file.exists())// ����ļ�������
		{
			file.createNewFile();
		}
		
		
		response.setContentType("text/html");
		
		//String fileURL=request.getRealPath("xml/temm.xml");// �ļ�·��
		
		//File xmlFilePath = new File(request.getContextPath() + "/WebContent/xml/temm.xml");
		//System.out.println(xmlFilePath.getAbsolutePath());
		

		
	
		// ��ȡ������Ϣxml�ļ��Ƿ���� �������򴴽�
		Document doc =null;
		 SAXReader reader = new SAXReader();
		 try {
			 doc = reader.read(file);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 /*����������ĵ������򴴽�һ���ĵ�����*/
		if(doc==null) doc = DocumentHelper.createDocument();
		
		 
		 Element messages=doc.getRootElement();// ��ȡ�ĵ��ĸ��ڵ�
		 
		 if(messages==null)
		 {
			 messages=DocumentHelper.createElement("messages");// ������ͨ���
			 doc.setRootElement(messages);// ����Ϊ���ڵ�
		 }
		 
		 
//		 Element messages=DocumentHelper.createElement("messages");// ������ͨ���
//		 
//		 doc.setRootElement(messages);// ����Ϊ���ڵ�
		 
//		 messages.appendAttributes(arg0);
		 
	
		
		 
		 
		 
		 Element message1 =messages.addElement("message1");
		 
		 message1.setAttributeValue("uisread","false");// Ϊÿ����Ϣ��־λδ��
		 message1.setAttributeValue("qisread","false");// Ϊÿ����Ϣ��־λδ��
		 
//		 messages.appendAttributes(message1);
		 //messages.appendContent(message1);
		 //messages.appendAttributes(message1);
		 
		 
		 
		 message1.setAttributeValue("id", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		 
		 message1.addElement("message").setText(uid+"��"+qid+"˵:"+message);
		 
		 
		 message1.addElement("SendTime").addText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));// ���ʱ��
		 
		 
		 OutputFormat format=OutputFormat.createPrettyPrint();
		 format.setEncoding("GBK");
		 
		
		 
//		 XMLWriter writer=new XMLWriter(new FileOutputStream(new File(request.getRealPath("xml/"),"Text.xml")),format);
		 XMLWriter writer=new XMLWriter(new FileOutputStream(file),format);


		 
		 writer.write(doc);
		 
		 writer.close();
		 
//		 System.out.println("�ɹ����������Ϣ");
		
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
//    title.setText("�������");
//    Element price = newBook.addElement("price");
//    price.setText("10000.01");
//}
