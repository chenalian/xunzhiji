package administratorService;

import java.util.List;

import Bao.Enterprice;
import Bao.Job;
import Bao.Student;

// ����Ա���ܽӿ�
public interface IAdministrator {
	/*�����̼ҷ���Ҫ����˵Ĺ���*/
	public List<Job> receive(String sql,Object object[]);
	
	/*�޸��̼ҷ�������״̬*/
	public boolean setJobState(String sql,Object object[]);
	
	public List<Student> queryStudents(String sql,Object object[]);// ��ѯ�����ύע����Ϣ��ѧ��
	
	public List<Enterprice> queryEnterprice(String sql,Object object[]);// ��ѯ�����ύע����Ϣ����ҵ
	
	public boolean passStudent(String sql,Object object[]);// ͨ��ѧ�����
	
	public boolean passEnterprice(String sql,Object object[]);// ͨ����ҵ���
}
