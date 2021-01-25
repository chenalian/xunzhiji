package systemService;

import java.util.List;

import Bao.Enterprice;
import Bao.Job;
import Bao.Student;
import util.SQLUtli;

public class SystemImpl implements ISystem{

	@Override
	public boolean checkuser(String sql,Object object[]) {
		return SQLUtli.queryIsExit(sql, object);
	}

	@Override
	public List<Job> queryAllJobs(String sql, Object[] object) {
		return SQLUtli.queryJobs(sql, object);
	}

	@Override
	public boolean addStudent(String sql, Object[] object) {
		// TODO Auto-generated method stub
		return SQLUtli.updata(sql, object);
	}

	@Override
	public boolean addenterprice(String sql, Object[] object) {
		// TODO Auto-generated method stub
		return SQLUtli.updata(sql, object);
	}

	@Override
	public List<String> queryAllUsersUid(String sql, Object[] object) {
		// TODO Auto-generated method stub
		return SQLUtli.queryUserUid(sql, object);
	}

	@Override
	public Student querystu(String sql, Object[] object) {
		// TODO Auto-generated method stub
		return SQLUtli.queryStu(sql, object);
	}

	@Override
	public Enterprice queryent(String sql, Object[] object) {
		// TODO Auto-generated method stub
		return SQLUtli.queryEnt(sql, object);
	}

	@Override
	public int queryJobnums(String sql, Object[] object) {
		// TODO Auto-generated method stub
		return SQLUtli.queryListNus(sql, object);
	}

	@Override
	public List<Job> queryAllJobsbytiaojian(String sql, Object[] object) {
		// TODO Auto-generated method stub
		return SQLUtli.queryJobsbytiaojian(sql, object);
	}

	@Override
	public int queryJobnumsbytiaojian(String sql, Object[] object) {
		// TODO Auto-generated method stub
		return SQLUtli.queryListNusbytiaojian(sql, object);
	}

}
