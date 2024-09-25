package com.doctic.backendDocTic.controller;

import java.lang.annotation.Repeatable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctic.backendDocTic.Model.UsuarioModel;
import com.doctic.backendDocTic.services.UsuarioServiceImp;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController{
public ResponseEntity<String>CrearUsuario(@RequestBody UsuarioModel Usuario){
    return new  ResponseEntity<String>(UsuarioService.guardar)
}
}