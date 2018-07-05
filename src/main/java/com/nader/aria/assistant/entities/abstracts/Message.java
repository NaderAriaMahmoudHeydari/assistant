package com.nader.aria.assistant.entities.abstracts;


import javax.persistence.*;
import java.util.Calendar;
import com.nader.aria.assistant.entities.reminder.Reminder;


@Entity
@Table(name = "MESSAGES" )
@Inheritance(strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn(name="MESSAGE_TYPE")
public abstract class Message extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name="REMINDER_ID")
	private Reminder reminder;
	
	@Column(name="TITLE"  )
	private String title;
	
	@Column(name="MASSAGE")
	private String message;
	
	@Temporal(TemporalType.DATE)
	@Column(name="EXPIRATION_DATE")
	private Calendar expirationDate;

	public Message(){}

	public Message(Long id,Long version,Reminder reminder,String title,String message,Calendar expirationDate){

		super(id,version);
		this.reminder = reminder;
		this.title = title;
		this.message = message;
		this.expirationDate = expirationDate;

	}
	
	
	public Reminder getReminder() { return reminder; }
	public void setReminder(Reminder reminder ) { this.reminder = reminder; }
	
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	
	public String getMessage() { return message; }
	public void setMessage(String message) { this.message = message; }
	
	
	public Calendar getExpirationDate() { return expirationDate; }
	public void setExpirationDate(Calendar expirationDate) { this.expirationDate = expirationDate; }
	
	

}
