package com.example.patientservice.mapper;

import com.example.patientservice.dto.PatientResponseDTO;
import com.example.patientservice.model.Patient;

public class PatientMapper {
    public static PatientResponseDTO toDTO(Patient patient) {
        return PatientResponseDTO.builder()
                .id(patient.getId().toString())
                .name(patient.getName())
                .address(patient.getAddress())
                .email(patient.getEmail())
                .dateOfBirth(patient.getDateOfBirth().toString())
                .build();
    }
}
