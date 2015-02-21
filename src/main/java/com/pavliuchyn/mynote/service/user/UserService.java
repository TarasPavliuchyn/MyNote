package com.pavliuchyn.mynote.service.user;

import com.pavliuchyn.mynote.model.user.User;

public interface UserService {

	User create(User created);

	User findByLogin(String login);

}
