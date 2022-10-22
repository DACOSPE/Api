package com.dap.Api.usuarios.models.entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import lombok.Data;


@Entity
@Data
public class Phone {
    
    @Id    
    @GeneratedValue
    private UUID id;

    private UUID idUser;
    private String number;
    private String citycode;
    private String contrycode;
    
    
    
    
}
