package administratorService;

import java.util.List;

import Bao.Enterprice;
import Bao.Job;
import Bao.Student;
import util.SQLUtli;

public class AdministratorImpl implements IAdministrator{

	public List<Job> receive(String sql, Object[] object) {
		
		return SQLUtli.queryJobs(sql, object);
	}

	public boolean setJobState(String sql, Object[] object) {
		// TODO Auto-generated method stub
		return SQLUtli.updata(sql, object);
	}

	public List<Student> queryStudents(String sql, Object[] object) {
		// TODO Auto-generated method stub
		return SQLUtli.queryStudent(sql, object);
	}

	public List<Enterprice> queryEnterprice(String sql, Object[] object) {
		// TODO Auto-generated method stub
		return SQLUtli.queryEnterPrice(sql, object);
	}

	public boolean passStudent(String sql, Object[] object) {
		// TODO Auto-generated method stub
		return SQLUtli.updata(sql, object);
	}

	public boolean passEnterprice(String sql, Object[] object) {
		// TODO Auto-generated method stub
		return SQLUtli.updata(sql, object);
	}

}
