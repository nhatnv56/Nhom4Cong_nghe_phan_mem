package user.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import user.dataset.User;
import util.HibernateUtil;

public class UserDaoImpl implements UserDao {
	private List<User> userList;

	public List<User> getUserList() {
		findAll();
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	@Override
	public User add(User user) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		return user;
	}

	@Override
	public User delete(User user) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.delete(user);
		session.getTransaction().commit();
		session.close();
		return user;
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		if (null != user) {
			session.update(user);
		}
		session.getTransaction().commit();
		session.close();
		return user;
	}

	@Override
	public User check(User user) {
		// TODO Auto-generated method stub
		if (user == null)
			return null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String queryString = "FROM User WHERE userName = :userName AND password = :password";
		Query query = session.createQuery(queryString);
		query.setParameter("userName", user.getUserName());
		query.setParameter("password", user.getPassword());
		User res = (User) query.uniqueResult();
		session.close();
		return res;
	}

	public void findAll() {
		String queryString = "FROM User ";
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		userList = session.createQuery(queryString).list();
		session.close();
	}

	public int sizelist() {
		return this.userList.size();
	}

}
