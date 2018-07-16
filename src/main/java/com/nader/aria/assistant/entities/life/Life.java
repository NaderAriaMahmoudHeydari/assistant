package com.nader.aria.assistant.entities.life;


import javax.persistence.*;
import java.util.List;
import com.nader.aria.assistant.entities.abstracts.BaseEntity;
import com.nader.aria.assistant.entities.account.Login;


@Entity
@Table(name="LIFES")
public class Life extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@OneToOne( cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} ,fetch = FetchType.EAGER )
	@JoinColumn(name ="LOGIN_ID" )
	private Login login;
	
	@OneToMany( cascade = {CascadeType.ALL} ,fetch = FetchType.LAZY , mappedBy="life" )
	private List<Aim> aims;
	
	public Login getLogin() { return login; }
	public void setLogin(Login login) { this.login = login; }
	
	public List<Aim> getAims(){ return aims; }
	public void setAims(List<Aim> aims) { this.aims = aims; }
	
}
