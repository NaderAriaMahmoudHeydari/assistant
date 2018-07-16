package com.nader.aria.assistant.entities.account;

import javax.persistence.*;
import javax.validation.Valid;
import com.nader.aria.assistant.entities.abstracts.BaseEntity;
import com.nader.aria.assistant.entities.enums.Language;

@Entity
@Table(name="LOGINS")
public class Login extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@OneToOne(cascade= {CascadeType.ALL} ,fetch= FetchType.EAGER )
	@JoinColumn(name="USER_ID")
	@Valid
	private User user;

	@OneToOne(cascade= {CascadeType.ALL} ,fetch= FetchType.EAGER)
	@JoinColumn(name="USER_NAME_PASSWORD_ID")
	@Valid
	private UserNamePassword userNamePassword;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name="LANGUAGE")
	private Language language;

	public Login(){}

	public Login(Long id,Long version,User user,UserNamePassword userNamePassword,Language language){

		super(id,version);
		this.user = user;
		this.userNamePassword = userNamePassword;
		this.language = language;

	}
		
	public User getUser() { return user; }
	public void setUser(User user) { this.user = user; }
	
	public UserNamePassword getUserNamePassword() { return userNamePassword; }
	public void setUserNamePassword(UserNamePassword userNamePassword) { this.userNamePassword = userNamePassword; }
	
	public Language getLanguage() { return language; }
	public void setLanguage(Language language) { this.language = language; }
	
}
