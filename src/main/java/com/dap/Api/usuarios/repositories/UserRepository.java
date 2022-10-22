package com.dap.Api.usuarios.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dap.Api.usuarios.models.entities.UserPerson;

@Repository
public interface UserRepository extends CrudRepository<UserPerson, Long> {
    UserPerson findByEmailIgnoreCase(String email);
    
}