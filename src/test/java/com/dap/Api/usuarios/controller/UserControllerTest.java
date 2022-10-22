package com.dap.Api.usuarios.controller;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.dap.Api.usuarios.controllers.UserController;
import com.dap.Api.usuarios.datos.DatosUsuario;
import com.dap.Api.usuarios.models.RegistroResponse;
import com.dap.Api.usuarios.models.UserPersonRequest;
import com.dap.Api.usuarios.services.UserService;

import java.text.ParseException;

@SpringBootTest
class UserControllerTest  {

    @Mock
    @Autowired
    private UserService genericoService;

    @InjectMocks
    private UserController genericoController;

    private AutoCloseable closeable;


    @BeforeEach
    void init()
    {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void closeService() throws Exception{
        closeable.close();
    }

    @Test
    void validaSuccess() throws ParseException {

        init();

        UserPersonRequest request  = DatosUsuario.getRequest();
        RegistroResponse response = DatosUsuario.getResponse();


        Mockito.when(genericoService.consultRegister())
                .thenReturn(response);

        Mockito.when(genericoService.crearUser(request))
                .thenReturn(response);

        
        ResponseEntity<RegistroResponse> controllerResponse = genericoController.callRegistro(request);

        Assertions.assertNotNull(controllerResponse);
        Assertions.assertEquals(HttpStatus.OK,controllerResponse.getStatusCode());

        

    }


}
