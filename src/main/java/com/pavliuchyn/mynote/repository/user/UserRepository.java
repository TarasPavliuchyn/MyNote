package com.pavliuchyn.mynote.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pavliuchyn.mynote.model.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByLogin(String login);

}
