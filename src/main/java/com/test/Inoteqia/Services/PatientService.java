package com.test.Inoteqia.Services;
import com.test.Inoteqia.DTO.RoleName;
import com.test.Inoteqia.Entity.Medecin;
import com.test.Inoteqia.Entity.Patient;
import com.test.Inoteqia.Entity.Role;
import com.test.Inoteqia.Entity.Utilisateur;
import com.test.Inoteqia.Interfaces.OTPInterface;

import com.test.Inoteqia.Exception.ResourceNotFoundException;
import com.test.Inoteqia.Reposotories.MedecinRepository;
import com.test.Inoteqia.Reposotories.PatientRepository;
import com.test.Inoteqia.Reposotories.RoleRepository;
import com.test.Inoteqia.Reposotories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.*;


@Service
public class PatientService {

    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    CryptDecrypt cryptDecrypt;
    @Autowired
    MedecinRepository medecinRepository;




    public ResponseEntity<Patient> registerPatient(Patient p1,long id) throws Exception {
        Medecin medecin = medecinRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("id Patient " + id + " not found"));
        if (medecin != null) {
            Patient patient1 = new Patient(cryptDecrypt.encryptSensitiveInformation(p1.getName()), cryptDecrypt.encryptSensitiveInformation(p1.getUsername()), cryptDecrypt.encryptSensitiveInformation(p1.getEmail()), passwordEncoder.encode(p1.getPassword()), false, cryptDecrypt.encryptSensitiveInformation(p1.getAddresse()), false);
            patient1.setValid(true);
            Set<Role> roles = new HashSet<>();
            Role userRole = roleRepository.findByName(RoleName.valueOf("ROLE_PATIENT".trim())).orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
            roles.add(userRole);
            patient1.setRoles(roles);
            patient1.getMedecin().setId(id);
            Patient pat1 = patientRepository.save(p1);
            return new ResponseEntity<Patient>(pat1, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }}













