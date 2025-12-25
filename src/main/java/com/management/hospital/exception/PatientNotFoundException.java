package com.management.hospital.exception;

//user defined exception
public class PatientNotFoundException extends RuntimeException{


    //constructor
    public PatientNotFoundException(String msg){
        super(msg);

    }
}
