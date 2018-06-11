package com.wat.services;

import com.wat.domain.Speciality;
import com.wat.repositories.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pedrocruz on 23/05/2018.
 */
@Service
public class SpecialityServiceImpl implements SpecialityService {

    private SpecialityRepository specialityRepository;

    @Autowired
    public void setSpecialityRepository(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Iterable<Speciality> listAllSpecialities() {
        return specialityRepository.findAll();
    }

    @Override
    public Speciality getSpecialityById(Integer id) {
        return specialityRepository.findById(id).orElse(null);
    }

    @Override
    public Speciality saveSpeciality(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public void deleteSpeciality(Integer id) {
        specialityRepository.deleteById(id);
    }
}
