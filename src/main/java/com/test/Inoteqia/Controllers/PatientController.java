package com.test.Inoteqia.Controllers;

import com.test.Inoteqia.DTO.RoleName;
import com.test.Inoteqia.Entity.Patient;
import com.test.Inoteqia.Entity.Utilisateur;
import com.test.Inoteqia.ServiceIMP.UserServiceIMP;
import com.test.Inoteqia.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api/patient")
@RestController
public class PatientController {

    @Autowired
    PatientService patientService;
    @Autowired
    UserServiceIMP userServiceIMP;

    @GetMapping("/list-patient")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Utilisateur> ListPatient() throws Exception {
        return patientService.getAllPatients();
    }
/*
    @PutMapping("/validate-user/{idPatient}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void validInscription(@PathVariable("idPatient") Long idPatient) {
        patientService.(idUser);
    }
*/
    @PutMapping("/bloque-user/{idUser}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void bloqueUser(@PathVariable("idUser") Long idUser) {
        userServiceIMP.bloqueUser(idUser);
    }
    @DeleteMapping("/delete-user/{idUser}")
    public void deleteAccount(@PathVariable("idUser") Long idUser) {
        userServiceIMP.deleteUser(idUser);
    }

    @GetMapping("/list-RolesName/{RolesName}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Utilisateur> ListUserByRoles(@PathVariable("RolesName") RoleName roleName) {
        return userServiceIMP.getUserByRoles(roleName);
    }

    @RequestMapping(value = "/signup/patient/{roleName}", method = RequestMethod.POST)
    public ResponseEntity<Utilisateur> registerPatient(@Validated @RequestBody Utilisateur p1, @PathVariable ("roleName")String roleName) throws Exception {
        return patientService.registerPatient(p1,roleName);
    }


}
