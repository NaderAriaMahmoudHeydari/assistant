package com.nader.aria.assistant_blue.entities.abstracts;


import javax.persistence.*;
import java.time.LocalDateTime;


import com.nader.aria.assistant_blue.entities.reminder.Reminder;


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
	
	@Column(name="EXPIRATION_DATE")
	private LocalDateTime expirationDateTime;

	public Reminder getReminder() { return reminder; }
	public void setReminder(Reminder reminder ) { this.reminder = reminder; }
	
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	
	public String getMessage() { return message; }
	public void setMessage(String message) { this.message = message; }
	
	public LocalDateTime getExpirationDateTime(){ return expirationDateTime; }
	public void setExpirationDateTime(LocalDateTime expirationDateTime){ this.expirationDateTime = expirationDateTime; }


}
