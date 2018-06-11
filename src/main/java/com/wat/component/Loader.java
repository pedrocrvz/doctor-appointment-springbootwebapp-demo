package com.wat.component;

import com.wat.domain.*;
import com.wat.repositories.AppointmentRepository;
import com.wat.repositories.ClinicRepository;
import com.wat.repositories.DoctorRepository;
import com.wat.repositories.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Handler;

/**
 * Created by pedrocruz on 22/05/2018.
 */
@Component
public class Loader implements ApplicationListener<ContextRefreshedEvent> {

    private DoctorRepository doctorRepository;
    private SpecialityRepository specialityRepository;
    private ClinicRepository clinicRepository;


    private AppointmentRepository appointmentRepository;

    private Logger log = Logger.getLogger(Loader.class);

    @Autowired
    public void setDoctorRepository(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Autowired
    public void setSpecialityRepository(SpecialityRepository specialtyRepository) {
        this.specialityRepository = specialtyRepository;
    }

    @Autowired
    public void setClinicRepository(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    public void setAppointmentRepository(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        //Specialities
        Speciality oncology = new Speciality();
        oncology.setName("Oncology");
        oncology.setDescription("Prevention, diagnosis, and treatment of cancer.");
        specialityRepository.save(oncology);
        log.info("Added Speciality Oncology - id: " + oncology.getId());

        Speciality dermatology= new Speciality();
        dermatology.setName("Dermatology");
        dermatology.setDescription("Skin and its appendages (hair, nails, sweat glands etc.).");
        specialityRepository.save(dermatology);
        log.info("Added Speciality Dermatology - id: " + dermatology.getId());



        //Clinics
        Clinic bensClinic = new Clinic();
        bensClinic.setName("Ben's Clinic");
        bensClinic.setAddress("Krakow, Miodowa 6");
        bensClinic.setTelephone("213456789");
        bensClinic.setWebsite("www.bensclinic.com");
        bensClinic.setDescription("We take care of you!");
        bensClinic.setEmail("bensclinic@email.com");
        clinicRepository.save(bensClinic);
        log.info("Added Clinic Ben's Clinic - id: " + bensClinic.getId());

        Clinic hopeClinic = new Clinic();
        hopeClinic.setName("Hope Clinic");
        hopeClinic.setAddress("Krakow, Reymonta 4");
        hopeClinic.setTelephone("213444489");
        hopeClinic.setWebsite("www.hopeclinics.com");
        hopeClinic.setDescription("We are your hope");
        hopeClinic.setEmail("hopeclinic@email.com");
        clinicRepository.save(hopeClinic);
        log.info("Added Clinic Hope Clinic - id: " + hopeClinic.getId());



        //Doctors
        Doctor johnEdgar = new Doctor();
        johnEdgar.setFirstName("John");
        johnEdgar.setLastName("Edgar");
        johnEdgar.setSpeciality(oncology);
        johnEdgar.setTelephoneNumber("+351 912345678");
        johnEdgar.setClinic(bensClinic);
        doctorRepository.save(johnEdgar);
        log.info("Added Doctor John Edgar - id: " + johnEdgar.getId());

        Doctor deborahSmith = new Doctor();
        deborahSmith.setFirstName("Deborah");
        deborahSmith.setLastName("Smith");
        deborahSmith.setSpeciality(dermatology);
        deborahSmith.setTelephoneNumber("+351 912343868");
        deborahSmith.setClinic(hopeClinic);
        doctorRepository.save(deborahSmith);
        log.info("Added Doctor Deborah Smith - id: " + deborahSmith.getId());


    }




}
