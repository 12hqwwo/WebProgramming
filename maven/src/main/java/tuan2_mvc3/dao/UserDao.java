package tuan2_mvc3.dao;

import tuan2_mvc3.models.User;

public interface UserDao {
	User get(String username);

	void insert(User user);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

}
