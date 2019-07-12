package com.nader.aria.assistant_blue.entities.account;

import javax.persistence.*;
import com.nader.aria.assistant_blue.entities.abstracts.User;

@Entity
@Table(name="MEMBERS")
@DiscriminatorValue("MEMBER_TYPE")
public class Member extends User {

	private static final long serialVersionUID = 1L;

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="CONTACT_SPECIFICITY_ID"  )
	private ContactSpecificity contactSpecificity;
	
	@Lob
	@Column(name="IMAGE"  )
	private byte[] image;

	public ContactSpecificity getContactSpecificity() { return contactSpecificity; }
	public void setContactSpecificity(ContactSpecificity contactSpecificity) { this.contactSpecificity = contactSpecificity; }
	
	public byte[] getImage() { return image; }
	public void setImage(byte[] image) { this.image = image; }

}
