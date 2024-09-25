package com.doctic.backendDocTic.services;

import java.util.List;

import com.doctic.backendDocTic.Model.DocumentoModel;


public interface  IDocumentoService {  
    String crearDocumento(DocumentoModel Documento);
        DocumentoModel buscarDocumentoPorId(Integer DocumentoId);
        List<DocumentoModel>listarDocumento();
        DocumentoModel ActualizarDocumento (Integer idDocumento , DocumentoModel DocumentoActualizado);
        String eliminarDocumento(Integer IdDocumento);
    
}
