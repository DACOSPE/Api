package com.dap.Api.usuarios.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.dap.Api.usuarios.models.entities.UserPerson;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Schema(name = "RegistroResponse")
public class RegistroResponse {
    
    
    
    public RegistroResponse(ExceptionModel e) {
        this.setError(e);
    }
    public RegistroResponse(List<UserPerson> list) {
        this.setUsers(list);
    }
    private String id;//id del usuario
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date created; // fecha de creación del usuario
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date modified;// fecha de la última actualización de usuario
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date lastLogin;// fecha del último ingreso 
    private String token;//token de acceso de la API (puede ser UUID o JWT)
    private String isActive;// Indica si el usuario sigue habilitado dentro del sistema
    private ExceptionModel error;
    List<UserPerson> users; //Lista de usuariod creados
    
    
}
