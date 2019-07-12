package com.nader.aria.assistant_blue.entities.medicine;

import java.time.LocalTime;
import java.util.List;
import javax.persistence.*;

import com.nader.aria.assistant_blue.entities.abstracts.Medicine;


@Entity
@Table(name="TAKING_MEDICATIONS")
@DiscriminatorValue("TAKING_MEDICATION")
public class TakingMedication extends Medicine {

	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} , fetch = FetchType.EAGER)
	@JoinColumn(name = "TAKING_MEDICATION_MANAGER_ID")
	private TakingMedicationManager takingMedicationManager;

	@OneToMany( cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.LAZY , mappedBy ="takingMedication")
	private List<DrugInfo> drugInfos;
	
	@Column(name="USE_TIME")
	private LocalTime useTime;//زمان مصرف
	
	@Column(name="CONSUMED")
	private boolean consumed;//مصرف شده
		

	public TakingMedicationManager getTakingMedicationManager(){ return takingMedicationManager; }
	public void setTakingMedicationManager(TakingMedicationManager takingMedicationManager){ this.takingMedicationManager = takingMedicationManager; }

	public List<DrugInfo> getDrugInfo() { return drugInfos; }
	public void setDrugInfo(List<DrugInfo> drugInfos) { this.drugInfos = drugInfos; }
	
	public LocalTime getUseTime() { return useTime; }
	public void setUseTime(LocalTime useTime) { this.useTime = useTime; }
	
	public boolean isConsumed() { return consumed; }
	public void setConsumed(boolean consumed) { this.consumed = consumed; }
	
}
