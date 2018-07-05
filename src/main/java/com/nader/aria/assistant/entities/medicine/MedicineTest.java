package com.nader.aria.assistant.entities.medicine;


import javax.persistence.*;
import com.nader.aria.assistant.entities.life.Task;
import com.nader.aria.assistant.entities.enums.MedicineTestType;

@Entity
@Table(name="MEDICINE_TESTS")
@DiscriminatorValue("MEDICINE_TEST")

public class MedicineTest extends Task {

	private static final long serialVersionUID = 1L;
	
	@Column(name="VALUE" )
	private String value;
	
	@Column(name="RELATED_DISEASES"  )
	private boolean relatedDiseases;
	
	@Enumerated(EnumType.STRING)
	@Column(name="MEDICINE_TEST_TYPE")
	private MedicineTestType medicineTestType;

	public String getValue() { return value; }
	public void setValue(String value) { this.value = value; }

	public boolean isRelatedDiseases() { return relatedDiseases; }
	public void setRelatedDiseases(boolean relatedDiseases) { this.relatedDiseases = relatedDiseases; }

	public MedicineTestType getMedicineTestType() { return medicineTestType; }
	public void setMedicineTestType(MedicineTestType medicineTestType) { this.medicineTestType = medicineTestType; }

	
	
	

}
