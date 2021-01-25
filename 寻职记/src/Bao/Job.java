package Bao;

public class Job {
public Job(String jobid, String qid, String qname, String post, String postneed, String jobaddr, String salary,
			String sTime, String eTime) {
		super();
		this.jobid = jobid;
		this.qid = qid;
		this.qname = qname;
		this.post = post;
		this.postneed = postneed;
		this.jobaddr = jobaddr;
		this.salary = salary;
		this.sTime = sTime;
		this.eTime = eTime;
	}

String jobid;// id
String qid;// 企业id
String qname;// 企业名称
String post;// 岗位
String postneed;// 岗位要求
String jobaddr;//地址
String salary;// 薪水
String sTime;// 开始时间
String eTime;//截止时间

int nsm;// 人数


public Job() {

}

public Job(String jobid, String qid, String qname, String post, String postneed, String jobaddr, String salary,
		String sTime, String eTime, int nsm) {
	super();
	this.jobid = jobid;
	this.qid = qid;
	this.qname = qname;
	this.post = post;
	this.postneed = postneed;
	this.jobaddr = jobaddr;
	this.salary = salary;
	this.sTime = sTime;
	this.eTime = eTime;
	this.nsm = nsm;
}

public int getNsm() {
	return nsm;
}

public void setNsm(int nsm) {
	this.nsm = nsm;
}

public String getJobid() {
	return jobid;
}

public void setJobid(String jobid) {
	this.jobid = jobid;
}

public String getQid() {
	return qid;
}

public void setQid(String qid) {
	this.qid = qid;
}

public String getQname() {
	return qname;
}

public void setQname(String qname) {
	this.qname = qname;
}

public String getPost() {
	return post;
}

public void setPost(String post) {
	this.post = post;
}

public String getPostneed() {
	return postneed;
}

public void setPostneed(String postneed) {
	this.postneed = postneed;
}

public String getJobaddr() {
	return jobaddr;
}

public void setJobaddr(String jobaddr) {
	this.jobaddr = jobaddr;
}

public String getSalary() {
	return salary;
}

public void setSalary(String salary) {
	this.salary = salary;
}

public String getsTime() {
	return sTime;
}

public void setsTime(String sTime) {
	this.sTime = sTime;
}

public String geteTime() {
	return eTime;
}

public void seteTime(String eTime) {
	this.eTime = eTime;
}

}
