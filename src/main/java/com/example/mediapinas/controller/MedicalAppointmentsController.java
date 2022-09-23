package com.example.mediapinas.controller;

import com.example.mediapinas.domain.model.MedicalAppointment;
import com.example.mediapinas.domain.service.MedicalAppointmentService;
import com.example.mediapinas.resource.MedicalAppointmentResource;
import com.example.mediapinas.resource.SaveMedicalAppointmentResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MedicalAppointmentsController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private MedicalAppointmentService medicalAppointmentService;

    @GetMapping("/")
    public Page<MedicalAppointmentResource> getAllMedicalAppointments(Pageable pageable){
        Page<MedicalAppointment> medicalAppointmentPage = medicalAppointmentService.getAllMedicalAppointments(pageable);
        List<MedicalAppointmentResource> resources = medicalAppointmentPage.getContent().
                stream().map(this::convertToResource).
                collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/{id}")
    public MedicalAppointmentResource getMedicalAppointmentById(@PathVariable Long id){
        return convertToResource(medicalAppointmentService.getMedicalAppointmentById(id));
    }

    @PostMapping("/")
    public MedicalAppointmentResource createMedicalAppointment(@RequestBody SaveMedicalAppointmentResource resource){
        return convertToResource(medicalAppointmentService.createMedicalAppointment(convertToEntity(resource)));
    }

    @PutMapping("/{id}")
    public MedicalAppointmentResource updateMedicalAppointment(@PathVariable Long id, @RequestBody SaveMedicalAppointmentResource resource){
        return convertToResource(medicalAppointmentService.updateMedicalAppointment(id, convertToEntity(resource)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMedicalAppointment(@PathVariable Long id){
        return medicalAppointmentService.deleteMedicalAppointment(id);
    }

    private MedicalAppointment convertToEntity(SaveMedicalAppointmentResource resource){
        return  mapper.map(resource, MedicalAppointment.class);
    }
    private MedicalAppointmentResource convertToResource(MedicalAppointment medicalAppointment){
        return mapper.map(medicalAppointment, MedicalAppointmentResource.class);
    }
}
