package com.tinexlab.ms.lista_empresas.model.contract;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empresa {
    private Long id;
    private String ruc;
    private String razonSocial;
    private String direccion;
    private String estado;
}
