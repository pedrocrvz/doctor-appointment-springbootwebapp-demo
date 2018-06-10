package com.wat.controllers;

import com.wat.domain.Doctor;
import com.wat.services.DoctorService;
import com.wat.services.ClinicService;
import com.wat.services.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by pedrocruz on 21/05/2018.
 */

@Controller
public class DoctorController {

    private DoctorService doctorService;
    private SpecialityService specialtyService;
    private ClinicService clinicService;

    @Autowired
    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Autowired
    public void setSpecialtyService(SpecialityService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Autowired
    public void setClinicService(ClinicService clinicService) {
        this.clinicService = clinicService;
    }



    @RequestMapping(value = "/doctors", method = RequestMethod.GET)
    public String listAllDoctors(Model model){
        model.addAttribute("doctors", doctorService.listAllDoctors());
        System.out.println("Here is the list of all Doctor:");
        return "doctors";
    }

    @RequestMapping(value = "/doctor/{id}", method = RequestMethod.GET)
    public String getDoctor(@PathVariable Integer id, Model model) {
        model.addAttribute("doctor", doctorService.getDoctorById(id));
        return "doctor";
    }

    @RequestMapping("newdoctor")
    public String newDoctor(Model model){
        model.addAttribute("doctor", new Doctor());
        model.addAttribute("error", "Error: it was not possible to register the doctor");
        model.addAttribute("specialities", specialtyService.listAllSpecialities());
        model.addAttribute("clinics", clinicService.listAllClinics());
        return "doctorform";
    }


    @RequestMapping(value = "/registerdoctor", method = RequestMethod.POST)
    public String saveDoctor(Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "registerdone";
    }
}
