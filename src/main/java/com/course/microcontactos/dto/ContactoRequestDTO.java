package com.course.microcontactos.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import java.io.Serializable;

@Data
public class ContactoRequestDTO implements Serializable {

    @Positive(message = "La edad debe ser mayor que cero")
    private int edad;

    @NotEmpty(message = "El email no debe ser vacio")
    private String email;

    @NotEmpty(message = "El nombre no debe ser vacio")
    private String name;
}
