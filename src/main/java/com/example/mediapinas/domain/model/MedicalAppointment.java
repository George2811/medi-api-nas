package com.example.mediapinas.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table(name = "medical_appointments")
public class MedicalAppointment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int dni;

    @Column(nullable = false)
    private String doctorName;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar date;

    @Column(nullable = false)
    private String description;

    public MedicalAppointment() {
    }
    public MedicalAppointment(int dni, String doctorName, Calendar date, String description) {
        this.dni = dni;
        this.doctorName = doctorName;
        this.date = date;
        this.description = description;
    }

    public Long getId() {
        return id;
    }
    public MedicalAppointment setId(Long id) {
        this.id = id;
        return this;
    }

    public int getDni() {
        return dni;
    }
    public MedicalAppointment setDni(int dni) {
        this.dni = dni;
        return this;
    }

    public String getDoctorName() {
        return doctorName;
    }
    public MedicalAppointment setDoctorName(String doctorName) {
        this.doctorName = doctorName;
        return this;
    }

    public Calendar getDate() {
        return date;
    }
    public MedicalAppointment setDate(Calendar date) {
        this.date = date;
        return this;
    }

    public String getDescription() {
        return description;
    }
    public MedicalAppointment setDescription(String description) {
        this.description = description;
        return this;
    }
}
