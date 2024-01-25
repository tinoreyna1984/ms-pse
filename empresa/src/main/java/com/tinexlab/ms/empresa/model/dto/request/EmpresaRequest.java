package com.tinexlab.ms.empresa.model.dto.request;

import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
public class EmpresaRequest {
    @Pattern(regexp = "^10\\d{8}9$", message = "El RUC debe tener 11 dígitos, comenzar siempre con 10 y terminar con 9.")
    private String ruc;
    private String razonSocial;
    private String direccion;
    private String estado;

}
