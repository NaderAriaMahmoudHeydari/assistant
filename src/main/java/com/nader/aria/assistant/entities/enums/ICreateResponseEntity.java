package com.nader.aria.assistant.entities.enums;

import org.springframework.http.ResponseEntity;
import java.io.Serializable;

public interface ICreateResponseEntity  {

    public ResponseEntity<?> getResponseEntity();

    public ResponseEntity<?> getResponseEntity(Object o);
}
