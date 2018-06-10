package com.wat.services;

import com.wat.domain.Clinic;
import com.wat.repositories.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by pedrocruz on 23/05/2018.
 */
@Service
public class ClinicServiceImpl implements ClinicService {

    private ClinicRepository clinicRepository;

    @Autowired
    public void setClinicRepository(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    @Override
    public Iterable<Clinic> listAllClinics() {
        return clinicRepository.findAll();
    }

    @Override
    public Clinic getClinicById(Integer id) {
        return clinicRepository.findById(id).orElse(null);
    }

    @Override
    public Clinic saveClinic(Clinic clinic) {
        return clinicRepository.save(clinic);
    }
}



