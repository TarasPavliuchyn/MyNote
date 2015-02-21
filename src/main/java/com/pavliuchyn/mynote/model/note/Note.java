package com.pavliuchyn.mynote.model.note;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.pavliuchyn.mynote.model.user.User;

@Entity
@Table(name = "NOTES")
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "NOTE_ID", nullable = false)
	private Long id;

	@Column(name = "FIRST_NAME")
	@NotEmpty(message = "First Name is required.")
	@Size(min = 2, max = 25, message = "First Name must between 3 and 25 characters.")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Login can consist only latin alphabet.")
	private String firstName;

	@Column(name = "LAST_NAME")
	@NotEmpty(message = "Last Name is required.")
	@Size(min = 2, max = 25, message = "Last Name must between 3 and 25 characters.")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Last Name can consist only latin alphabet.")
	private String lastName;

	@Column(name = "PATRONYMIC")
	@NotEmpty(message = "Last Name is required.")
	@Size(min = 2, max = 25, message = "Middle Name must between 3 and 25 characters.")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Middle Name can consist only latin alphabet.")
	private String patronymic;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "CONTACTS", joinColumns = @JoinColumn(name = "NOTE_ID"))
	private List<Contact> contacts = new ArrayList<>();

	@Column(name = "COMMENT")
	@NotEmpty(message = "Comment is required.")
	@Size(min = 3, max = 25, message = "Comment must between 3 and 25 characters.")
	private String comment;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Note(String firstName, String lastName, String patronymic,
			List<Contact> contacts, String comment, User user) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.patronymic = patronymic;
		this.contacts = contacts;
		this.comment = comment;
		this.user = user;
	}

	public Note() {
		super();
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", patronymic=" + patronymic + ", contacts="
				+ contacts + ", comment=" + comment + ", user=" + user + "]";
	}

}
