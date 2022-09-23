package com.example.mediapinas.service;

import com.example.mediapinas.domain.model.MedicalAppointment;
import com.example.mediapinas.domain.repository.MedicalAppointmentRepository;
import com.example.mediapinas.domain.service.MedicalAppointmentService;
import com.example.mediapinas.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MedicalAppointmentServiceImpl implements MedicalAppointmentService {
    @Autowired
    private MedicalAppointmentRepository medicalAppointmentRepository;

    @Override
    public Page<MedicalAppointment> getAllMedicalAppointments(Pageable pageable) {
        return medicalAppointmentRepository.findAll(pageable);
    }

    @Override
    public MedicalAppointment getMedicalAppointmentById(Long id) {
        return medicalAppointmentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Medical Appointment", "Id", id));
    }

    @Override
    public MedicalAppointment createMedicalAppointment(MedicalAppointment medicalAppointmentRequest) {
        return medicalAppointmentRepository.save(medicalAppointmentRequest);
    }

    @Override
    public MedicalAppointment updateMedicalAppointment(Long id, MedicalAppointment medicalAppointmentRequest) {
        return medicalAppointmentRepository.findById(id).map(med -> {
            med.setDni(medicalAppointmentRequest.getDni());
            med.setDoctorName(medicalAppointmentRequest.getDoctorName());
            med.setDate(medicalAppointmentRequest.getDate());
            med.setDescription(medicalAppointmentRequest.getDescription());
            return medicalAppointmentRepository.save(med);
        }).orElseThrow(() -> new ResourceNotFoundException("Medical Appointment", "Id", id));
    }

    @Override
    public ResponseEntity<?> deleteMedicalAppointment(Long id) {
        return medicalAppointmentRepository.findById(id).map(med -> {
            medicalAppointmentRepository.delete(med);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Medical Appointment", "Id", id));
    }
}
