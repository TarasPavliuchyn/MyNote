package com.pavliuchyn.mynote.model.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.pavliuchyn.mynote.model.note.Note;

@Entity
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID", nullable = false)
	private Long id;

	@Column(name = "LOGIN")
	@NotEmpty(message = "Login is required.")
	@Size(min = 3, max = 25, message = "Login must between 3 and 25 characters")
	@Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Login can consist only latin alphabet, arabic numerals, sign '_'.")
	private String login;

	@Column(name = "PASSWORD", nullable = false, length = 100)
	@NotEmpty(message = "Password is required.")
	@Size(min = 6, max = 25, message = "Please enter at least 6 symbols")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Password can consist only latin alphabet and numerals.")
	private String password;

	@OneToMany(mappedBy = "user")
	private List<Note> notes = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		super();
	}

	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password
				+ "]";
	}

}
