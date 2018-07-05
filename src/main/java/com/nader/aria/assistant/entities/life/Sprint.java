package com.nader.aria.assistant.entities.life;



import javax.persistence.*;
import java.util.Calendar;
import java.util.List;
import com.nader.aria.assistant.entities.abstracts.BaseEntity;
import com.nader.aria.assistant.entities.enums.StateType;


@Entity
@Table(name="SPRINTS" , uniqueConstraints = @UniqueConstraint( columnNames= {"AIM_ID","TITLE","CODE"}) )
public class Sprint extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name="AIM_ID")
	private Aim aim;
	
	@Column(name="TITLE"  )
	private String title;
	
	@Column(name="CODE")
	private String code;
	
	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Calendar startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Calendar endDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name="STATE_TYPE")
	private StateType stateType;
	
	@OneToMany( cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH} ,fetch = FetchType.LAZY , mappedBy ="sprint" )
	private List<Task> tasks;
	
	
	public Aim getAim() { return aim; }
	public void setAim(Aim aim) { this.aim = aim; }
	
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	
	public String getCode() { return code; }
	public void setCode(String code) { this.code = code; }
	
	public Calendar getStartDate() { return startDate; }
	public void setStartDate(Calendar startDate) { this.startDate = startDate; }
	
	public Calendar getEndDate() { return endDate; }
	public void setEndDate(Calendar endDate) { this.endDate = endDate; }
	
	public StateType getStateType() { return stateType; }
	public void setStateType(StateType stateType) { this.stateType = stateType; }
	
	public List<Task> getTasks(){ return tasks; }
	public void setTasks(List<Task> tasks) { this.tasks = tasks; }
}
