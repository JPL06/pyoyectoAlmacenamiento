package com.doctic.backendDocTic.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.doctic.backendDocTic.Exception.RecursoNoEncontradoException;
import com.doctic.backendDocTic.Model.DocumentoModel;
import com.doctic.backendDocTic.repository.IDocumentoRepository;

public class DocumentoServiceImp implements IDocumentoService{ 

    @Autowired
    IDocumentoRepository  documentoRepository;

    @Override
    public String crearDocumento (DocumentoModel Documento) {
        documentoRepository.save(Documento);
        return "El Documento con ID " + Documento.getIdDocumento() + 
               ", llamado " + Documento.getNombre_Del_Documento()+ " fue creado con éxito";
    }
 
    @Override
    public DocumentoModel buscarDocumentoPorId (Integer DocumentoId) {
        Optional<DocumentoModel> DocumentoRecuperado = documentoRepository.findById(DocumentoId);
        return DocumentoRecuperado.orElseThrow(() -> 
            new RecursoNoEncontradoException("Error! El Documento con el ID " + DocumentoId + 
            " no existe en la BD o el ID es incorrecto"));
    }

    @Override
    public List<DocumentoModel>listarDocumento(){
        return documentoRepository.findAll();
    }

    @Override
    public DocumentoModel ActualizarDocumento (Integer IdDocumento, DocumentoModel DocumentoActualizado) {
        return documentoRepository.findById(IdDocumento).map(Documento -> {
            Documento.setIdDocumento(DocumentoActualizado.getIdDocumento());
            Documento.setNombre_Del_Documento(DocumentoActualizado.getNombre_Del_Documento());
            Documento.setFecha_De_Publicacion(DocumentoActualizado.getFecha_De_Publicacion());
            return documentoRepository.save(Documento);
        }).orElseThrow(() -> new RecursoNoEncontradoException("Documento no encontrado con ID: " + IdDocumento));
    }

    public String eliminarDocumento(Integer IdDocumento) {
        Optional<DocumentoModel> Documento = documentoRepository.findById(IdDocumento);
        if (Documento.isPresent()) {
            documentoRepository.deleteById(IdDocumento);
            return "Usuario eliminado con éxito"; } 
}
}