package studentservice;

import java.util.List;

import Bao.ApplyJob;
import Bao.Job;

/*ѧ���Ĺ���*/
public interface IStudentService {
	public List<Job> findJobs(String sql,Object object[]);// ��ѯ�ض��Ĺ���
	
	public List<ApplyJob> findJLstate(String sql,Object object[]);// ��ѯ�ύ������״̬
	
	public boolean changeinfo(String sql,Object object[]);// �޸ĸ�����Ϣ
	
	public boolean sendJianli(String sql,Object object[]);// ѧ�����ͼ���
}
