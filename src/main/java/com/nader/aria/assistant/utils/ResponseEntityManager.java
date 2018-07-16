package com.nader.aria.assistant.utils;

import com.nader.aria.assistant.entities.enums.ICreateResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public enum ResponseEntityManager implements ICreateResponseEntity {

    BAD_REQUEST(){

        @Override
        public ResponseEntity<?> getResponseEntity(){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        @Override
        public ResponseEntity<?> getResponseEntity(Object o){
            return new ResponseEntity<>(o, HttpStatus.BAD_REQUEST);
        }

    },

    INTERNAL_SERVER_ERROR(){

        @Override
        public ResponseEntity<?> getResponseEntity(){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        @Override
        public ResponseEntity<?> getResponseEntity(Object o){
            return new ResponseEntity<>(o, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    },

    NOT_FOUND(){

        @Override
        public ResponseEntity<?> getResponseEntity(){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        @Override
        public ResponseEntity<?> getResponseEntity(Object o){
            return new ResponseEntity<>(o, HttpStatus.NOT_FOUND);
        }

    },

    OK(){

        @Override
        public ResponseEntity<?> getResponseEntity(){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }

        @Override
        public ResponseEntity<?> getResponseEntity(Object o){
            return new ResponseEntity<>(o, HttpStatus.OK);
        }

    },

    CREATED(){

        @Override
        public ResponseEntity<?> getResponseEntity(){
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        }

        @Override
        public ResponseEntity<?> getResponseEntity(Object o){
            return new ResponseEntity<>(o, HttpStatus.CREATED);
        }

    },

    ACCEPTED(){

        @Override
        public ResponseEntity<?> getResponseEntity(){
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        }

        @Override
        public ResponseEntity<?> getResponseEntity(Object o){
            return new ResponseEntity<>(o, HttpStatus.ACCEPTED);
        }

    },

    NOT_ACCEPTABLE(){

        @Override
        public ResponseEntity<?> getResponseEntity(){
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }

        @Override
        public ResponseEntity<?> getResponseEntity(Object o){ return new ResponseEntity<>(o, HttpStatus.NOT_ACCEPTABLE); }

    },

    UNAUTHORIZED(){

        @Override
        public ResponseEntity<?> getResponseEntity(){ return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED); }

        @Override
        public ResponseEntity<?> getResponseEntity(Object o){ return new ResponseEntity<>(o, HttpStatus.UNAUTHORIZED); }


    }

}
