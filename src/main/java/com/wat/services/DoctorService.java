package com.wat.services;

import com.wat.domain.Clinic;
import com.wat.domain.Doctor;

/**
 * Created by pedrocruz on 21/05/2018.
 */
public interface DoctorService {
    Iterable<Doctor> listAllDoctors();

    Doctor getDoctorById(Integer id);

    Doctor saveDoctor(Doctor doctor);

    void deleteDoctor(Integer id);
}
