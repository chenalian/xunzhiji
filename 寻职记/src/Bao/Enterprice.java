package Bao;

public class Enterprice {
	
	String uid;//id
	String upwd;//����
	String ulicense;// Ӫҵִ��
	String uname;// ��ҵ����
	String uaddr;//��ַ
	String utel;//�绰
	public Enterprice(String uid, String upwd, String ulicense, String uname, String uaddr, String utel, String umail,
			String ujianli, int state) {
		super();
		this.uid = uid;
		this.upwd = upwd;
		this.ulicense = ulicense;
		this.uname = uname;
		this.uaddr = uaddr;
		this.utel = utel;
		this.umail = umail;
		this.ujianli = ujianli;
		this.state = state;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	String umail;//����
	String ujianli;// ����
	int state;// �û�״̬ �Ƿ�Ϊ��Ч�û� 1��ʾ��Ч 0��ʾ��Ч
	public Enterprice() {
	}
	public Enterprice(String uid, String upwd, String ulicense, String uaddr, String utel, String umail, String ujianli,
			int state) {
		super();
		this.uid = uid;
		this.upwd = upwd;
		this.ulicense = ulicense;
		this.uaddr = uaddr;
		this.utel = utel;
		this.umail = umail;
		this.ujianli = ujianli;
		this.state = state;
	}
	public Enterprice(String uid, String upwd, String ulicense, String uaddr, String utel, String umail,
			String ujianli) {
		super();
		this.uid = uid;
		this.upwd = upwd;
		this.ulicense = ulicense;
		this.uaddr = uaddr;
		this.utel = utel;
		this.umail = umail;
		this.ujianli = ujianli;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUlicense() {
		return ulicense;
	}
	public void setUlicense(String ulicense) {
		this.ulicense = ulicense;
	}
	public String getUaddr() {
		return uaddr;
	}
	public void setUaddr(String uaddr) {
		this.uaddr = uaddr;
	}
	public String getUtel() {
		return utel;
	}
	public void setUtel(String utel) {
		this.utel = utel;
	}
	public String getUmail() {
		return umail;
	}
	public void setUmail(String umail) {
		this.umail = umail;
	}
	public String getUjianli() {
		return ujianli;
	}
	public void setUjianli(String ujianli) {
		this.ujianli = ujianli;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
}
