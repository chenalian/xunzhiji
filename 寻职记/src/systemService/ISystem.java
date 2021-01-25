package systemService;

import java.util.List;

import Bao.Enterprice;
import Bao.Job;
import Bao.Student;

/*寻职记系统功能接口
 * 1.用于检验用户登录名和密码是否正确
 * 2.
 * */
public interface ISystem {
	public boolean checkuser(String sql,Object object[]);// 检验用户登录
	
	public List<Job> queryAllJobs(String sql,Object object[]);// 查询数据库中所有工作信息
	
	
	public List<Job> queryAllJobsbytiaojian(String sql,Object object[]);// 查询数据库中所有工作信息
	
	public boolean addStudent(String sql,Object object[]);// 学生注册
	
	public boolean addenterprice(String sql,Object object[]);// 企业注册
	
	public List<String> queryAllUsersUid(String sql,Object object[]);// 查询所有学生或者企业的uid
	
	
	public Student querystu(String sql,Object object[]);// 查询单个学生信息
	
	public Enterprice queryent(String sql,Object object[]);// 查询单个企业信息
	
	
	public int queryJobnums(String sql,Object object[]);// 查询工作总数
	
	public int queryJobnumsbytiaojian(String sql,Object object[]);// 查询工作总数
}
