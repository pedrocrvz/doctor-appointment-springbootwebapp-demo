package com.wat.controllers;
import com.wat.domain.Appointment;
import com.wat.domain.Clinic;
import com.wat.services.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by pedrocruz on 23/05/2018.
 */

@Controller
public class ClinicController {

    private ClinicService clinicService;

    @Autowired
    public void setClinicService(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @RequestMapping(value = "/clinics", method = RequestMethod.GET)
    public String listAllClinics(Model model){
        model.addAttribute("clinics", clinicService.listAllClinics());
        System.out.println("Here is the list of all Clinics:");
        return "clinics";
    }

    @RequestMapping(value = "/clinic/{id}", method = RequestMethod.GET)
    public String getClinic(@PathVariable Integer id, Model model) {
        model.addAttribute("clinic", clinicService.getClinicById(id));
        return "clinic";
    }

    @RequestMapping("newclinic")
    public String newClinic(Model model){
        model.addAttribute("clinic", new Clinic());
        model.addAttribute("error", "Error: it was not possible to register the clinic");
        return "clinicform";
    }


    @RequestMapping(value = "/registerclinic", method = RequestMethod.POST)
    public String saveClinic(Clinic clinic) {
        clinicService.saveClinic(clinic);
        return "registerdone";
    }

    @RequestMapping("{id}")
    public String editClinic(@PathVariable Integer id, Model model){
        model.addAttribute("clinic", clinicService.getClinicById(id));
        model.addAttribute("error", "Error: it was not possible to update the clinic");
        return "clinicform";
    }


    @RequestMapping("clinic/delete/{id}")
    public String delete(@PathVariable Integer id){
        clinicService.deleteClinic(id);
        return "redirect:/clinics";
    }
}
