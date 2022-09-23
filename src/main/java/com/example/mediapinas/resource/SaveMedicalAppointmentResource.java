package com.example.mediapinas.resource;

import javax.validation.constraints.NotNull;
import java.util.Calendar;

public class SaveMedicalAppointmentResource {
    @NotNull
    private int dni;
    @NotNull
    private String doctorName;
    @NotNull
    private Calendar date;
    @NotNull
    private String description;

    public int getDni() {
        return dni;
    }
    public SaveMedicalAppointmentResource setDni(int dni) {
        this.dni = dni;
        return this;
    }

    public String getDoctorName() {
        return doctorName;
    }
    public SaveMedicalAppointmentResource setDoctorName(String doctorName) {
        this.doctorName = doctorName;
        return this;
    }

    public Calendar getDate() {
        return date;
    }
    public SaveMedicalAppointmentResource setDate(Calendar date) {
        this.date = date;
        return this;
    }

    public String getDescription() {
        return description;
    }
    public SaveMedicalAppointmentResource setDescription(String description) {
        this.description = description;
        return this;
    }
}
