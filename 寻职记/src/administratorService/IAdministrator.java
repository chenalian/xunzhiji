package administratorService;

import java.util.List;

import Bao.Enterprice;
import Bao.Job;
import Bao.Student;

// 管理员功能接口
public interface IAdministrator {
	/*接收商家发布要求审核的工作*/
	public List<Job> receive(String sql,Object object[]);
	
	/*修改商家发布工作状态*/
	public boolean setJobState(String sql,Object object[]);
	
	public List<Student> queryStudents(String sql,Object object[]);// 查询所有提交注册信息的学生
	
	public List<Enterprice> queryEnterprice(String sql,Object object[]);// 查询所有提交注册信息的企业
	
	public boolean passStudent(String sql,Object object[]);// 通过学生审核
	
	public boolean passEnterprice(String sql,Object object[]);// 通过企业审核
}
