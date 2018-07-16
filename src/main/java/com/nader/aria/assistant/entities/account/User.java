package com.nader.aria.assistant.entities.account;

import java.util.Calendar;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.nader.aria.assistant.entities.abstracts.BaseEntity;
import com.nader.aria.assistant.entities.enums.Gender;

@Entity
@Table(name="USERS")
public class User extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name="FIRST_NAME")
	@NotNull
	@Size(min = 3)
	private String firstName;
	
	@Column(name="LAST_NAME"  )
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	@Column(name="GENDER")
	private Gender gender;
	
	@Temporal(TemporalType.DATE)
	@Column(name="BIRTH_DAY"  )
	private Calendar birthDay;
	
	@OneToOne(cascade = {CascadeType.ALL} ,fetch = FetchType.EAGER)
	@JoinColumn(name="ADDRESS_ID"  )
	@Valid
	private Address address;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="CONTACT_DETAIL_ID"  )
	@Valid
	private ContactDetail contactDetail;
	
	@Lob
	@Column(name="IMAGE"  )
	private byte[] image;

	public User(){}

	public User(Long id, Long version, String firstName, String lastName, Gender gender, Calendar birthDay, Address address, ContactDetail contactDetail, byte[] image){

		super(id,version);
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthDay = birthDay;
		this.address = address;
		this.contactDetail = contactDetail;
		this.image = image;

	}
	
	public String getFirstName() { return firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
	
	public String getLastName() { return lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	
	public Gender getGender() { return gender; }
	public void setGender(Gender gender) { this.gender = gender; }
	
	public Calendar getBirthDay() { return birthDay; }
	public void setBirthDay(Calendar birthDay) { this.birthDay = birthDay; }
	
	public Address getAddress() { return address; }
	public void setAddress(Address address) { this.address = address; }
	
	public ContactDetail getContactDetail() { return contactDetail; }
	public void setContactDetail(ContactDetail contactDetail) { this.contactDetail = contactDetail; }
	
	public byte[] getImage() { return image; }
	public void setImage(byte[] image) { this.image = image; }
	
	
			
			
			

}
