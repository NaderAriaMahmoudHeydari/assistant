package com.nader.aria.assistant_blue.entities.medicine;


import javax.persistence.*;

import com.nader.aria.assistant_blue.entities.abstracts.Medicine;
import com.nader.aria.assistant_blue.entities.enums.MedicineTestType;

@Entity
@Table(name="MEDICINE_TESTS")
@DiscriminatorValue("MEDICINE_TEST")
public class MedicineTest extends Medicine {

	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name="MEDICINE_TEST_MANAGER_ID" )
	private MedicineTestManager medicineTestManager;

	@Column(name="VALUE" )
	private String value;
	
	@Column(name="RELATED_DISEASES"  )
	private boolean relatedDiseases;
	
	@Enumerated(EnumType.STRING)
	@Column(name="MEDICINE_TEST_TYPE")
	private MedicineTestType medicineTestType;

	public MedicineTestManager getMedicineTestManager(){ return medicineTestManager; }
	public void setMedicineTestManager(MedicineTestManager medicineTestManager){ this.medicineTestManager = medicineTestManager; }

	public String getValue() { return value; }
	public void setValue(String value) { this.value = value; }

	public boolean isRelatedDiseases() { return relatedDiseases; }
	public void setRelatedDiseases(boolean relatedDiseases) { this.relatedDiseases = relatedDiseases; }

	public MedicineTestType getMedicineTestType() { return medicineTestType; }
	public void setMedicineTestType(MedicineTestType medicineTestType) { this.medicineTestType = medicineTestType; }


}
