package com.pavliuchyn.mynote.service.user;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pavliuchyn.mynote.model.user.User;
import com.pavliuchyn.mynote.repository.user.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(UserServiceImpl.class);
	@Resource
	public UserRepository userRepository;

	@Transactional
	public User create(User created) {
		User user = userRepository.save(created);
		LOGGER.info("User saved successfully, User Details=" + created);
		return user;
	}

	@Transactional
	public User findByLogin(String fname) {

		return userRepository.findByLogin(fname);
	}

}
