package com.nader.aria.assistant_blue.entities.account;

import javax.persistence.*;
import com.nader.aria.assistant_blue.entities.abstracts.BaseEntity;


@Entity
@Table(name="LOGIN_S")
@NamedQueries({
		@NamedQuery(name = Login.LOGIN_SELECT_BY_USER_NAME_AND_PASSWORD,
					query = "select l from Login as l where l.userNamePassword.userName =:userName and l.userNamePassword.password =:password"),
		@NamedQuery(name = Login.LOGIN_SELECT_BY_USER_NAME_PASSWORD,
					query = "select l from Login as l where l.userNamePassword =:userNamePassword ")
})
public class Login extends BaseEntity {

	public static final String LOGIN_SELECT_BY_USER_NAME_AND_PASSWORD = "login.selectByUserNameAndPassword";
	public static final String LOGIN_SELECT_BY_USER_NAME_PASSWORD = "login.selectByUserNamePassword";

	private static final long serialVersionUID = 1L;

	@OneToOne(cascade= {CascadeType.ALL} ,fetch= FetchType.EAGER )
	@JoinColumn(name="USER_ID")
	private Member member;

	@OneToOne(cascade= {CascadeType.ALL} ,fetch= FetchType.EAGER)
	@JoinColumn(name="USER_NAME_PASSWORD_ID")
	private UserNamePassword userNamePassword;

	public Member getMember(){ return member; }
	public void setMember(Member member){ this.member = member; }
	
	public UserNamePassword getUserNamePassword() { return userNamePassword; }
	public void setUserNamePassword(UserNamePassword userNamePassword) { this.userNamePassword = userNamePassword; }
	
}
