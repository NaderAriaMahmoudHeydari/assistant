package com.nader.aria.assistant.entities.medicine;

import javax.persistence.*;
import com.nader.aria.assistant.entities.life.Task;

@Entity
@Table(name="MEDICINE_VISITS")
@DiscriminatorValue("MEDICINE_VISIT")
public class MedicineVisit extends Task {

	private static final long serialVersionUID = 1L;
	
	@OneToOne( cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH} ,fetch = FetchType.EAGER )
	@JoinColumn(name = "MEDICINE_INFO_ID" )
	private MedicineInfo medicineInfo;
	
	public MedicineInfo getMedicineInfo() { return medicineInfo; }
	public void setMedicineInfo(MedicineInfo medicineInfo) { this.medicineInfo = medicineInfo; }

}
