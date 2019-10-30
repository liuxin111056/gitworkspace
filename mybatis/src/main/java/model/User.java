package model;

public class User {
	private int id;
	private String user_name;
	private String password;
	
	//添加构造函数时必须添加空构造，不然会报invalid types() or values()异常
	public User() {}
	public User(String username, String password) {
		this.user_name = username;
		this.password = password;
	}
	public User(int id, String username, String password) {
		this.id = id;
		this.user_name = username;
		this.password = password;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return user_name;
	}
	public void setUsername(String username) {
		this.user_name = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String toString() {
		return "User [id=" + id + ", username=" + user_name + ", password="+ password + "]";
	}
	
}
