package com.example.mediapinas.resource;

import java.util.Calendar;

public class MedicalAppointmentResource {
    private Long id;
    private int dni;
    private String doctorName;
    private Calendar date;
    private String description;

    public Long getId() {
        return id;
    }
    public MedicalAppointmentResource setId(Long id) {
        this.id = id;
        return this;
    }

    public int getDni() {
        return dni;
    }
    public MedicalAppointmentResource setDni(int dni) {
        this.dni = dni;
        return this;
    }

    public String getDoctorName() {
        return doctorName;
    }
    public MedicalAppointmentResource setDoctorName(String doctorName) {
        this.doctorName = doctorName;
        return this;
    }

    public Calendar getDate() {
        return date;
    }
    public MedicalAppointmentResource setDate(Calendar date) {
        this.date = date;
        return this;
    }

    public String getDescription() {
        return description;
    }
    public MedicalAppointmentResource setDescription(String description) {
        this.description = description;
        return this;
    }
}
