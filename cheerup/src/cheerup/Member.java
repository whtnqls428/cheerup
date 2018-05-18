package cheerup;

public class Member {   //DTO Å¬·¡½º
	private String name;
	private int age;
	private String tel;
	private String memnum;
	public Member(String name, int age, String tel, String memnum) {
		super();
		this.name = name;
		this.age = age;
		this.tel = tel;
		this.memnum = memnum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMemnum() {
		return memnum;
	}
	public void setMemnum(String memnum) {
		this.memnum = memnum;
	}
	
}
