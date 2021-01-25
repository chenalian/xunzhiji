package systemServlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * Servlet implementation class RecevieInfo
 */
public class RecevieInfo extends HttpServlet {
	// 接收信息
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(request.getParameter("qid"));// 这个人发的
		
		String uid=(String)request.getSession().getAttribute("uid");// 这个人收
		//uid="110";
		String qid=request.getParameter("qid");
		//qid="113";
		//System.out.println(qid+" "+uid);
		// 解析 uid和qid共有的xml文件 异步的方式发回去
		try {
			readXML(qid,uid,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public static void readXML(String qid,String uid, HttpServletResponse response) throws Exception {
	    response.setCharacterEncoding("utf-8");
	    // 聊天记录文件
		 File file = new File("\\xunzhiji/xml/"+uid+"$"+qid+".xml");
//	    if(file.exists())
//	    {
//	    	response.getWriter().print("exit");
//	    }
//	    else response.getWriter().print("not exit");
	    if(file.exists())// 如果改文件存在，则开始解析聊天记录
	    {
	    	SAXReader reader = new SAXReader();
	    	Document document = reader.read(file);
		    Element root = document.getRootElement();
		    List<Element> childElements = root.elements();
		    for (Element child : childElements) {
		        
		    	if(child.attributeValue("uisread").equals("false"))
		    	{
		    		response.getWriter().print(child.elementText("message"));
			    	response.getWriter().print(" ");
			    	response.getWriter().print(child.elementText("SendTime"));
			    	
			    	// 修改属性为 已读
			    	child.setAttributeValue("uisread","ture");// 修改  将修改信息写入
			    	
			    	cahngeInfo(file,document);
		    	}
		    	
		    }
	    }
//	    response.getWriter().print("lala");
//	    response.getWriter().print("ououou");
	    
	}
	public static void cahngeInfo(File file,Document doc)
	{
		 
		 OutputFormat format=OutputFormat.createPrettyPrint();
		 format.setEncoding("GBK");
		 
		
		 
//		 XMLWriter writer=new XMLWriter(new FileOutputStream(new File(request.getRealPath("xml/"),"Text.xml")),format);
		 XMLWriter writer = null;
		try {
			writer = new XMLWriter(new FileOutputStream(file),format);
		} catch (UnsupportedEncodingException | FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		 
		 try {
			writer.write(doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
