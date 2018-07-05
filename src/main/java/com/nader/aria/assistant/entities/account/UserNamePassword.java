package com.nader.aria.assistant.entities.account;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.nader.aria.assistant.entities.abstracts.BaseEntity;

@Entity
@Table(name="USER_NAME_PASSWORDS" , uniqueConstraints = @UniqueConstraint(columnNames= {"USER_NAME"}) )
public class UserNamePassword extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name="USER_NAME")
	@NotNull
	@Size(min = 5)
	private String userName;
	
	@Column(name="PASSWORD")
	@NotNull
	@Size(min = 6)
	private String password;

	public UserNamePassword(){}

	public UserNamePassword(Long id,Long version,String userName,String password){

		super(id,version);
		this.userName = userName;
		this.password = password;

	}
	
	public String getUserName() { return userName; }
	public void setUserName(String userName) { this.userName = userName; }
	
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

}
