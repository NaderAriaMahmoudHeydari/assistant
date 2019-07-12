package com.nader.aria.assistant_blue.entities.phone_book;

import com.nader.aria.assistant_blue.entities.abstracts.BaseEntity;
import com.nader.aria.assistant_blue.entities.account.Login;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name ="PHONE_BOOKS")
public class PhoneBook extends BaseEntity {


	private static final long serialVersionUID = 1L;

	@OneToOne( cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} ,fetch = FetchType.EAGER )
	@JoinColumn(name="LOGIN_ID")
	private Login login;

	@OneToMany(cascade = {CascadeType.ALL} , fetch = FetchType.LAZY , mappedBy = "phoneBook" )
	private List<UserContact> userContacts;

	public Login getLogin(){ return login; }
	public void setLogin(Login login){ this.login = login; }

	public List<UserContact> getUserContacts(){ return userContacts; }
	public void setUserContacts(List<UserContact> userContacts){ this.userContacts = userContacts; }

}
