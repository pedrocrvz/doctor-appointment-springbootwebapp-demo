package com.wat.controllers;

import com.wat.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by pedrocruz on 24/05/2018.
 */
@Controller
public class PatientController {

    private PatientService patientService;

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public String listAllPatients(Model model){
        model.addAttribute("patients", patientService.listAllPatients());
        System.out.println("Here is the list of all Patients:");
        return "patients";
    }

    @RequestMapping(value = "/patient/{id}", method = RequestMethod.GET)
    public String getPatient(@PathVariable Integer id, Model model) {
        model.addAttribute("patient", patientService.getPatientById(id));
        return "patient";
    }

}
