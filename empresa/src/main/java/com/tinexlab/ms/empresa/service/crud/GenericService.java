package com.tinexlab.ms.empresa.service.crud;

import org.springframework.validation.BindingResult;
import com.tinexlab.ms.empresa.model.dto.response.GenericResponse;

public interface GenericService<T, R> {
    GenericResponse<?> get(Integer page, Integer size);
    GenericResponse<T> getById(Long id);
    GenericResponse<?> save(R request, BindingResult result);
    GenericResponse<?> update(R request, Long id, BindingResult result);
    GenericResponse<?> delete(Long id);
}

