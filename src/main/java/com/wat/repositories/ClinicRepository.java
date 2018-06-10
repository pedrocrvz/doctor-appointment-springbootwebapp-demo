package com.wat.repositories;

import com.wat.domain.Clinic;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by pedrocruz on 23/05/2018.
 */
public interface ClinicRepository extends CrudRepository<Clinic, Integer> {
}