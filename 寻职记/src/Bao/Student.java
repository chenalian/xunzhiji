package Bao;

public class Student {
	String uid=null;//id 号
	String upwd=null;//密码
	String uident=null;// 身份证
	String xuehao=null;// 学号
	String uname=null;//姓名
	int uage;// 年龄
	String usex;// 性别
	String unicheng=null;//昵称
	String uxueli=null;// 学历
	

	public Student(String uid, String upwd, String uident, String xuehao, String uname, int uage, String usex,
			String unicheng, String uxueli, String uschool, String utel, String umail, int state) {
		super();
		this.uid = uid;
		this.upwd = upwd;
		this.uident = uident;
		this.xuehao = xuehao;
		this.uname = uname;
		this.uage = uage;
		this.usex = usex;
		this.unicheng = unicheng;
		this.uxueli = uxueli;
		this.uschool = uschool;
		this.utel = utel;
		this.umail = umail;
		this.state = state;
	}

	public String getUident() {
		return uident;
	}

	public void setUident(String uident) {
		this.uident = uident;
	}

	public String getUxueli() {
		return uxueli;
	}

	public void setUxueli(String uxueli) {
		this.uxueli = uxueli;
	}

	String uschool=null;// 毕业学校
	//byte[] touxiang=null;//头像
	String utel=null;// 电话
	String umail=null;// 邮箱
	int state;// 用户状态 是否为有效用户 1表示有效 0表示无效
	public Student() {
		
	}
	


	public Student(String uid, String upwd, String xuehao, String uname, int uage, String usex, String unicheng,
			String uxueli, String uschool, String utel, String umail, int state) {
		super();
		this.uid = uid;
		this.upwd = upwd;
		this.xuehao = xuehao;
		this.uname = uname;
		this.uage = uage;
		this.usex = usex;
		this.unicheng = unicheng;
		this.uxueli = uxueli;
		this.uschool = uschool;
		this.utel = utel;
		this.umail = umail;
		this.state = state;
	}

	public Student(String uid, String upwd, String xuehao, String uname, int uage, String usex, String unicheng,
			String uschool, byte[] touxiang, String utel, String umail) {
		super();
		this.uid = uid;
		this.upwd = upwd;
		this.xuehao = xuehao;
		this.uname = uname;
		this.uage = uage;
		this.usex = usex;
		this.unicheng = unicheng;
		this.uschool = uschool;
//		this.touxiang = touxiang;
		this.utel = utel;
		this.umail = umail;
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
	public String getXuehao() {
		return xuehao;
	}
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getUage() {
		return uage;
	}
	public void setUage(int uage) {
		this.uage = uage;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public String getUnicheng() {
		return unicheng;
	}
	public void setUnicheng(String unicheng) {
		this.unicheng = unicheng;
	}
	public String getUschool() {
		return uschool;
	}
	public void setUschool(String uschool) {
		this.uschool = uschool;
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
}
