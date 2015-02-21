package com.pavliuchyn.mynote.model.note;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Contact {

	@Enumerated(EnumType.STRING)
	@Column(name = "CONTACT_TYPE", nullable = false)
	private ContactType contactType;
	private String contact;

	public ContactType getContactType() {
		return contactType;
	}

	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Contact(ContactType contactType, String contact) {
		super();
		this.contactType = contactType;
		this.contact = contact;
	}

	public Contact() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result
				+ ((contactType == null) ? 0 : contactType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (contactType != other.contactType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return contactType + ":"  + contact ;
	}
}
