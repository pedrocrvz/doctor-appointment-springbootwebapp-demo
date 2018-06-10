package com.wat.repositories;

import com.wat.domain.Doctor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by pedrocruz on 21/05/2018.
 */
public interface DoctorRepository extends CrudRepository<Doctor, Integer>{
}