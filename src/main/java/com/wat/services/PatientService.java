package com.wat.services;

import com.wat.domain.Patient;

/**
 * Created by pedrocruz on 24/05/2018.
 */
public interface PatientService {
    Iterable<Patient> listAllPatients();

    Patient getPatientById(Integer id);
}
