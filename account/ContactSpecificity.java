package com.nader.aria.assistant_blue.entities.account;

import javax.persistence.*;
import com.nader.aria.assistant_blue.entities.abstracts.BaseEntity;
import com.nader.aria.assistant_blue.entities.phone_book.Phone;

import java.util.List;

@Entity
@Table(name="CONTACT_SPECIFICITY_S")
public class ContactSpecificity extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name="SITE"  )
	private String site;
	
	@Column(name="EMAIL" )
	private String email;

	@OneToMany(cascade = {CascadeType.REFRESH,CascadeType.MERGE},fetch = FetchType.EAGER,mappedBy = "contactSpecificity")
	private List<Phone> phones;
	
	public String getSite() { return site; }
	public void setSite(String site) { this.site = site; }
	
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	
	public List<Phone> getPhones(){ return phones; }
	public void setPhones(List<Phone> phones){ this.phones = phones; }
	

}
