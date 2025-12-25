package com.management.hospital.schedulars;


import com.management.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PatientCountSchedular {

    @Autowired
    private PatientRepository patientRepository;

    //method
    //@Scheduled(fixedDelay = 1000)
    //cron - every 10 sec
//    @Scheduled(cron = "*/10 * * * * *")
//    public void getCount(){
//        System.err.println("Number of patient in hospital is : 20 ");
//    }



    @Scheduled(fixedDelay = 300000)
    public void getCount(){
        //fetch count from database
        int count = patientRepository.getPatientCount();

        System.err.println("Number of patient in hospital is : " + + count);
    }






}
