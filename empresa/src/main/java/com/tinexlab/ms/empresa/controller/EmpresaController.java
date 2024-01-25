package com.tinexlab.ms.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.tinexlab.ms.empresa.model.dto.request.EmpresaRequest;
import com.tinexlab.ms.empresa.model.dto.response.GenericResponse;
import com.tinexlab.ms.empresa.model.entity.Empresa;
import com.tinexlab.ms.empresa.service.crud.impl.EmpresaService;

import jakarta.validation.Valid;

@RestController
public class EmpresaController {
    
    @Autowired
    private EmpresaService empresaService;

    
    @GetMapping("/empresa")
    // devuelve una lista completa o paginada si viajan parámetros de paginación
    /* public ResponseEntity<GenericResponse<?>> listarEmpresas(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("custom-status", "OK")
                .contentType(MediaType.APPLICATION_JSON)
                .body(empresaService.get(page, size)
                );
    } */
    public List<Empresa> listarEmpresas() {
        return empresaService.getList();
    }

    @GetMapping("/empresa/{id}")
    public ResponseEntity<GenericResponse<Empresa>> buscarEmpresa(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("custom-status", "OK")
                .contentType(MediaType.APPLICATION_JSON)
                .body(empresaService.getById(id)
                );
    }


    @PostMapping("/empresa")
    public ResponseEntity<GenericResponse<?>> guardarEmpresa(@Valid @RequestBody EmpresaRequest request, BindingResult result){
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("custom-status", "OK")
                .contentType(MediaType.APPLICATION_JSON)
                .body(empresaService.save(request, result)
                );
    }

    @PutMapping("/empresa/{id}")
    public ResponseEntity<GenericResponse<?>> editarEmpresa(@Valid @RequestBody EmpresaRequest request, @PathVariable Long id, BindingResult result){
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("custom-status", "OK")
                .contentType(MediaType.APPLICATION_JSON)
                .body(empresaService.update(request, id, result)
                );
    }

    @DeleteMapping("/empresa/{id}")
    public ResponseEntity<GenericResponse<?>> borrarEmpresa(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("custom-status", "OK")
                .contentType(MediaType.APPLICATION_JSON)
                .body(empresaService.delete(id)
                );
    }

}
