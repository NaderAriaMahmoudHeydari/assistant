package com.nader.aria.assistant_blue.entities.life;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;
import com.nader.aria.assistant_blue.entities.abstracts.BaseEntity;
import com.nader.aria.assistant_blue.entities.enums.PriorityType;
import com.nader.aria.assistant_blue.entities.enums.ScheduleType;
import com.nader.aria.assistant_blue.entities.financial.Financial;
import com.nader.aria.assistant_blue.entities.reminder.Reminder;


@Entity
@Table(name="TASKS" , uniqueConstraints = @UniqueConstraint( columnNames= {"SPRINT_ID","TITLE","CODE"}) )
@Inheritance(strategy = InheritanceType.JOINED )
@DiscriminatorColumn(name = "TASK_CHILD_TYPE" , discriminatorType = DiscriminatorType.STRING )
@NamedQueries({
		@NamedQuery(name = Task.FIND_ALL,query = "select t from Task as t "),
		@NamedQuery(name = Task.FIND_ALL_BY_AIM,query = "select t from Task as t where t.aim =:aim"),
		@NamedQuery(name = Task.FIND_ALL_BY_SPRINT,query = "select t from Task as t where t.sprint =:sprint"),
		@NamedQuery(name = Task.GET_ALL_TASK_CODE,query = "select t.code from Task as t")
})
public class Task extends BaseEntity {

	public static final String FIND_ALL = "task.findAll";
	public static final String FIND_ALL_BY_AIM = "task.findAllByAim";
	public static final String FIND_ALL_BY_SPRINT = "task.findAllSprint";
	public static final String GET_ALL_TASK_CODE = "task.getAllTaskCode";

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name = "AIM_ID")
	private Aim aim;

	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name="SPRINT_ID")
	private Sprint sprint;

	@Column(name="RANK")
	private Long rank;
	
	@Column(name ="TITLE"   )
	private String title;
	
	@Column(name="DESCRIPTION"  )
	private String description;
	
	@Column(name="CODE")
	private String code;
	
	@Enumerated( EnumType.STRING )
	@Column(name="PRIORITY_TYPE")
	private PriorityType priorityType;
	
	@Enumerated( EnumType.STRING )
	@Column(name="SCHEDULE_TYPE")
	private ScheduleType scheduleType;
	
	@Column(name="TIME_PREDICTION")
	private String timePrediction;//پیش بینی زمان
	
	@OneToMany( cascade = {CascadeType.ALL} ,fetch = FetchType.LAZY , mappedBy ="task")
	private List<TaskLog> taskLogs;
	
	@OneToOne( cascade = {CascadeType.ALL} ,fetch = FetchType.EAGER )
	@JoinColumn(name="FINANCIAL_ID"   )
	private Financial financial;
	
	@OneToOne( cascade = {CascadeType.ALL} ,fetch = FetchType.EAGER )
	@JoinColumn(name="REMINDER_ID"  )
	private Reminder reminder;
	
	@OneToMany( cascade = {CascadeType.DETACH,CascadeType.REFRESH} ,fetch = FetchType.LAZY , mappedBy ="dependency")
	private List<Task> dependencies;
	
	@ManyToOne( cascade = {CascadeType.DETACH,CascadeType.REFRESH} ,fetch = FetchType.EAGER )
	@JoinColumn(name="DEPENDENCY_ID"  )
	private Task dependency;

	@Transient
	private long financialValue;

	@Transient
	private long taskLogSum;

	@Transient
	private LocalDateTime reminderActiveTime;

	@Transient
	private int dependencySum;

	public Aim getAim(){ return aim; }
	public void setAim(Aim aim){ this.aim = aim; }

	public Sprint getSprint() { return sprint; }
	public void setSprint(Sprint sprint) { this.sprint = sprint; }

	public Long getRank(){ return rank; }
	public void setRank(Long rank){ this.rank = rank; }

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	
	public String getCode() { return code; }
	public void setCode(String code) { this.code = code; }
	
	public PriorityType getPriorityType() { return priorityType; }
	public void setPriorityType(PriorityType priorityType) { this.priorityType = priorityType; }
	
	public ScheduleType getScheduleType() { return scheduleType; }
	public void setScheduleType(ScheduleType scheduleType) { this.scheduleType = scheduleType; }

	public String getTimePrediction() { return timePrediction; }
	public void setTimePrediction(String timePrediction) { this.timePrediction = timePrediction; }
	
	public List<TaskLog> getTaskLogs(){ return taskLogs; }
	public void setTaskLogs(List<TaskLog> taskLogs) { this.taskLogs = taskLogs; }
	
	public Financial getFinancial() { return financial; }
	public void setFinancial(Financial financial) { this.financial = financial; }
	
	public Reminder getReminder() { return reminder; }
	public void setReminder(Reminder reminder) { this.reminder = reminder; }
	
	public List<Task> getDependencies(){ return dependencies; }
	public void setDependencies(List<Task> dependencies) { this.dependencies = dependencies; }
	
	public Task getDependency() { return dependency; }
	public void setDependency(Task dependency) { this.dependency = dependency; }

	public final long getFinancialValue(){
		return getFinancial().getValue();
	}

	public final long getTaskLogSum(){

		return this.getTaskLogs().stream().mapToLong(t->
			 t.getLogHours()+t.getLogMinutes()+t.getLogSeconds()
		).sum();
	}

	private LocalDateTime getReminderActiveTime(){
		return ( this.getReminder().isActive() )? this.getReminder().getTimeActivated():null;
	}


	private int getDependencySum(){
		return (this.getDependencies().size());
	}


	
}
