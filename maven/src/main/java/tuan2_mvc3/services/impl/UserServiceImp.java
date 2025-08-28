package tuan2_mvc3.services.impl;

import tuan2_mvc3.dao.UserDao;
import tuan2_mvc3.dao.impl.UserDaoImp;
import tuan2_mvc3.models.User;
import tuan2_mvc3.services.UserService;

public class UserServiceImp implements UserService {
	UserDao userDao = new UserDaoImp();

	@Override
	public User login(String username, String password) {
		User user = this.get(username);
		if (user != null && password.equals(user.getPassWord())) {
			return user;
		}
		return null;
	}

	@Override
	public User get(String username) {
		return userDao.get(username);
	}

	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public void insert(User user) {
		userDao.insert(user);
	}

	@Override
	public boolean register(String username, String password, String email, String fullname) {
	    if (userDao.checkExistUsername(username)) {
	        return false;
	    }

	    User user = new User();
	    user.setEmail(email);
	    user.setUserName(username);
	    user.setFullName(fullname);
	    user.setPassWord(password);
	    user.setAvatar("default.png"); // avatar mặc định

	    userDao.insert(user);
	    return true;
	}


}
