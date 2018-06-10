package com.wat.controllers;

import com.wat.domain.Doctor;
import com.wat.domain.Speciality;
import com.wat.services.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by pedrocruz on 23/05/2018.
 */
@Controller
public class SpecialityController {
    private SpecialityService specialityService;

    @Autowired
    public void setSpecialtyService(SpecialityService specialtyService) {
        this.specialityService = specialtyService;
    }

    @RequestMapping(value = "/specialities", method = RequestMethod.GET)
    public String listAllSpecialities(Model model){
        model.addAttribute("specialities", specialityService.listAllSpecialities());
        System.out.println("Here is the list of all Specialities:");
        return "specialities";
    }

    @RequestMapping(value = "/speciality/{id}", method = RequestMethod.GET)
    public String getSpeciality(@PathVariable Integer id, Model model) {
        model.addAttribute("speciality", specialityService.getSpecialityById(id));
        return "speciality";
    }

    @RequestMapping("newspeciality")
    public String newSpeciality(Model model){
        model.addAttribute("speciality", new Speciality());
        model.addAttribute("error", "Error: it was not possible to register the speciality");
        return "specialityform";
    }


    @RequestMapping(value = "/registerspeciality", method = RequestMethod.POST)
    public String saveSpeciality(Speciality speciality) {
        specialityService.saveSpeciality(speciality);
        return "registerdone";
    }
}
