package enterpriceService;

import java.util.List;

import Bao.ApplyJob;
import Bao.Job;

/*��ҵ���ܽӿ�*/
public interface IEnterpriceService {
	public boolean publishJob(String sql,Object object[]);// ��������
	
	public List<Job> queryJobsByPulish(String sql,Object object[]);// ��ѯ�̼ҷ������й���
	
	public boolean deleteJobs(String sql,Object object[]);// ɾ����������
	
	public List<ApplyJob> queryApplyInfo(String sql,Object object[]);// ��ѯ�յ��ļ���
	
	public boolean changeInfo(String sql,Object object[]);// �޸ĸ�����Ϣ
	
	
	 public byte[] queryJianli(String sql,Object object[]);// ��ѯѧ������
	 
}
