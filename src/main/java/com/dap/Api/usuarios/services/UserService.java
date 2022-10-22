package com.dap.Api.usuarios.services;

import javax.validation.Valid;

import com.dap.Api.usuarios.models.RegistroResponse;
import com.dap.Api.usuarios.models.UserPersonRequest;

public interface UserService {

    public RegistroResponse consultRegister();

    public RegistroResponse crearUser(@Valid UserPersonRequest request);

}