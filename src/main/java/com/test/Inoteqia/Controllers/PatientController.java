package com.test.Inoteqia.Controllers;

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

    @DeleteMapping("/delete-user/{idUser}")
    public void deleteAccount(@PathVariable("idUser") Long idUser) {
        userServiceIMP.deleteUser(idUser);
    }



    @RequestMapping(value = "/register/patient/{idMedecin}", method = RequestMethod.POST)
    public ResponseEntity<Patient> registerPatient(@Validated @RequestBody Patient p1, @PathVariable("idMedecin") Long idMedecin) throws Exception {
        return patientService.registerPatient(p1,idMedecin);
    }


}
