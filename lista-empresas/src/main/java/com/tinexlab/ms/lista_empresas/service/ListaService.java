package com.tinexlab.ms.lista_empresas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tinexlab.ms.lista_empresas.client.EmpresaRestClient;
import com.tinexlab.ms.lista_empresas.model.contract.Empresa;

// Comunicación con el otro microservicio: paso 02

@Service
public class ListaService {
    @Autowired
    private EmpresaRestClient empresaRestClient;

    public List<Empresa> findAll() {
        try {
            return empresaRestClient.listarEmpresas()
                .stream()
                .sorted((empresa1, empresa2) -> Long.compare(empresa2.getId(), empresa1.getId()))
                .limit(3)
                .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
        
    }
}
