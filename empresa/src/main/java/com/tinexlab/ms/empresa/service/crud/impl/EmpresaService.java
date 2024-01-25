package com.tinexlab.ms.empresa.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.tinexlab.ms.empresa.dao.EmpresaDao;
import com.tinexlab.ms.empresa.model.dto.request.EmpresaRequest;
import com.tinexlab.ms.empresa.model.dto.response.GenericResponse;
import com.tinexlab.ms.empresa.model.entity.Empresa;
import com.tinexlab.ms.empresa.service.crud.GenericService;
import com.tinexlab.ms.empresa.util.HelperClass;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService implements GenericService<Empresa, EmpresaRequest> {

    @Autowired
    private EmpresaDao empresaDao;
    private final HelperClass helperClass = new HelperClass();

    @Override
    public GenericResponse<?> get(Integer page, Integer size) {
        try{
            if (page != null && size != null) {
                // Si se proporcionan los parámetros de paginación, devuelve una lista paginada
                Pageable pageable = PageRequest.of(page, size);
                Page<Empresa> pageResult = empresaDao.findAll(pageable);
                return GenericResponse.getResponse(200, "Se encuentran las empresas", pageResult);
            } else {
                // Si no se proporcionan los parámetros de paginación, devuelve una lista completa
                List<Empresa> empresas = empresaDao.findAll();
                return GenericResponse.getResponse(200, "Se encuentran las empresas", empresas);
            }
        } catch (DataAccessException e){
            return GenericResponse
                    .getResponse(500,
                            "Error al consultar empresas: " + e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()),
                            null);
        } catch (Exception e){
            return GenericResponse
                    .getResponse(500,
                            "Error inesperado: " + e.getMessage(),
                            null);
        }
    }

    public List<Empresa> getList() {
        try{
            List<Empresa> empresas = empresaDao.findAll();
            return empresas;
        } catch (DataAccessException e){
            return null;
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public GenericResponse<Empresa> getById(Long id) {
        Optional<Empresa> optionalEmpresa = empresaDao.findById(id);
        Empresa empresa;
        try {
            if(optionalEmpresa.isEmpty()){
                return GenericResponse
                        .getResponse(400,
                                "No se encuentra la empresa con ID " + id,
                                null);
            }
            empresa = optionalEmpresa.get();
        }catch(DataAccessException e) {
            return GenericResponse
                    .getResponse(500,
                            "Error al buscar empresa: " + e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()),
                            null);
        } catch (Exception e){
            return GenericResponse
                    .getResponse(500,
                            "Error inesperado: " + e.getMessage(),
                            null);
        }
        return GenericResponse.getResponse(200, "Usuario encontrado", empresa);
    }

    @Override
    public GenericResponse<?> save(EmpresaRequest request, BindingResult result) {
        // Verifica que la empresa no se haya registrado antes
        Optional<Empresa> optionalEmpresa = empresaDao.findByRuc(request.getRuc());
        if(optionalEmpresa.isPresent()){
            return GenericResponse
                    .getResponse(400,
                            "Ya existe empresa con RUC " + request.getRuc(),
                            null);
        }

        Empresa empresaNueva = new Empresa();

        // proceso de validación
        String errors = helperClass.validaRequest(result);
        if (!errors.isEmpty())
            return GenericResponse.getResponse(400, "Error al crear empresa: " + errors, errors);

        empresaNueva.setRuc(request.getRuc());
        empresaNueva.setRazonSocial(request.getRazonSocial());
        empresaNueva.setDireccion(request.getDireccion());
        empresaNueva.setEstado(request.getEstado());

        
        try {
            empresaNueva = empresaDao.save(empresaNueva);
        } catch(DataAccessException e) {
            return GenericResponse
                    .getResponse(500,
                            "Error al crear empresa: " + e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()),
                            null);
        } catch (Exception e){
            return GenericResponse
                    .getResponse(500,
                            "Error inesperado: " + e.getMessage(),
                            null);
        }

        return GenericResponse.getResponse(201, "Empresa creada", empresaNueva);

    }

    @Override
    public GenericResponse<?> update(EmpresaRequest request, Long id, BindingResult result) {
        // proceso de validación
        String errors = helperClass.validaRequest(result);
        if (!errors.isEmpty())
            return GenericResponse.getResponse(400, "Error al actualizar empresa: " + errors, errors);
        
        Optional<Empresa> optionalEmpresa = empresaDao.findById(id);
        Empresa empresaEditada = null;
        if(optionalEmpresa.isEmpty())
            return GenericResponse
                    .getResponse(400,
                            "No se encuentra la empresa con ID " + id,
                            null);
        Empresa empresaActual = optionalEmpresa.get();

        try {
            empresaActual.setRuc(request.getRuc());
            empresaActual.setRazonSocial(request.getRazonSocial());
            empresaActual.setDireccion(request.getDireccion());
            empresaActual.setEstado(request.getEstado());
            empresaEditada = empresaDao.save(empresaActual);
        } catch(DataAccessException e) {
            return GenericResponse
                    .getResponse(500,
                            "Error al actualizar empresa: " + e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()),
                            null);
        } catch (Exception e){
            return GenericResponse
                    .getResponse(500,
                            "Error inesperado: " + e.getMessage(),
                            null);
        }
        return GenericResponse.getResponse(200, "Empresa actualizada", empresaEditada);
    }

    @Override
    public GenericResponse<?> delete(Long id) {
        try {
            empresaDao.deleteById(id);
        }catch(DataAccessException e) {
            return GenericResponse
                    .getResponse(500,
                            "Error al realizar la consulta en la base de datos: " + e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()),
                            null);
        } catch (Exception e){
            return GenericResponse
                    .getResponse(500,
                            "Error inesperado: " + e.getMessage(),
                            null);
        }

        return GenericResponse.getResponse(200, "Empresa borrada", null);
    }

}
