package Bao;

public class Student {
	String uid=null;//id ��
	String upwd=null;//����
	String uident=null;// ���֤
	String xuehao=null;// ѧ��
	String uname=null;//����
	int uage;// ����
	String usex;// �Ա�
	String unicheng=null;//�ǳ�
	String uxueli=null;// ѧ��
	

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

	String uschool=null;// ��ҵѧУ
	//byte[] touxiang=null;//ͷ��
	String utel=null;// �绰
	String umail=null;// ����
	int state;// �û�״̬ �Ƿ�Ϊ��Ч�û� 1��ʾ��Ч 0��ʾ��Ч
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
