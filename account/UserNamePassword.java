package com.nader.aria.assistant_blue.entities.account;


import javax.persistence.*;
import com.nader.aria.assistant_blue.entities.abstracts.BaseEntity;

@Entity
@Table(name="USER_NAME_PASSWORDS" , uniqueConstraints = @UniqueConstraint(columnNames= {"USER_NAME"}) )
public class UserNamePassword extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="PASSWORD")
	private String password;

	public String getUserName() { return userName; }
	public void setUserName(String userName) { this.userName = userName; }
	
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

}
