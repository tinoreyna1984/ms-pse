package com.tinexlab.ms.lista_empresas.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.tinexlab.ms.lista_empresas.model.contract.Empresa;

// Comunicación con el otro microservicio: paso 01

@FeignClient(name = "empresa")
public interface EmpresaRestClient {
    @GetMapping("/empresa")
    public List<Empresa> listarEmpresas();
}
