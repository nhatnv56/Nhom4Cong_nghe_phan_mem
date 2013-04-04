package user.dataset;

public class User {
	/**
	 * 
	 */
	private String userName;
	private String password;
	private int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		this.password = "";
		this.userName = "";
	}

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

}
