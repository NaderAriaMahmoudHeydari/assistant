package com.nader.aria.assistant.entities.life;

import javax.persistence.*;
import java.util.List;
import com.nader.aria.assistant.entities.abstracts.BaseEntity;
import com.nader.aria.assistant.entities.enums.AimTimeType;
import com.nader.aria.assistant.entities.enums.AimType;
import com.nader.aria.assistant.entities.enums.StateType;


@Entity
@Table(name="AIMS" , uniqueConstraints = @UniqueConstraint( columnNames= {"LIFE_ID","TITLE","CODE"}) )
public class Aim extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name="LIFE_ID")
	private Life life;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="CODE")
	private String code;
	
	@Column(name="DESCRIPTION"  )
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name="AIM_TYPE")
	private AimType aimType;
	
	@Enumerated(EnumType.STRING)
	@Column(name="AIM_TIME_TYPE")
	private AimTimeType aimTimeType;
	
	@Enumerated(EnumType.STRING)
	@Column(name="STATE_TYPE")
	private StateType stateType;
	
	@OneToMany(cascade = {CascadeType.ALL} ,fetch = FetchType.LAZY , mappedBy="aim" )
	private List<Sprint> sprints;
	
	
	public Life getLife() { return life; }
	public void setLife(Life life) { this.life = life; }
	
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }

	public String getCode() { return code; }
	public void setCode(String code) { this.code = code; }
	
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	
	public AimType getAimType() { return aimType; }
	public void setAimType(AimType aimType) { this.aimType = aimType; }
	
	public AimTimeType getAimTimeType() { return aimTimeType; }
	public void setAimTimeType(AimTimeType aimTimeType) { this.aimTimeType = aimTimeType; }
	
	public StateType getStateType() { return stateType; }
	public void setStateType(StateType stateType) { this.stateType = stateType; }
	
	public List<Sprint> getSprints(){ return sprints; }
	public void setSprints(List<Sprint> sprints) { this.sprints = sprints; }
}
