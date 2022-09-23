package com.example.mediapinas.domain.service;

import com.example.mediapinas.domain.model.MedicalAppointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface MedicalAppointmentService {
    Page<MedicalAppointment> getAllMedicalAppointments(Pageable pageable);
    MedicalAppointment getMedicalAppointmentById(Long id);
    MedicalAppointment createMedicalAppointment(MedicalAppointment medicalAppointmentRequest);
    MedicalAppointment updateMedicalAppointment(Long id, MedicalAppointment medicalAppointmentRequest);
    ResponseEntity<?> deleteMedicalAppointment(Long id);
}
