package com.nader.aria.assistant.entities.account;

import javax.persistence.*;
import javax.validation.constraints.Size;
import com.nader.aria.assistant.entities.abstracts.BaseEntity;

@Entity
@Table(name="ADDRESSES")
public class Address extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name="COUNTRY"  )
	@Size(max = 50)
	private String country;
	
	@Column(name="CITY"  )
	@Size(max = 50)
	private String city;
	
	@Column(name="LINE"  )
	@Size(max = 50)
	private String line;
	
	@Column(name="ALLEY"  )
	@Size(max = 50)
	private String alley;
	
	@Column(name="FULL_ADDRESS" )
	@Size(max = 150)
	private String fullAddress;
	
	@Column(name="NO")
	@Size(max = 5)
	private String no;

	public Address(){}

	public Address(Long id,Long version,String country,String city,String line,String alley,String fullAddress,String no){

		super(id,version);
		this.country = country;
		this.city = city;
		this.line = line;
		this.alley = alley;
		this.fullAddress = fullAddress;
		this.no = no;

	}

	public  String getCountry() { return country; }
	public void setCountry(String country) { this.country = country; }
	
	public String getCity() { return city; }
	public void setCity(String city) { this.city = city; }
	
	public String getLine() { return line; }
	public void setLine(String line) { this.line = line; }
	
	public String getAlley() { return alley; }
	public void setAlley(String alley) { this.alley = alley; }
	
	public String getFullAddress() { return fullAddress; }
	public void setFullAddress( String fullAddress) { this.fullAddress = fullAddress; }
	
	public String getNo() { return no; }
	public void setNo(String no) { this.no = no; }
}
