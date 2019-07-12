package com.nader.aria.assistant_blue.entities.medicine;

import java.util.List;
import javax.persistence.*;
import com.nader.aria.assistant_blue.entities.abstracts.BaseEntity;
import com.nader.aria.assistant_blue.entities.account.Address;
import com.nader.aria.assistant_blue.entities.account.ContactSpecificity;
import com.nader.aria.assistant_blue.entities.enums.MedicineType;


@Entity
@Table(name="MEDICINE_INFOS" , uniqueConstraints = @UniqueConstraint( columnNames= {"ADDRESS_ID","TITLE","MEDICINE_TYPE"}) )
public class MedicineInfo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name="MEDICINE_INFO_MANAGER_ID" )
	private MedicineInfoManager medicineInfoManager;

	@Column(name="TITLE")
	private String title;
	
	@Column(name="DESCRIPTION"  )
	private String description;
	
	@OneToOne( cascade = {CascadeType.ALL},fetch = FetchType.EAGER )
	@JoinColumn(name="ADDRESS_ID"  )
	private Address address;
	
	@OneToOne( cascade = {CascadeType.ALL} ,fetch = FetchType.EAGER )
	@JoinColumn(name="CONTACT_SPECIFICITY_ID"  )
	private ContactSpecificity contactSpecificity;
	
	@Enumerated(EnumType.STRING)
	@Column(name="MEDICINE_TYPE")
	private MedicineType medicineType;
	
	@OneToMany( cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} ,fetch = FetchType.LAZY , mappedBy = "medicineInfo" )
	private List<DrugInfo> drugInfoes;

	public MedicineInfoManager getMedicineInfoManager(){ return medicineInfoManager; }
	public void setMedicineInfoManager(MedicineInfoManager medicineInfoManager){ this.medicineInfoManager =medicineInfoManager; }

	public String getTitle() { return title;}
	public void setTitle(String title) { this.title = title; }
	
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	
	public Address getAddress() { return address; }
	public void setAddress(Address address) { this.address = address; }
	
	public ContactSpecificity getContactSpecificity() { return contactSpecificity; }
	public void setContactSpecificity(ContactSpecificity contactSpecificity) { this.contactSpecificity = contactSpecificity; }
	
	public MedicineType getMedicineType() { return medicineType; }
	public void setMedicineType(MedicineType medicineType) { this.medicineType = medicineType; }
	
	public List<DrugInfo> getDrugInfoes() { return drugInfoes; }
	public void setDrugInfoes(List<DrugInfo> drugInfoes) { this.drugInfoes = drugInfoes; }
	

}
