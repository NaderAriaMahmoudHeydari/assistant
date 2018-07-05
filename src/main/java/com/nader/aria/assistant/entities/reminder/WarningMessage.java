package com.nader.aria.assistant.entities.reminder;

import com.nader.aria.assistant.entities.abstracts.Message;
import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;


@Entity
@DiscriminatorValue("WARNING_MESSAGE")
public class WarningMessage extends Message {

	private static final long serialVersionUID = 1L;

}
