package com.sistema.clinica.odontologica.dto;

import java.time.LocalDateTime;

public record PatientDto(String name, String cpf, String cellphone, String email, LocalDateTime createdAt) {
}
