package com.wat.services;

import com.wat.domain.Clinic;

/**
 * Created by pedrocruz on 23/05/2018.
 */
public interface ClinicService {
    Iterable<Clinic> listAllClinics();

    Clinic getClinicById(Integer id);

    Clinic saveClinic(Clinic clinic);

    void deleteClinic(Integer id);
}
