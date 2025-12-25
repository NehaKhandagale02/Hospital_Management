package com.management.hospital.serviceImpl;

import com.management.hospital.entity.Patient;
import com.management.hospital.exception.PatientNotFoundException;
import com.management.hospital.repository.PatientRepository;
import com.management.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {


    //constructor
    public PatientServiceImpl(){
        System.err.println("In patient service Impl");
    }

   @Autowired
  private  PatientRepository patientRepository;

    @Override
    public Patient savePatient(Patient patient) {
        Patient newPatient = patientRepository.save(patient);
        System.err.println("Patient saved successfully");
        return newPatient;
    }

    @Override
    public List<Patient> getAllPatientList() {
       List<Patient> patientList = patientRepository.findAll();
        return patientList;
    }

    @Override
    public Patient getPatientById(int id) {
          Patient patient = patientRepository.findById(id).orElseThrow(
                  () -> new PatientNotFoundException("Patient is not available with id : " +id));

        return patient;
    }

    @Override
    public String deletePatientById(int id) {
        patientRepository.deleteById(id);
        String msg = "Patient delete with id : " + id;
        return msg;
    }

    @Override
    public Patient updatePatient(int id, Patient patient) {
        //get obj from database which need to be updated(get by id)
      Patient patientFromDb =   patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        //update patientFromDb with new value
        patientFromDb.setPatientName(patient.getPatientName());
        patientFromDb.setAddress(patient.getAddress());
        patientFromDb.setAge(patient.getAge());
        patientFromDb.setMobileNumber(patient.getMobileNumber());
        //save object to db
       Patient updatedPatient =  patientRepository.save(patientFromDb);

        return updatedPatient;
    }
}
