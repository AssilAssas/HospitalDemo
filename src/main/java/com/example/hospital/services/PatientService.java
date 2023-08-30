package com.example.hospital.services;

import com.example.hospital.entities.Patient;
import com.example.hospital.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientService {

    PatientRepository patientRepository;

    public Patient addPatient( Patient patient){
       return  patientRepository.save(patient);
    }

    public void DeletePatient( long  idPatient){
          patientRepository.deleteById(idPatient);
    }

}
