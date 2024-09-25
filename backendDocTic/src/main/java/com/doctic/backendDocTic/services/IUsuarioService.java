package com.doctic.backendDocTic.services;

import java.util.List;

import com.doctic.backendDocTic.Model.UsuarioModel;

    public interface IUsuarioService{
    
        String crearUsuario(UsuarioModel usuario);
        UsuarioModel buscarUsuarioPorId(Integer UsuarioId);
        List<UsuarioModel>listarUsuarios();
        UsuarioModel ActualizarUsuario(Integer idUsuario , UsuarioModel UsuarioActualizado);
    
    }
    

