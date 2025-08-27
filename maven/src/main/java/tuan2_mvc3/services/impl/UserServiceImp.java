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
}
