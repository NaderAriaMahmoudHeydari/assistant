package com.nader.aria.assistant_blue.entities.life;


import javax.persistence.*;
import java.util.List;
import com.nader.aria.assistant_blue.entities.abstracts.BaseEntity;
import com.nader.aria.assistant_blue.entities.account.Login;


@Entity
@Table(name="LIFE_S")
@NamedQueries({
		@NamedQuery(name = Life.FIND_BY_LOGIN_ID,query = "select l from Life as l where l.login.id =: loginId "),
		@NamedQuery(name = Life.FIND_BY_LOGIN,query = "select l from Life as l where l.login =:login ")
})

public class Life extends BaseEntity {

	public static final String FIND_BY_LOGIN_ID = "life.findByLoginId";
	public static final String FIND_BY_LOGIN = "life.findByLogin";


	private static final long serialVersionUID = 1L;

	@OneToOne( cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} ,fetch = FetchType.EAGER )
	@JoinColumn(name ="LOGIN_ID" )
	private Login login;
	
	@OneToMany( cascade = {CascadeType.ALL} ,fetch = FetchType.LAZY , mappedBy="life" )
	private List<Aim> aims;

	@OneToMany( cascade = {CascadeType.ALL} ,fetch = FetchType.LAZY, mappedBy = "life")
	private List<Sprint> sprints;
	
	public Login getLogin() { return login; }
	public void setLogin(Login login) { this.login = login; }
	
	public List<Aim> getAims(){ return aims; }
	public void setAims(List<Aim> aims) { this.aims = aims; }

	public List<Sprint> getSprints(){ return sprints; }
	public void setSprints(List<Sprint> sprints){ this.sprints = sprints; }


	
}
