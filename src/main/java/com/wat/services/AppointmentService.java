package com.wat.services;


import com.wat.domain.Appointment;

/**
 * Created by pedrocruz on 23/05/2018.
 */
public interface AppointmentService {

    Iterable<Appointment> listAllAppointments();

    Appointment getAppointmentById(Integer id);

    Appointment saveAppointment(Appointment appointment);

}
