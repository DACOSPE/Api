package com.dap.Api.usuarios.services;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dap.Api.usuarios.models.RegistroResponse;
import com.dap.Api.usuarios.models.UserPersonRequest;
import com.dap.Api.usuarios.models.entities.UserPerson;
import com.dap.Api.usuarios.repositories.PhoneRepository;
import com.dap.Api.usuarios.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public RegistroResponse consultRegister() {

        List<UserPerson> list = (List<UserPerson>) userRepository.findAll();

        return new RegistroResponse(list);
    }

    @Override
    public RegistroResponse crearUser(@Valid UserPersonRequest request) {

        UserPerson user = new UserPerson();

        if (validateEmail(request.getEmail())) {
            if (validatePassword(request.getPassword())) {
                UserPerson userA = userRepository.findByEmailIgnoreCase(request.getEmail());
                if (userA == null) {
                    RegistroResponse registroResponse = new RegistroResponse();

                    user.setEmail(request.getEmail());
                    user.setName(request.getName());
                    user.setPassword(request.getPassword());

                    userRepository.save(user);
                    request.getPhones().forEach((p) -> {
                        p.setIdUser(user.getId());
                        phoneRepository.save(p);
                    });
                    registroResponse.setId(user.getId().toString());
                    registroResponse.setCreated(user.getCreated());
                    registroResponse.setModified(user.getModified());
                    registroResponse.setLastLogin(user.getLastLogin());
                    registroResponse.setToken(user.getId().toString());
                    registroResponse.setIsActive(user.getIsActive());
                    return registroResponse;
                } else {
                    throw new RuntimeException("El correo ya esta registrado");
                }
            } else {
                throw new RuntimeException("La contraseña ingresada es inválida.");
            }
        } else {
            throw new RuntimeException("El email ingresado es inválido.");
        }
    }

    public Boolean validateEmail(String email) {

        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
        if (mather.find() == true) {
            System.out.println("El email ingresado es válido.");

            return true;

        } else {
            System.out.println("El email ingresado es inválido.");
            return false;
        }

    }

    public Boolean validatePassword(String password) {
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile(regex);
        Matcher mather = pattern.matcher(password);
        if (mather.find() == true) {
            System.out.println("La contraseña ingresada es válida.");

            return true;

        } else {
            System.out.println("La contraseña ingresada es inválida.");
            return false;
        }

    }

}
