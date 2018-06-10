package com.wat.services;

import com.wat.domain.Patient;
import com.wat.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pedrocruz on 24/05/2018.
 */
@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    @Autowired
    public void setPatientRepository(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Iterable<Patient> listAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Integer id) {
        return patientRepository.findById(id).orElse(null);
    }
}