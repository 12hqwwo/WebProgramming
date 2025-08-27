package vn.iostar.services.impl;

import vn.iostar.dao.UserDao;
import vn.iostar.dao.impl.UserDaoImp;
import vn.iostar.models.User;
import vn.iostar.services.UserService;

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
}
