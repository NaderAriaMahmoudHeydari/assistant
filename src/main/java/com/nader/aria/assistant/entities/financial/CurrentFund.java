package com.nader.aria.assistant.entities.financial;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.nader.aria.assistant.entities.abstracts.Fund;

@Entity
@Table(name="CURRENT_FUNDS")
@DiscriminatorValue("CURRENT")
public class CurrentFund extends Fund {
	
	private static final long serialVersionUID = 1L;
	
}
