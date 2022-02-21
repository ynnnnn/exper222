package ynn.object;

public class User {
	private int id;
	private String username;
	private String password;
	private String flag="1";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.flag = "1";
		
	}
	public User(){
		super();
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", flag=" + flag + "]";
	}
	
	

}
