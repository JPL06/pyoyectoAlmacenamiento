package com.doctic.backendDocTic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doctic.backendDocTic.Model.UsuarioModel;

public interface  IUsuarioRepository extends JpaRepository<UsuarioModel,Integer> {
    
}
