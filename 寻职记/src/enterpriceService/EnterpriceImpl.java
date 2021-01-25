package enterpriceService;

import java.util.List;

import Bao.ApplyJob;
import Bao.Job;
import util.SQLUtli;

public class EnterpriceImpl implements IEnterpriceService{

	public boolean publishJob(String sql, Object[] object) {
		return SQLUtli.updata(sql, object);
	}

	public boolean deleteJobs(String sql, Object[] object) {
		// TODO Auto-generated method stub
		return SQLUtli.updata(sql, object);
	}

	public List<ApplyJob> queryApplyInfo(String sql, Object[] object) {
		// TODO Auto-generated method stub
		return SQLUtli.queryApplystate(sql, object);
	}

	public boolean changeInfo(String sql, Object[] object) {
		// TODO Auto-generated method stub
		return SQLUtli.updata(sql, object);
	}

	public List<Job> queryJobsByPulish(String sql, Object[] object) {
		// TODO Auto-generated method stub
		return SQLUtli.queryJobs(sql, object);
	}

	public byte[] queryJianli(String sql, Object[] object) {
		// TODO Auto-generated method stub
		return SQLUtli.queryJianli(sql, object);
	}

}
