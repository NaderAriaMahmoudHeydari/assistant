package com.nader.aria.assistant.entities.life;

import java.util.Calendar;
import java.util.List;
import javax.persistence.*;
import com.nader.aria.assistant.entities.abstracts.BaseEntity;
import com.nader.aria.assistant.entities.enums.PriorityType;
import com.nader.aria.assistant.entities.enums.TaskType;
import com.nader.aria.assistant.entities.financial.Financial;
import com.nader.aria.assistant.entities.reminder.Reminder;


@Entity
@Table(name="TASKS" , uniqueConstraints = @UniqueConstraint( columnNames= {"SPRINT_ID","TITLE","CODE"}) )
@Inheritance(strategy = InheritanceType.JOINED )
@DiscriminatorColumn(name = "TASK_CHILD_TYPE" , discriminatorType = DiscriminatorType.STRING )

public class Task extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name="SPRINT_ID")
	private Sprint sprint;
	
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
	@Column(name="TASK_TYPE")
	private TaskType taskType;
	
	@Temporal(TemporalType.DATE)
	@Column(name="TIME_PREDICTION")
	private Calendar timePrediction;//پیش بینی زمان
	
	@OneToMany( cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH} ,fetch = FetchType.LAZY , mappedBy ="task")
	private List<TaskLog> taskLogs;
	
	@OneToOne( cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH} ,fetch = FetchType.EAGER )
	@JoinColumn(name="FINANCIAL_ID"   )
	private Financial financial;
	
	@OneToOne( cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH} ,fetch = FetchType.EAGER )
	@JoinColumn(name="REMINDER_ID"  )
	private Reminder reminder;
	
	@OneToMany( cascade = {CascadeType.DETACH,CascadeType.REFRESH} ,fetch = FetchType.LAZY , mappedBy ="dependency")
	private List<Task> dependencies;
	
	@ManyToOne( cascade = {CascadeType.DETACH,CascadeType.REFRESH} ,fetch = FetchType.EAGER )
	@JoinColumn(name="DEPENDENCY_ID"  )
	private Task dependency;

	
	public Sprint getSprint() { return sprint; }
	public void setSprint(Sprint sprint) { this.sprint = sprint; }
	
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	
	
	public String getCode() { return code; }
	public void setCode(String code) { this.code = code; }
	
	public PriorityType getPriorityType() { return priorityType; }
	public void setPriorityType(PriorityType priorityType) { this.priorityType = priorityType; }
	
	public TaskType getTaskType() { return taskType; }
	public void setTaskType(TaskType taskType) { this.taskType = taskType; }
	
	
	public Calendar getTimePrediction() { return timePrediction; }
	public void setTimePrediction(Calendar timePrediction) { this.timePrediction = timePrediction; }
	
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
	
}
