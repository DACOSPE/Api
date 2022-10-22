package com.dap.Api.usuarios.datos;

import com.dap.Api.usuarios.models.RegistroResponse;
import com.dap.Api.usuarios.models.UserPersonRequest;
import com.dap.Api.usuarios.models.entities.Phone;



import java.util.ArrayList;
import java.util.List;

public class DatosUsuario {

  

    public static RegistroResponse getResponse(){
        RegistroResponse usersResponse = new RegistroResponse();

        
        usersResponse.setUsers(new ArrayList<>());

        return usersResponse;
    }

    public static UserPersonRequest getRequest(){

        UserPersonRequest userPersonRequest = new UserPersonRequest();
        Phone phone=new Phone();
        phone.setNumber("678876509");
        phone.setContrycode("57");
        phone.setCitycode("1");
        List<Phone>  lPhone=new ArrayList<>();
        lPhone.add(phone);
        userPersonRequest.setName("Juan Anemo");
        userPersonRequest.setEmail("juan92@hotmail.cl");
        userPersonRequest.setPassword("3567399Dap+*");
        userPersonRequest.setPhones(lPhone);
       
       

        return userPersonRequest;
    }
}
