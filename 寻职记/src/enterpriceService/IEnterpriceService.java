package enterpriceService;

import java.util.List;

import Bao.ApplyJob;
import Bao.Job;

/*企业功能接口*/
public interface IEnterpriceService {
	public boolean publishJob(String sql,Object object[]);// 发布工作
	
	public List<Job> queryJobsByPulish(String sql,Object object[]);// 查询商家发布所有工作
	
	public boolean deleteJobs(String sql,Object object[]);// 删除发布工作
	
	public List<ApplyJob> queryApplyInfo(String sql,Object object[]);// 查询收到的简历
	
	public boolean changeInfo(String sql,Object object[]);// 修改个人信息
	
	
	 public byte[] queryJianli(String sql,Object object[]);// 查询学生简历
	 
}
