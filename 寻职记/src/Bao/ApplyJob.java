package Bao;

public class ApplyJob {
/*
 * ѧ��id+��ҵid+����id����һ��Ͷ�ݣ�һ��ѧ��ֻ����һ������Ͷ��һ�ݼ���
 * */
String jobid;// ����id   
String qid;// ��ҵid
String uid;// ѧ��id
byte[] jianli=new byte[10024];// ����
int state;// ����״̬�� 1�����̼��Ѿ����գ�0����δ����)
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
