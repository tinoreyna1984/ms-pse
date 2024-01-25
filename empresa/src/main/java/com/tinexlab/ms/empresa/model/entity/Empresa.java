package com.tinexlab.ms.empresa.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empresas")
public class Empresa {
	@Id
    @Column(name = "id_empresa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @Column(name = "ruc")
    private String ruc;
    @Column(name = "razon_social")
    private String razonSocial;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "estado")
    private String estado;

}
