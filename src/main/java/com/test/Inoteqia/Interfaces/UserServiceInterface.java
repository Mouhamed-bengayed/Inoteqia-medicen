package com.test.Inoteqia.Interfaces;


import com.test.Inoteqia.DTO.RoleName;
import com.test.Inoteqia.Entity.Utilisateur;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {

    public List<Utilisateur> getAllUser() ;

    public Utilisateur getUserById(Long idUser);

    public List<Utilisateur> getUserByRoles(RoleName roleName);

    public Utilisateur deleteUser(Long id);


    public void bloqueUser(Long id) throws Exception;


    public void validInscription(Long id) ;







    public ResponseEntity<Utilisateur> registerAdmin(@Valid @RequestBody Utilisateur user);




    public Optional<Utilisateur> getCurrentUser() ;

}
