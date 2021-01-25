package Bao;

public class ApplyJob {
/*
 * 学生id+企业id+工作id决定一个投递，一个学生只能想一个工作投递一份简历
 * */
String jobid;// 工作id   
String qid;// 企业id
String uid;// 学生id
byte[] jianli=new byte[10024];// 简历
int state;// 接收状态（ 1代表商家已经接收，0代表未接收)
public ApplyJob() {
}


public String getJobid() {
	return jobid;
}
public void setJobid(String jobid) {
	this.jobid = jobid;
}
public ApplyJob(String jobid, String qid, String uid, byte[] jianli, int state) {
	super();
	this.jobid = jobid;
	this.qid = qid;
	this.uid = uid;
	this.jianli = jianli;
	this.state = state;
}
public String getQid() {
	return qid;
}
public void setQid(String qid) {
	this.qid = qid;
}
public String getUid() {
	return uid;
}
public void setUid(String uid) {
	this.uid = uid;
}
public byte[] getJianli() {
	return jianli;
}
public void setJianli(byte[] jianli) {
	this.jianli = jianli;
}
public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}

}
