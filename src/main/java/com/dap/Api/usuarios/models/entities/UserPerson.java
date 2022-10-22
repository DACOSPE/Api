package com.dap.Api.usuarios.models.entities;



import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "UserPerson")
public class UserPerson {
    
    @Id    
    @GeneratedValue
    private UUID id;
    private String name;
    private String email;
    private String password;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date created= new Date();
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date modified= new Date();
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date lastLogin= new Date(); 
    private String token;
    private String isActive ="A";


    
}

