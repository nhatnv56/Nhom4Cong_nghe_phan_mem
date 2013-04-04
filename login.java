package user.action;

import java.util.List;

import user.dao.UserDao;
import user.dao.UserDaoImpl;
import user.dataset.User;

public class Login extends UserDaoImpl {
	private List<User> listuser;
	private String userName;
	private String password;
	private int size;

	public int getSize() {
		return size;
	}

	public void setSize() {
		UserDaoImpl list = new UserDaoImpl();
		this.size = list.sizelist();
	}

	public String getUserName() {
		return userName;
	}

	public List<User> getListuser() {
		return listuser;
	}

	public void setListuser() {
		UserDaoImpl list = new UserDaoImpl();
		this.listuser = list.getUserList();
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

	public String checkLogin() {
		UserDao userDao = new UserDaoImpl();
		if (userName == null || password == null) {
			return "failure";
		} else {
			User user = new User(userName, password);
			if (userDao.check(user) != null)
				return "success";
			else
				return "failure";

		}

	}

	public Login() {
		this.password = "";
		this.userName = "";
		UserDaoImpl list = new UserDaoImpl();
		this.listuser = list.getUserList();
	}

	public static void main(String[] args) {
		Login a = new Login();
		System.out.print("userName: " + a.listuser.get(0).getUserName());
	}
}
