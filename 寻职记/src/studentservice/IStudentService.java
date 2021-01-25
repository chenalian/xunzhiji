package studentservice;

import java.util.List;

import Bao.ApplyJob;
import Bao.Job;

/*学生的功能*/
public interface IStudentService {
	public List<Job> findJobs(String sql,Object object[]);// 查询特定的工作
	
	public List<ApplyJob> findJLstate(String sql,Object object[]);// 查询提交简历的状态
	
	public boolean changeinfo(String sql,Object object[]);// 修改个人信息
	
	public boolean sendJianli(String sql,Object object[]);// 学生发送简历
}
