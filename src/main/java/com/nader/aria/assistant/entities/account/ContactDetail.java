package com.nader.aria.assistant.entities.account;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.nader.aria.assistant.entities.abstracts.BaseEntity;

@Entity
@Table(name="CONTACT_DETAILS", uniqueConstraints= {@UniqueConstraint( columnNames = {"email"} ),	@UniqueConstraint( columnNames = {"cell"} )	})
public class ContactDetail extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name="SITE"  )
	@Pattern(regexp = "^(http://|https://)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$")
	private String site;
	
	@Column(name="EMAIL" )
	@Email(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$" )
	private String email;
	
	@Column(name="PHONE"  )
	@Size(max = 15)
	private String phone;
	
	@Column(name="CELL")
	@Size(max = 15)
	private String cell;

	public ContactDetail(){}

	public ContactDetail(Long id, Long version, String site, String email, String phone, String cell){

		super(id,version);
		this.site = site;
		this.email = email;
		this.phone = phone;
		this.cell = cell;

	}

	public String getSite() { return site; }
	public void setSite(String site) { this.site = site; }
	
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	
	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }
	
	public String getCell() { return cell; }
	public void setCell( String cell) { this.cell = cell; }
	
	

}
