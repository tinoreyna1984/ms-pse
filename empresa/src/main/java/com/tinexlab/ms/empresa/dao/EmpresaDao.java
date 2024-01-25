package com.tinexlab.ms.empresa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tinexlab.ms.empresa.model.entity.Empresa;

import java.util.Optional;

@Repository
public interface EmpresaDao extends JpaRepository<Empresa, Long> {
    Optional<Empresa> findByRuc(String ruc);
}
