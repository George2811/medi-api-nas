package com.example.mediapinas.domain.repository;

import com.example.mediapinas.domain.model.MedicalAppointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointment, Long> {
}
