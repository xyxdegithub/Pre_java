package cn.tedu.easymall.entity;

/**
 * 封装用户数据的JavaBean
 * 
 * JavaBean标配：无参构造器、带参构造器、get/set方法、toString()
 * 特别注意：如果需要将该对象保存到基于Hash算法的集合中，必须提供
 *          hashCode()和equals()方法，建议使用自动生成的逻辑
 */
public class User {
	
	private Integer id;
	private String username;
	private String password;
	private String email;
	private String phone;
	private Integer salt;
	
	public User() {
	}

	public User(String username, String password, Integer salt) {
		this.username = username;
		this.password = password;
		this.salt = salt;
	}

	public User(Integer id, String username, String password, String email,
			String phone) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSalt() {
		return salt;
	}

	public void setSalt(Integer salt) {
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

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", email=" + email + ", phone=" + phone
				+ ", salt=" + salt + "]";
	}
	
}
