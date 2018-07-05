package com.nader.aria.assistant.entities.medicine;

import java.util.Calendar;
import java.util.List;
import javax.persistence.*;
import com.nader.aria.assistant.entities.life.Task;

@Entity
@Table(name="TAKING_MEDICATIONS")
@DiscriminatorValue("TAKING_MEDICATION")
public class TakingMedication extends Task {

	private static final long serialVersionUID = 1L;
	
	@OneToMany( cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY , mappedBy ="takingMedication")
	private List<DrugInfo> drugInfos;
	
	@Temporal(TemporalType.DATE)
	@Column(name="USE_TIME")
	private Calendar useTime;//زمان مصرف
	
	@Column(name="CONSUMED")
	private boolean consumed;//مصرف شده
		

	
	public List<DrugInfo> getDrugInfo() { return drugInfos; }
	public void setDrugInfo(List<DrugInfo> drugInfos) { this.drugInfos = drugInfos; }
	
	public Calendar getUseTime() { return useTime; }
	public void setUseTime(Calendar useTime) { this.useTime = useTime; }
	
	public boolean isConsumed() { return consumed; }
	public void setConsumed(boolean consumed) { this.consumed = consumed; }
	
}
