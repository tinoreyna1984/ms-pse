package com.tinexlab.ms.lista_empresas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tinexlab.ms.lista_empresas.model.contract.Empresa;
import com.tinexlab.ms.lista_empresas.service.ListaService;

// Comunicación con el otro microservicio: paso 03

@RestController
public class ListaController {
    
    @Autowired
    private ListaService listaService;

    // lista las 3 últimas empresas
    @GetMapping("/empresa")
    public List<Empresa> listarEmpresas(){
        return listaService.findAll();
    }
}
