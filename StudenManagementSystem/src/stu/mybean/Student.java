package stu.mybean;

public class Student {

	
	
	public static final int PAGE_SIZE = 8;
	private int sid;
	private String sname;
	private int sage;
	private String ssex;
	private String home;
	
	
	public Student( ) {			
	}
	
	
	public Student( String sname, int sage, String ssex, String home) {
			
		this.sname = sname;
		this.sage = sage;
		this.ssex = ssex;
		this.home = home;
	}
	
	
	
	public Student(int sid, String sname, int sage, String ssex, String home) {
		
		this.sid = sid;
		this.sname = sname;
		this.sage = sage;
		this.ssex = ssex;
		this.home = home;
	}
	
	
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	
	public String toString(){
		return this.getSid()+"-"+this.getSname()+"-"+this.getSage()+"-"+this.getSsex()+"-"+this.getHome();
	}
	

}
