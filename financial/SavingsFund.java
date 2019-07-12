package com.nader.aria.assistant_blue.entities.financial;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.nader.aria.assistant_blue.entities.abstracts.Fund;


@Entity
@DiscriminatorValue("SAVINGS")
public class SavingsFund extends Fund {

	private static final long serialVersionUID = 1L;

}
