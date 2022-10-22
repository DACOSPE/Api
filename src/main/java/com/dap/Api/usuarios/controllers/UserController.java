package com.dap.Api.usuarios.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dap.Api.usuarios.models.ExceptionModel;
import com.dap.Api.usuarios.models.RegistroResponse;
import com.dap.Api.usuarios.models.UserPersonRequest;
import com.dap.Api.usuarios.services.UserService;

@RestController
@RequestMapping("/usuarios/")
public class UserController {

        @Autowired
        private UserService service;

        @PostMapping(value = "/registro", produces = MediaType.APPLICATION_JSON_VALUE)
        @Operation(description = "Registra ususarios", summary = "Registra ususarios")

        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Operacion exitosa", content = @Content(schema = @Schema(implementation = RegistroResponse.class))),
                        @ApiResponse(responseCode = "400", description = "Error en los parámetros proporcionados", content = @Content(schema = @Schema(implementation = ExceptionModel.class))),
                        @ApiResponse(responseCode = "500", description = "Error de servidor", content = @Content(schema = @Schema(implementation = ExceptionModel.class)))
        })
        public ResponseEntity<RegistroResponse> callRegistro(@Valid @RequestBody UserPersonRequest request) {
                try {
                        RegistroResponse response = service.crearUser(request);
                        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.OK);

                } catch (RuntimeException e) {

                        return new ResponseEntity<>(new RegistroResponse(new ExceptionModel(e.getMessage())),
                                        HttpStatus.BAD_REQUEST);
                }

        }

        @GetMapping(value = "/consultarRegistros", produces = MediaType.APPLICATION_JSON_VALUE)
        @Operation(description = "Consulta lista de usuarios", summary = "Consulta lista de usuarios")
        @ApiResponses({
                        @ApiResponse(responseCode = "200", description = "Operacion exitosa", content = @Content(schema = @Schema(implementation = RegistroResponse.class))),
                        @ApiResponse(responseCode = "400", description = "Error en los parametros proporcionados", content = @Content(schema = @Schema(implementation = ExceptionModel.class))),
                        @ApiResponse(responseCode = "500", description = "Error de servidor", content = @Content(schema = @Schema(implementation = ExceptionModel.class)))
        })
        @Valid
        public ResponseEntity<RegistroResponse> callConsultRegister() {
                RegistroResponse response = service.consultRegister();

                return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);

        }

}
