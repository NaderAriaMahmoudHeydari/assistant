package com.nader.aria.assistant_blue.entities.medicine;

import javax.persistence.*;

import com.nader.aria.assistant_blue.entities.abstracts.Medicine;


@Entity
@Table(name="MEDICINE_VISITS")
@DiscriminatorValue("MEDICINE_VISIT")
public class MedicineVisit extends Medicine {

	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name="MEDICINE_VISIT_MANAGER_ID" )
	private MedicineVisitManager medicineVisitManager;
	
	@OneToOne( cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH} ,fetch = FetchType.EAGER )
	@JoinColumn(name = "MEDICINE_INFO_ID" )
	private MedicineInfo medicineInfo;

	public MedicineVisitManager getMedicineVisitManager(){ return medicineVisitManager; }
	public void setMedicineVisitManager(MedicineVisitManager medicineVisitManager){ this.medicineVisitManager = medicineVisitManager; }
	
	public MedicineInfo getMedicineInfo() { return medicineInfo; }
	public void setMedicineInfo(MedicineInfo medicineInfo) { this.medicineInfo = medicineInfo; }

}
