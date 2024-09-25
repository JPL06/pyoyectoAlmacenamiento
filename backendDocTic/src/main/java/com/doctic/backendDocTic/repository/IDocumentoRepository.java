package com.doctic.backendDocTic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doctic.backendDocTic.Model.DocumentoModel;

public interface IDocumentoRepository extends JpaRepository<DocumentoModel, Integer>{
    
}
