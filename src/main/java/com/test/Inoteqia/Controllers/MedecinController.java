package com.test.Inoteqia.Controllers;

import com.test.Inoteqia.Entity.Medecin;
import com.test.Inoteqia.Entity.Utilisateur;
import com.test.Inoteqia.ServiceIMP.UserServiceIMP;
import com.test.Inoteqia.Services.MedicenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api/medecin")
@RestController
public class MedecinController {

    @Autowired
    MedicenService medicenService;
    @Autowired
    UserServiceIMP userServiceIMP;


    @GetMapping("/list-medecin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Utilisateur> ListMedecin() throws Exception {
        return medicenService.getAllMedecins();
    }

    @RequestMapping(value = "/signup/medecin/{roleName}", method = RequestMethod.POST)
    public ResponseEntity<Utilisateur> registerMedecin(@Validated @RequestBody Utilisateur p1, @PathVariable ("roleName")String roleName) throws Exception {
        return medicenService.registerMedecin(p1,roleName);
    }




}
