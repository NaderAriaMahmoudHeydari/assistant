package com.nader.aria.assistant.entities.reminder;


import javax.persistence.*;
import java.util.List;
import com.nader.aria.assistant.entities.abstracts.BaseEntity;
import com.nader.aria.assistant.entities.account.Login;

@Entity
@Table(name="REMINDER_MANAGERS")
public class ReminderManager extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@OneToOne( cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} ,fetch = FetchType.EAGER )
	@JoinColumn(name ="LOGIN_ID" )
	private Login login;
	
	@OneToMany( cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH} ,fetch = FetchType.LAZY , mappedBy = "reminderManager" )
	private List<Reminder> reminders;
	
	public Login getLogin() { return login; }
	public void setLogin(Login login) { this.login = login; }
	
	public List<Reminder> getReminders(){ return reminders; }
	public void setReminders(List<Reminder> reminders) { this.reminders = reminders; }
	
	
}
