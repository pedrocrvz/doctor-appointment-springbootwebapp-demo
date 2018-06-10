package com.wat.repositories;

import com.wat.domain.Appointment;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by pedrocruz on 23/05/2018.
 */
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
}
