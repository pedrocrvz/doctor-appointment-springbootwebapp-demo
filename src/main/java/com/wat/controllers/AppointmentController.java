package com.wat.controllers;

import com.wat.domain.Appointment;
import com.wat.services.AppointmentService;
import com.wat.services.DoctorService;
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
public class AppointmentController {
    
    private AppointmentService appointmentService;
    private SpecialityService specialtyService;
    private DoctorService doctorService;

    @Autowired
    public void setSpecialtyService(SpecialityService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Autowired
    public void setAppointmentService(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @Autowired
    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @RequestMapping(value = "/appointments", method = RequestMethod.GET)
    public String listAllAppointments(Model model){
        model.addAttribute("appointments", appointmentService.listAllAppointments());
        System.out.println("Here is the list of all Appointments:");
        return "appointments";
    }

    @RequestMapping(value = "/appointment/{id}", method = RequestMethod.GET)
    public String getAppointment(@PathVariable Integer id, Model model) {
        model.addAttribute("appointment", appointmentService.getAppointmentById(id));
        return "appointment";
    }

    @RequestMapping("newappointment")
    public String newAppointment(Model model){
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("error", "Error: it was not possible to create the appointment");
        model.addAttribute("specialities", specialtyService.listAllSpecialities());
        model.addAttribute("doctors", doctorService.listAllDoctors());

        return "appointmentform";
    }

    @RequestMapping(value = "/registerappointment", method = RequestMethod.POST)
    public String saveAppointment(Appointment appointment) {
        appointmentService.saveAppointment(appointment);
        return "registerdone";
    }

    @RequestMapping("appointment{id}")
    public String editAppointment(@PathVariable Integer id, Model model){
        model.addAttribute("appointment", appointmentService.getAppointmentById(id));
        model.addAttribute("error", "Error: it was not possible to update the appointment");
        return "appointmentform";
    }


    @RequestMapping("appointment/delete/{id}")
    public String delete(@PathVariable Integer id){
        appointmentService.deleteAppointment(id);
        return "redirect:/appointments";
    }
}
