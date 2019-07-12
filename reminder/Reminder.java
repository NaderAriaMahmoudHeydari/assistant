package com.nader.aria.assistant_blue.entities.reminder;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import com.nader.aria.assistant_blue.entities.abstracts.BaseEntity;
import com.nader.aria.assistant_blue.entities.abstracts.Message;
import com.nader.aria.assistant_blue.entities.enums.ReminderState;
import com.nader.aria.assistant_blue.entities.enums.RepetitionType;


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
	
	@Column(name="CREATE_DATE")
	private LocalDate createDate;
	
	@Column(name="TIME_ACTIVATED")
	private LocalDateTime timeActivated;
	
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
	
	public LocalDate getCreateDate() { return createDate; }
	public void setCreateDate(LocalDate createDate) { this.createDate = createDate;}
	
	public LocalDateTime getTimeActivated() { return timeActivated; }
	public void setTimeActivated(LocalDateTime timeActivated) { this.timeActivated = timeActivated;}
	
	public boolean isActive() { return active; }
	public void setActive(boolean active) { this.active = active; }
	
}
