package com.nader.aria.assistant.entities.financial;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.nader.aria.assistant.entities.abstracts.Fund;


@Entity
@Table(name="SAVINGS_FUNDS")
@DiscriminatorValue("SAVINGS")
public class SavingsFund extends Fund {

	private static final long serialVersionUID = 1L;

}
