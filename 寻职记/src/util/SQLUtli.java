package util;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Bao.ApplyJob;
import Bao.Enterprice;
import Bao.Job;
import Bao.Student;



public class SQLUtli {
	private static final String URL="jdbc:mysql://127.0.0.1:3307/xunzhiji?useSSL=true"; 
	private static final String NAME="root";
	private static final String PASSWORD="123456";
	private static Connection con=null;
	private static PreparedStatement pstm=null;
	private static ResultSet rs=null;
	public static void init()// 初始化数据
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection(URL,NAME,PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 查询工作
	public static List<Job> queryJobs(String sql,Object object[])
	{
		List<Job> objects=new ArrayList();
		try {
			init();
			pstm=con.prepareStatement(sql);
			if(object!=null)// 不为空的时候赋值
			{
				for(int i=0;i<object.length;i++)
				{
					
					 pstm.setObject(i+1, object[i]);
				}
			}
			rs=pstm.executeQuery();// 查询结构
			while(rs.next())
			{
				Job job=new Job(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10));
				objects.add(job);// 将查询到的信息，放入List中
			}
			return objects;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			closeAll(con,pstm,rs);
		}
	}
	// 查询工作
		public static List<Job> queryJobsbytiaojian(String sql,Object object[])
		{
			List<Job> objects=new ArrayList();
			try {
				init();
				pstm=con.prepareStatement(sql);
				if(object!=null)// 不为空的时候赋值
				{
					for(int i=0;i<object.length;i++)
					{
						if(i==0) pstm.setObject(i+1,"%"+(String)object[i]+"%");
						else pstm.setObject(i+1, object[i]);
					}
				}
				rs=pstm.executeQuery();// 查询结构
				while(rs.next())
				{
					Job job=new Job(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10));
					objects.add(job);// 将查询到的信息，放入List中
				}
				return objects;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return null;
			}
			catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			finally {
				closeAll(con,pstm,rs);
			}
		}
		// 查询表中数据的总条数
				public static int queryListNusbytiaojian(String sql,Object object[])
				{
					//List<Job> objects=new ArrayList();
					try {
						init();
						pstm=con.prepareStatement(sql);
						if(object!=null)// 不为空的时候赋值
						{
							for(int i=0;i<object.length;i++)
							{
								pstm.setObject(i+1, object[i]);
							}
						}
						rs=pstm.executeQuery();// 查询结构
						if(rs.next())
						{
							return rs.getInt(1);// 返回数据总条数
						}
//						return objects;
					}
					catch(SQLException e)
					{
						e.printStackTrace();
						return 0;
					}
					catch (Exception e) {
						e.printStackTrace();
						return 0;
					}
					finally {
						closeAll(con,pstm,rs);
					}
					return 0;
				}
	// 查询表中数据的总条数
		public static int queryListNus(String sql,Object object[])
		{
			//List<Job> objects=new ArrayList();
			try {
				init();
				pstm=con.prepareStatement(sql);
				if(object!=null)// 不为空的时候赋值
				{
					for(int i=0;i<object.length;i++)
					{
						if(i==0) pstm.setObject(i+1,"%"+(String)object[i]+"%");
						else pstm.setObject(i+1, object[i]);
					}
				}
				rs=pstm.executeQuery();// 查询结构
				if(rs.next())
				{
					return rs.getInt(1);// 返回数据总条数
				}
//				return objects;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return 0;
			}
			catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
			finally {
				closeAll(con,pstm,rs);
			}
			return 0;
		}
		
	public static List<ApplyJob> queryApplystate(String sql,Object object[])// 查询申请工作的状态
	{
		List<ApplyJob> applyjobs=new ArrayList<>();
		try {
			init();
			pstm=con.prepareStatement(sql);
			if(object!=null)// 不为空的时候赋值
			{
				for(int i=0;i<object.length;i++)
				{
					pstm.setObject(i+1, object[i]);
				}
			}
			rs=pstm.executeQuery();// 查询结构
			while(rs.next())
			{
				ApplyJob applyjob=new ApplyJob(rs.getString(1),rs.getString(2),rs.getString(3),rs.getBytes(4),rs.getInt(5));
				applyjobs.add(applyjob);// 将查询到的信息，放入List中
			}
			return applyjobs;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			closeAll(con,pstm,rs);
			return applyjobs;
		}
	}
	// 查询所有用户的uid
	public static List<String> queryUserUid(String sql,Object object[])// 查询申请工作的状态
	{
		List<String> usersUid=new ArrayList<>();
		try {
			init();
			pstm=con.prepareStatement(sql);
			if(object!=null)// 不为空的时候赋值
			{
				for(int i=0;i<object.length;i++)
				{
					pstm.setObject(i+1, object[i]);
				}
			}
			rs=pstm.executeQuery();// 查询结构
			while(rs.next())
			{
				//ApplyJob applyjob=new ApplyJob(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getBytes(5),rs.getInt(6));
				//applyjobs.add(applyjob);// 将查询到的信息，放入List中
				String temp=rs.getString(1);
				usersUid.add(temp);
				
			}
			return usersUid;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			closeAll(con,pstm,rs);
			return usersUid;
		}
	}
	// 查询特定简历  根据jobid qid uid
		public static byte[] queryJianli(String sql,Object object[])// 查询申请工作的状态
		{
//			List<String> usersUid=new ArrayList<>();
			try {
				init();
				pstm=con.prepareStatement(sql);
				if(object!=null)// 不为空的时候赋值
				{
					for(int i=0;i<object.length;i++)
					{
						pstm.setObject(i+1, object[i]);
					}
				}
				rs=pstm.executeQuery();// 查询结构
				if(rs.next())
				{
					//ApplyJob applyjob=new ApplyJob(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getBytes(5),rs.getInt(6));
					//applyjobs.add(applyjob);// 将查询到的信息，放入List中
//					String temp=rs.getString(1);
//					usersUid.add(temp);
					return rs.getBytes(4);
					
				}
//				return usersUid;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return null;
			}
			catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			finally {
				closeAll(con,pstm,rs);
//				return usersUid;
			}
			return null;
		}
	public static boolean updata(String sql,Object object[])// 增删改 数据库
	{
		try {
			init();
			pstm=con.prepareStatement(sql);
			if(object!=null)
			{
				for(int i=0;i<object.length;i++)
				{
					pstm.setObject(i+1, object[i]);
				}
			}
			int count=pstm.executeUpdate();
			if(count>0)
			{
				return true;
			}
			else {
				return false;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			closeAll(con,pstm,rs);
		}
	}
	//查询用户是否存在
	public static boolean queryIsExit(String sql,Object object[])
	{
		
		try {
			init();
			pstm=con.prepareStatement(sql);
			if(object!=null)
			{
				for(int i=0;i<object.length;i++)
				{
					pstm.setObject(i+1, object[i]);
				}
			}
			rs=pstm.executeQuery();// 查询结构
			if(rs.next())
			{
				if(rs.getInt(1)>0)
				{
					return true;
				}
				else {
					return false;
				}
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
		finally {
			closeAll(con,pstm,rs);
		}
		return false;
	}
	//查询 学生用户信息
	public static List<Student> queryStudent(String sql,Object object[])
	{
		List<Student> objects=new ArrayList();
		try {
			init();
			pstm=con.prepareStatement(sql);
			if(object!=null) {
				for(int i=0;i<object.length;i++)
				{
					pstm.setObject(i+1, object[i]);
				}
			}
			rs=pstm.executeQuery();// 查询结构
			while(rs.next())
			{
				Student user=new Student(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getInt(13));
				objects.add(user);// 将查询到的信息，放入List中
			}
			return objects;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
			
		}
		finally {
			closeAll(con,pstm,rs);
		}
	}
	// 查询单个学生信息
	public static Student queryStu(String sql,Object object[])
	{
//		List<Student> objects=new ArrayList();
		try {
			Student user=null;
			init();
			pstm=con.prepareStatement(sql);
			if(object!=null) {
				for(int i=0;i<object.length;i++)
				{
					pstm.setObject(i+1, object[i]);
				}
			}
			rs=pstm.executeQuery();// 查询结构
			if(rs.next())
			{
				 user=new Student(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getInt(13));
//				objects.add(user);// 将查询到的信息，放入List中
			}
			return user;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
			
		}
		finally {
			closeAll(con,pstm,rs);
		}
	}
	public static Enterprice queryEnt(String sql,Object object[])
	{
//		List<Enterprice> objects=new ArrayList();
		try {
			Enterprice user=null;
			init();
			pstm=con.prepareStatement(sql);
			if(object!=null) {
			for(int i=0;i<object.length;i++)
			{
				pstm.setObject(i+1, object[i]);
			}
			}
			rs=pstm.executeQuery();// 查询结构
			if(rs.next())
			{
				 user=new Enterprice(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9));
//				objects.add(user);// 将查询到的信息，放入List中
			}
			return user;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
			
		}
		finally {
			closeAll(con,pstm,rs);
		}
	}
	//查询 企业用户信息
		public static List<Enterprice> queryEnterPrice(String sql,Object object[])
		{
			List<Enterprice> objects=new ArrayList();
			try {
				init();
				pstm=con.prepareStatement(sql);
				if(object!=null) {
				for(int i=0;i<object.length;i++)
				{
					pstm.setObject(i+1, object[i]);
				}
				}
				rs=pstm.executeQuery();// 查询结构
				while(rs.next())
				{
					Enterprice user=new Enterprice(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9));
					objects.add(user);// 将查询到的信息，放入List中
				}
				return objects;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return null;
			
			}
			catch (Exception e) {
				e.printStackTrace();
				return null;
				
			}
			finally {
				closeAll(con,pstm,rs);
			}
		}
	// 关闭
	public static void closeAll( Connection con,Statement pstm,ResultSet rs)
	{
		if(rs!=null)
			try {
				rs.close();
				if(con!=null)con.close();
				if(pstm!=null)pstm.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
}
