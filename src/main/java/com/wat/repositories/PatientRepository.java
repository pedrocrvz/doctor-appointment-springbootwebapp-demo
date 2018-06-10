package com.wat.repositories;

import com.wat.domain.Patient;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by pedrocruz on 24/05/2018.
 */
public interface PatientRepository extends CrudRepository<Patient, Integer> {
}