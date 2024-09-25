package com.doctic.backendDocTic.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioModel{
    @Id
    private Integer IdUsuario;
    private String Nombre_de_usuario;
    private String Correo_electronico;
    private String  Pregunta_secreta;
}
