package com.api.beelieve.entidades.projeto.dto;

import jakarta.validation.constraints.NotBlank;

public record DateInicializaProjeto(@NotBlank(message = "Data não pode ser vazia") String data_inicio_projeto) {
}
