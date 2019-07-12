package com.nader.aria.assistant_blue.entities.financial;

import javax.persistence.*;
import com.nader.aria.assistant_blue.entities.enums.ReceiveType;

@Entity
@Table(name="RECEIVES")
@DiscriminatorValue("RECEIVE")
public class Receive extends Financial {

	private static final long serialVersionUID = 1L;
	
	@Column(name="RECEIVED")
	private boolean received;
	
	@Enumerated(EnumType.STRING)
	@Column(name="RECEIVE_TYPE")
	private ReceiveType receiveType;
	
	@Column(name="PAYER")
	private String payer;
	
	
	public boolean isReceived() { return received; }
	public void setReceived(boolean received) { this.received = received; }
	
	public ReceiveType getReceiveType() { return receiveType; }
	public void setReceiveType(ReceiveType receiveType) { this.receiveType = receiveType;}
	
	public String getPayer() { return payer; }
	public void setPayer(String payer) { this.payer = payer; }

}
