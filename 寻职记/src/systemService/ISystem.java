package systemService;

import java.util.List;

import Bao.Enterprice;
import Bao.Job;
import Bao.Student;

/*Ѱְ��ϵͳ���ܽӿ�
 * 1.���ڼ����û���¼���������Ƿ���ȷ
 * 2.
 * */
public interface ISystem {
	public boolean checkuser(String sql,Object object[]);// �����û���¼
	
	public List<Job> queryAllJobs(String sql,Object object[]);// ��ѯ���ݿ������й�����Ϣ
	
	
	public List<Job> queryAllJobsbytiaojian(String sql,Object object[]);// ��ѯ���ݿ������й�����Ϣ
	
	public boolean addStudent(String sql,Object object[]);// ѧ��ע��
	
	public boolean addenterprice(String sql,Object object[]);// ��ҵע��
	
	public List<String> queryAllUsersUid(String sql,Object object[]);// ��ѯ����ѧ��������ҵ��uid
	
	
	public Student querystu(String sql,Object object[]);// ��ѯ����ѧ����Ϣ
	
	public Enterprice queryent(String sql,Object object[]);// ��ѯ������ҵ��Ϣ
	
	
	public int queryJobnums(String sql,Object object[]);// ��ѯ��������
	
	public int queryJobnumsbytiaojian(String sql,Object object[]);// ��ѯ��������
}
