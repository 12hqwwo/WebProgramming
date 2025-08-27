package tuan2_mvc3.services;

import tuan2_mvc3.models.User;

public interface UserService {

	User login(String username, String password);
	User get(String username);
}
