package com.doctic.backendDocTic.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctic.backendDocTic.Exception.RecursoNoEncontradoException;
import com.doctic.backendDocTic.Model.UsuarioModel;
import com.doctic.backendDocTic.repository.IUsuarioRepository;

@Service
public class UsuarioServiceImp implements IUsuarioService {

    @Autowired
    IUsuarioRepository usuarioRepository;

    @Override
    public String crearUsuario(UsuarioModel usuario) {
        usuarioRepository.save(usuario);
        return "El Usuario con ID " + usuario.getIdUsuario() + 
               ", llamado " + usuario.getNombre_de_usuario() + " fue creado con éxito";
    }

    @Override
    public UsuarioModel buscarUsuarioPorId(Integer usuarioId) {
        Optional<UsuarioModel> usuarioRecuperado = usuarioRepository.findById(usuarioId);
        return usuarioRecuperado.orElseThrow(() -> 
            new RecursoNoEncontradoException("Error! El Usuario con el ID " + usuarioId + 
            " no existe en la BD o el ID es incorrecto"));
    }

    @Override
    public List<UsuarioModel> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioModel ActualizarUsuario(Integer idUsuario, UsuarioModel usuarioActualizado) {
        return usuarioRepository.findById(idUsuario).map(usuario -> {
            usuario.setNombre_de_usuario(usuarioActualizado.getNombre_de_usuario());
            usuario.setCorreo_electronico(usuarioActualizado.getCorreo_electronico());
            usuario.setPregunta_secreta(usuarioActualizado.getPregunta_secreta());
            // Añade más campos si es necesario.
            return usuarioRepository.save(usuario);
        }).orElseThrow(() -> new RecursoNoEncontradoException("Usuario no encontrado con ID: " + idUsuario));
    }
}
