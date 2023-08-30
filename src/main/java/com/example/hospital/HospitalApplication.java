package com.example.hospital;

import com.example.hospital.entities.Patient;
import com.example.hospital.repository.PatientRepository;
import net.bytebuddy.utility.nullability.MaybeNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class HospitalApplication implements CommandLineRunner {
    @Autowired
    public PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {



     /*  Patient patient = new Patient();
        patient.setId(1L);
        patient.setNom("Assil");
        patient.setDateNaissance(new Date());
        patient.setMalade(false);
        patient.setScore(23);


      //  Patient patient2 = new Patient(null,"Yassine",new Date(),false,123);
        // En utilisant Builder
        Patient patient3 = Patient.builder()
                .nom("Assas")
                .dateNaissance(new Date())
                .score(56)
                .malade(true)
                .build();
        patientRepository.save(new Patient(13L,"Mahmoud", new Date(),false,89));

        patientRepository.save(patient);
        patientRepository.save(patient3);
        patientRepository.save(new Patient(3L,"Mohamed",new Date(),true,26));
        patientRepository.save(new Patient(4L,"Issam",new Date(),true,56));
        patientRepository.save(new Patient(5L,"Mohamed",new Date(),true,69));
        patientRepository.save(new Patient(6L,"Ali",new Date(),false,76));
        patientRepository.save(new Patient(7L,"Imen",new Date(),true,10));
        patientRepository.save(new Patient(8L,"Rahma",new Date(),false,43));
        patientRepository.save(new Patient(9L,"Mouhib",new Date(),true,96));
        patientRepository.save(new Patient(10L,"Zied",new Date(),true,10));
        patientRepository.save(new Patient(11L,"Aziz",new Date(),false,43));
        patientRepository.save(new Patient(12L,"Ahmed",new Date(),true,96));


*/
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
