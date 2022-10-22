# /apis/usuarios/

Micro-servicio para registro de usuarios.

>  #pruebaTecnica #java #springboot

---
## Tabla de Contenido

- [Descripción](#descripción)
- [Detalle de Funcionalidades](#detalle-de-funcionalidades)
- [Construido con](#construido-con)
- [Desarrollo](#desarrollo)
- [Autores](#autores)

---

## Descripción

El servicio tiene como objetivo registrar un usuario en una BD en memoria, valida el formato  de email y formato de la contraseña del usuario, y no  se acepta agregar usuarios con un correo ya registrado en la BD.



---

## Detalle de Funcionalidades

#### POST/ /apis/usuarios/registro

##### REQUEST
```
{
  "name": "pepe caceres",
  "email": "pepe@gm.com",
  "password": "3567399Dap+",
  "phones": [
    {
      
      "number": "34536788762",
      "citycode": "1",
      "contrycode": "57"
    }
  ]
}

```


##### RESPONSE OK
Usuario información completa

```
{
  "id": "3b48a7e6-8b8f-4f51-9aba-3d6e40b52669",
  "created": "22-10-2022",
  "modified": "22-10-2022",
  "lastLogin": "22-10-2022",
  "token": "3b48a7e6-8b8f-4f51-9aba-3d6e40b52669",
  "isActive": "A"
}
```


##### RESPONSE ERROR
```
{
  "mensaje": "string"
}
   
```

---

 #### GET/ /apis/usuarios/consultarRegistros

##### REQUEST
```


```


##### RESPONSE OK
Usuario información completa

```

{
  "users": [
    {
      "id": "cb3d262a-93a9-427a-bf26-61c3b1814121",
      "name": "pepe caceres",
      "email": "pepe@gm.com",
      "password": "3567399Dap+",
      "created": "22-10-2022",
      "modified": "22-10-2022",
      "lastLogin": "22-10-2022",
      "token": null,
      "isActive": "A"
    }
  ]
}
```


##### RESPONSE ERROR
```
{
  "mensaje": "string"
}
   
```

---

             

## Construido con 

El código se encuentra implementado con Java 11.0.9 y SpringBoot 2.7.5

- Visual studio code
- Java Extension Pack
- Spring Boot Extension Pack
- Lombok Annotations Support for VS Code
- Maven
- JVM 11.0.9
- Swagger UI

## Desarrollo
1. Instale el ambiente de desarrollo Java (JVM 11.0.9). 
2. Clone este repositorio.
3. Usando el plugin de maven en vscode, ejecute la tarea clean y build o click derecho en la Clae ApiAplication.java y click en Run Java.
4. Los test unitarios se ejecutan con la tarea test .
5. Puede ejecutar el proyecto desde la pestaña `SPRING BOOT DASHBOARD`.
6. La Url de Swagger:
    -[local](http://localhost:8090/apis/swagger-ui/index.html)
7. Las url's: 
    -[local](http://localhost:8090/apis/usuarios/registro) 
    -[local](http://localhost:8090/apis/usuarios/consultarRegistros) 



## Proyectos relacionados

A continuación se detallan los módulos o funcionalidades que usan los servicios contenidos en este servicio:

### polizas-cumplimiento-micrositios-
- URL de Github:  [Repositorio](https://github.com/DACOSPE/Api.git)

	
---
## Autores

El equipo involucrado en la implementación de estos componentes se detalla a continuación:

  - DAVID ACOSTA PEÑA
  - EMAIL:DAAP.92@GMAIL.COM
  



