package com.nader.aria.assistant.entities.reminder;


import javax.persistence.*;
import java.util.Calendar;
import java.util.List;
import com.nader.aria.assistant.entities.abstracts.BaseEntity;
import com.nader.aria.assistant.entities.abstracts.Message;
import com.nader.aria.assistant.entities.enums.ReminderState;
import com.nader.aria.assistant.entities.enums.RepetitionType;


@Entity
@Table(name="REMINDERS")
public class Reminder extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name = "REMINDER_MANAGER_ID" )
	private ReminderManager reminderManager;
	
	@OneToMany( cascade = {CascadeType.ALL} ,fetch = FetchType.LAZY , mappedBy = "reminder" )
	private List<Message> messages;
	
	@Enumerated(EnumType.STRING)
	@Column(name="REPETITION_TYPE")
	private RepetitionType repetitionType;
	
	@Column(name="REPETITION")
	private boolean repetition;
	
	@Enumerated(EnumType.STRING)
	@Column(name="REMINDER_STATE")
	private ReminderState reminderState;
	
	@Temporal(TemporalType.DATE)
	@Column(name="CREATE_DATE")
	private Calendar createDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="TIME_ACTIVATED")
	private Calendar timeActivated;
	
	@Column(name="ACTIVE")
	private boolean active;
	
	public ReminderManager getReminderManager() { return reminderManager; }
	public void setReminderManager(ReminderManager reminderManager) { this.reminderManager = reminderManager; }
	
	public List<Message> getMessages(){ return messages; }
	public void setMessages(List<Message> messages) { this.messages = messages; }
	
	public RepetitionType getRepetitionType() { return repetitionType; }
	public void setRepetitionType(RepetitionType repetitionType) { this.repetitionType = repetitionType; }
	
	public boolean isRepetition() { return repetition; }
	public void setRepetition(boolean repetition) { this.repetition = repetition; }
	
	public ReminderState getReminderState() { return reminderState; }
	public void setReminderState(ReminderState reminderState) { this.reminderState = reminderState; }
	
	public Calendar getCreateDate() { return createDate; }
	public void setCreateDate(Calendar createDate) { this.createDate = createDate;}
	
	public Calendar getTimeActivated() { return timeActivated; }
	public void setTimeActivated(Calendar timeActivated) { this.timeActivated = timeActivated;}
	
	public boolean isActive() { return active; }
	public void setActive(boolean active) { this.active = active; }
	
}
