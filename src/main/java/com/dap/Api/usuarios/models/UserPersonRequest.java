package com.dap.Api.usuarios.models;



import java.util.List;

import com.dap.Api.usuarios.models.entities.Phone;

import lombok.Data;


@Data
public class UserPersonRequest {   
    
    private String name;    
    private String email;
    private String password;
    private List <Phone> phones;

    
}

