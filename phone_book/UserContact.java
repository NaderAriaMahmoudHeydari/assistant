package com.nader.aria.assistant_blue.entities.phone_book;


import com.nader.aria.assistant_blue.entities.abstracts.User;

import javax.persistence.*;

import java.util.List;


@Entity
@Table(name="USER_CONTACTS")
@DiscriminatorValue("USER_CONTACT_TYPE")
public class UserContact extends User {

	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.MERGE},fetch = FetchType.EAGER)
	@JoinColumn(name="PHONE_BOOK_ID")
	private PhoneBook phoneBook;

	@OneToOne( cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH} ,fetch = FetchType.EAGER )
	@JoinColumn(name="GROUP_ID")
	private Group group;

	@OneToMany(cascade = {CascadeType.REFRESH,CascadeType.MERGE},fetch = FetchType.EAGER,mappedBy = "userContact")
	private List<Phone> phones;

	@Column(name="DESCRIPTION")
	private String description;

	public PhoneBook getPhoneBook(){ return phoneBook; }
	public void setPhoneBook(PhoneBook phoneBook){ this.phoneBook = phoneBook; }

	public Group getGroup(){ return group; }
	public void setGroup(Group group){ this.group = group; }

	public List<Phone> getPhones(){ return phones; }
	public void setPhones(List<Phone> phones){ this.phones = phones; }

	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }


}
