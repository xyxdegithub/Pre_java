package entity;

public class User {
	private String username;   //用户名
	private String password;   //密码
	private String email;      //邮箱
    private String phone;      //电话
    private int salt;          //盐值
    
	public User() {
		
	}
	public User(String username, String password, String email, String phone, int salt) {
		
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.salt = salt;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getSalt() {
		return salt;
	}
	public void setSalt(int salt) {
		this.salt = salt;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + ", phone=" + phone
				+ ", salt=" + salt + "]";
	}
	
	
    
}
