package com.wat.domain;

import javax.persistence.*;

/**
 * Created by pedrocruz on 21/05/2018.
 */
@Entity
public class Doctor{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;
    private String lastName;
    private String telephoneNumber;

    @ManyToOne
    @JoinColumn(name = "speciality")
    private Speciality speciality;

    @ManyToOne
    @JoinColumn(name = "clinic")
    private Clinic clinic;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Speciality getSpeciality(){
        return speciality;
    }

    public void setSpeciality(Speciality speciality){
        this.speciality = speciality;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }


}
