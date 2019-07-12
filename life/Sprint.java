package com.nader.aria.assistant_blue.entities.life;



import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import com.nader.aria.assistant_blue.entities.abstracts.BaseEntity;
import com.nader.aria.assistant_blue.entities.enums.StateType;


@Entity
@Table(name="SPRINTS" , uniqueConstraints = @UniqueConstraint( columnNames= {"TITLE","CODE"}) )
@NamedQueries({
		@NamedQuery(name = Sprint.FIND_ALL_BY_LIFE,query = "select s from Sprint as s where s.life =:life"),
		@NamedQuery(name = Sprint.GET_ALL_SPRINT_CODE,query = "select s.code from Sprint as s ")
})
public class Sprint extends BaseEntity {

	public static final String FIND_ALL_BY_LIFE = "sprint.findAllByLife";
	public static final String GET_ALL_SPRINT_CODE = "sprint.getAllSprintCode";
	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} , fetch = FetchType.EAGER)
	@JoinColumn(name = "LIFE_ID")
	private Life life;

	@Column(name="RANK")
	private Long rank;

	@Column(name="TITLE"  )
	private String title;
	
	@Column(name="CODE")
	private String code;
	
	@Column(name="START_DATE")
	private LocalDate startDate;
	
	@Column(name="END_DATE")
	private LocalDate endDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name="STATE_TYPE")
	private StateType stateType;
	
	@OneToMany( cascade = {CascadeType.ALL} ,fetch = FetchType.LAZY , mappedBy ="sprint" )
	private List<Task> tasks;

	public Life getLife(){ return  life; }
	public void setLife(Life life){ this.life = life; }

	public Long getRank(){ return rank; }
	public void setRank(Long rank){ this.rank = rank; }

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	
	public String getCode() { return code; }
	public void setCode(String code) { this.code = code; }
	
	public LocalDate getStartDate() { return startDate; }
	public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
	
	public LocalDate getEndDate() { return endDate; }
	public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
	
	public StateType getStateType() { return stateType; }
	public void setStateType(StateType stateType) { this.stateType = stateType; }
	
	public List<Task> getTasks(){ return tasks; }
	public void setTasks(List<Task> tasks) { this.tasks = tasks; }

}
