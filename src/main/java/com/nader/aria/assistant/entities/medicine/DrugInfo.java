package com.nader.aria.assistant.entities.medicine;


import javax.persistence.*;
import com.nader.aria.assistant.entities.abstracts.BaseEntity;

@Entity
@Table(name="DRUG_INFOS" , uniqueConstraints = @UniqueConstraint( columnNames= {"TITLE"}) )
public class DrugInfo extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name="DRUG_INFO_MANAGER_ID" )
	private DrugInfoManager drugInfoManager;
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name="MEDICINE_INFO_ID"  )
	private MedicineInfo medicineInfo;
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name="TAKING_MEDICATION_ID"  )
	private TakingMedication takingMedication;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="DESCRIPTION"  )
	private String description;
	
	@Column(name="COMPLICATIONS"  )
	private String complications;//عوارض جانبی

	
	public DrugInfoManager getDrugInfoManager() { return drugInfoManager; }
	public void setDrugInfoManager(DrugInfoManager drugInfoManager) { this.drugInfoManager = drugInfoManager; }

	public MedicineInfo getMedicineInfo() {	return medicineInfo; }
	public void setMedicineInfo(MedicineInfo medicineInfo) { this.medicineInfo = medicineInfo; }

	public TakingMedication getTakingMedication() { return takingMedication; }
	public void setTakingMedication(TakingMedication takingMedication) { this.takingMedication = takingMedication; }

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }

	public String getComplications() { return complications; }
	public void setComplications(String complications) { this.complications = complications; }
	
	

	
	
	
}
