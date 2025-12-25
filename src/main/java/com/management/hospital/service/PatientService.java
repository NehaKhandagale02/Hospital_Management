package com.management.hospital.service;

import com.management.hospital.entity.Patient;

import java.util.List;

public interface PatientService {

    Patient savePatient(Patient patient);

    List<Patient> getAllPatientList();

    Patient getPatientById(int id);

    String deletePatientById(int id);

    Patient updatePatient(int id, Patient patient);

}
