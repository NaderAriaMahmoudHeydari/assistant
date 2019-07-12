package com.nader.aria.assistant_blue.entities.reminder;

import com.nader.aria.assistant_blue.entities.abstracts.Message;
import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("ERROR_MESSAGE")
public class ErrorMessage extends Message {

	private static final long serialVersionUID = 1L;

}
