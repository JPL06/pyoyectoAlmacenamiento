package com.doctic.backendDocTic.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="Documento")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class DocumentoModel {
    @Id
    private int IdDocumento;

    @Column(name = "Nombre_del_documento")
    private String nombre_Del_Documento;

    @Column(name = "Fecha_de_publicacion")
    private LocalDate fecha_De_Publicacion;

    @Column(name = "URL")
    private String url;

    @Enumerated(EnumType.STRING)

    @Column(name = "visibilidad")

    private Visibilidad visibilidad;


    public enum Visibilidad {
       
    }
}
