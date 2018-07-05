package com.nader.aria.assistant.entities.life;

import java.util.Calendar;
import javax.persistence.*;
import com.nader.aria.assistant.entities.abstracts.BaseEntity;
import com.nader.aria.assistant.entities.enums.StateType;


@Entity
@Table(name="TASK_LOGS")

public class TaskLog extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name="TASK_ID")
	private Task task;
	
	@Column(name="COMMENT"  )
	private String comment;
	
	@Enumerated( EnumType.STRING )
	@Column(name="STATE_TYPE")
	private StateType stateType;
	
	@Temporal(TemporalType.DATE)
	@Column(name="START_LOG")
	private Calendar startLog;

	@Temporal(TemporalType.DATE)
	@Column(name="END_LOG")
	private Calendar endLog;


	public Task getTask() { return task; }
	public void setTask(Task task) { this.task =  task; }
	
	public String getComment() { return comment; }
	public void setComment(String comment) { this.comment = comment; }
	
	public StateType getStateType() { return stateType; }
	public void setStateType(StateType stateType) { this.stateType = stateType; }
	
	public Calendar getStartLog() { return startLog; }
	public void setStartLog(Calendar startLog) { this.startLog = startLog; }
	
	public Calendar getEndLog() { return endLog; }
	public void setEndLog(Calendar endLog) { this.endLog = endLog; }
}
