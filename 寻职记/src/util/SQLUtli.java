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
	public static void init()// ��ʼ������
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
	// ��ѯ����
	public static List<Job> queryJobs(String sql,Object object[])
	{
		List<Job> objects=new ArrayList();
		try {
			init();
			pstm=con.prepareStatement(sql);
			if(object!=null)// ��Ϊ�յ�ʱ��ֵ
			{
				for(int i=0;i<object.length;i++)
				{
					
					 pstm.setObject(i+1, object[i]);
				}
			}
			rs=pstm.executeQuery();// ��ѯ�ṹ
			while(rs.next())
			{
				Job job=new Job(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10));
				objects.add(job);// ����ѯ������Ϣ������List��
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
	// ��ѯ����
		public static List<Job> queryJobsbytiaojian(String sql,Object object[])
		{
			List<Job> objects=new ArrayList();
			try {
				init();
				pstm=con.prepareStatement(sql);
				if(object!=null)// ��Ϊ�յ�ʱ��ֵ
				{
					for(int i=0;i<object.length;i++)
					{
						if(i==0) pstm.setObject(i+1,"%"+(String)object[i]+"%");
						else pstm.setObject(i+1, object[i]);
					}
				}
				rs=pstm.executeQuery();// ��ѯ�ṹ
				while(rs.next())
				{
					Job job=new Job(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10));
					objects.add(job);// ����ѯ������Ϣ������List��
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
		// ��ѯ�������ݵ�������
				public static int queryListNusbytiaojian(String sql,Object object[])
				{
					//List<Job> objects=new ArrayList();
					try {
						init();
						pstm=con.prepareStatement(sql);
						if(object!=null)// ��Ϊ�յ�ʱ��ֵ
						{
							for(int i=0;i<object.length;i++)
							{
								pstm.setObject(i+1, object[i]);
							}
						}
						rs=pstm.executeQuery();// ��ѯ�ṹ
						if(rs.next())
						{
							return rs.getInt(1);// ��������������
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
	// ��ѯ�������ݵ�������
		public static int queryListNus(String sql,Object object[])
		{
			//List<Job> objects=new ArrayList();
			try {
				init();
				pstm=con.prepareStatement(sql);
				if(object!=null)// ��Ϊ�յ�ʱ��ֵ
				{
					for(int i=0;i<object.length;i++)
					{
						if(i==0) pstm.setObject(i+1,"%"+(String)object[i]+"%");
						else pstm.setObject(i+1, object[i]);
					}
				}
				rs=pstm.executeQuery();// ��ѯ�ṹ
				if(rs.next())
				{
					return rs.getInt(1);// ��������������
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
		
	public static List<ApplyJob> queryApplystate(String sql,Object object[])// ��ѯ���빤����״̬
	{
		List<ApplyJob> applyjobs=new ArrayList<>();
		try {
			init();
			pstm=con.prepareStatement(sql);
			if(object!=null)// ��Ϊ�յ�ʱ��ֵ
			{
				for(int i=0;i<object.length;i++)
				{
					pstm.setObject(i+1, object[i]);
				}
			}
			rs=pstm.executeQuery();// ��ѯ�ṹ
			while(rs.next())
			{
				ApplyJob applyjob=new ApplyJob(rs.getString(1),rs.getString(2),rs.getString(3),rs.getBytes(4),rs.getInt(5));
				applyjobs.add(applyjob);// ����ѯ������Ϣ������List��
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
	// ��ѯ�����û���uid
	public static List<String> queryUserUid(String sql,Object object[])// ��ѯ���빤����״̬
	{
		List<String> usersUid=new ArrayList<>();
		try {
			init();
			pstm=con.prepareStatement(sql);
			if(object!=null)// ��Ϊ�յ�ʱ��ֵ
			{
				for(int i=0;i<object.length;i++)
				{
					pstm.setObject(i+1, object[i]);
				}
			}
			rs=pstm.executeQuery();// ��ѯ�ṹ
			while(rs.next())
			{
				//ApplyJob applyjob=new ApplyJob(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getBytes(5),rs.getInt(6));
				//applyjobs.add(applyjob);// ����ѯ������Ϣ������List��
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
	// ��ѯ�ض�����  ����jobid qid uid
		public static byte[] queryJianli(String sql,Object object[])// ��ѯ���빤����״̬
		{
//			List<String> usersUid=new ArrayList<>();
			try {
				init();
				pstm=con.prepareStatement(sql);
				if(object!=null)// ��Ϊ�յ�ʱ��ֵ
				{
					for(int i=0;i<object.length;i++)
					{
						pstm.setObject(i+1, object[i]);
					}
				}
				rs=pstm.executeQuery();// ��ѯ�ṹ
				if(rs.next())
				{
					//ApplyJob applyjob=new ApplyJob(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getBytes(5),rs.getInt(6));
					//applyjobs.add(applyjob);// ����ѯ������Ϣ������List��
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
	public static boolean updata(String sql,Object object[])// ��ɾ�� ���ݿ�
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
	//��ѯ�û��Ƿ����
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
			rs=pstm.executeQuery();// ��ѯ�ṹ
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
	//��ѯ ѧ���û���Ϣ
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
			rs=pstm.executeQuery();// ��ѯ�ṹ
			while(rs.next())
			{
				Student user=new Student(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getInt(13));
				objects.add(user);// ����ѯ������Ϣ������List��
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
	// ��ѯ����ѧ����Ϣ
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
			rs=pstm.executeQuery();// ��ѯ�ṹ
			if(rs.next())
			{
				 user=new Student(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getInt(13));
//				objects.add(user);// ����ѯ������Ϣ������List��
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
			rs=pstm.executeQuery();// ��ѯ�ṹ
			if(rs.next())
			{
				 user=new Enterprice(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9));
//				objects.add(user);// ����ѯ������Ϣ������List��
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
	//��ѯ ��ҵ�û���Ϣ
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
				rs=pstm.executeQuery();// ��ѯ�ṹ
				while(rs.next())
				{
					Enterprice user=new Enterprice(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9));
					objects.add(user);// ����ѯ������Ϣ������List��
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
	// �ر�
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
