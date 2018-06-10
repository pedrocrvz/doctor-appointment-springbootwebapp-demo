package com.wat.services;

import com.wat.domain.Speciality;

/**
 * Created by pedrocruz on 23/05/2018.
 */
public interface SpecialityService {
    Iterable<Speciality> listAllSpecialities();

    Speciality getSpecialityById(Integer id);

    Speciality saveSpeciality(Speciality speciality);
}
