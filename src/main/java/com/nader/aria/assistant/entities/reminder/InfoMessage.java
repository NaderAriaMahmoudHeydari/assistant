package com.nader.aria.assistant.entities.reminder;

import com.nader.aria.assistant.entities.abstracts.Message;
import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;



@Entity
@DiscriminatorValue("INFO_MESSAGE")
public class InfoMessage extends Message {

	private static final long serialVersionUID = 1L;

}
