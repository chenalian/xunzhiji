package Bao;

public class Enterprice {
	
	String uid;//id
	String upwd;//密码
	String ulicense;// 营业执照
	String uname;// 企业名称
	String uaddr;//地址
	String utel;//电话
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
	String umail;//邮箱
	String ujianli;// 简历
	int state;// 用户状态 是否为有效用户 1表示有效 0表示无效
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
