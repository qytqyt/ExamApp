package entity;

public class User {
	private String id, pwd,name,email,needfindpwd;
	public User() {
	}
	public User(String id, String pwd, String name,String email,String needfindpwd) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.needfindpwd = needfindpwd;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getId() {
		return id;
	}

	public String getNeedfindpwd() {
		return needfindpwd;
	}
	
	public void setNeedfindpwd(String needfindpwd) {
		this.needfindpwd = needfindpwd;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
