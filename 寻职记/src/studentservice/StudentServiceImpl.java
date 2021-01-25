package studentservice;

import java.util.List;

import Bao.ApplyJob;
import Bao.Job;
import util.SQLUtli;

public class StudentServiceImpl implements IStudentService{

	public List<Job> findJobs(String sql, Object[] object) {
		// TODO Auto-generated method stub
		return SQLUtli.queryJobs(sql, object);
	}

	public List<ApplyJob> findJLstate(String sql, Object[] object) {
		// TODO Auto-generated method stub
		return SQLUtli.queryApplystate(sql, object);
	}

	public boolean changeinfo(String sql, Object[] object) {
		// TODO Auto-generated method stub
		return SQLUtli.updata(sql, object);
	}

	public boolean sendJianli(String sql, Object[] object) {
		return SQLUtli.updata(sql, object);
	}
}
