package user.dao;

import user.dataset.User;

public interface UserDao {
	User add(User user);

	User check(User user);

	User delete(User user);

	User update(User user);
}
