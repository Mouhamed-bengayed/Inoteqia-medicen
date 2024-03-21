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
            Patient patient1 = new Patient(cryptDecrypt.encryptSensitiveInformation(p1.getDate_de_consultation()), cryptDecrypt.encryptSensitiveInformation(p1.getDossier_médical()), cryptDecrypt.encryptSensitiveInformation(p1.getN_Dossier_médical()), passwordEncoder.encode(p1.getSexe()),cryptDecrypt.encryptSensitiveInformation(p1.getName()), cryptDecrypt.encryptSensitiveInformation(p1.getUsername()), cryptDecrypt.encryptSensitiveInformation(p1.getAnnée_de_naissance()), cryptDecrypt.encryptSensitiveInformation(p1.getOrigine()), cryptDecrypt.encryptSensitiveInformation(p1.getAddresse()), cryptDecrypt.encryptSensitiveInformation(p1.getAddresse()), cryptDecrypt.encryptSensitiveInformation(p1.getNumber()), cryptDecrypt.encryptSensitiveInformation(p1.getProfession()), cryptDecrypt.encryptSensitiveInformation(p1.getAdresse_par()), cryptDecrypt.encryptSensitiveInformation(p1.getStatut_social()), cryptDecrypt.encryptSensitiveInformation(p1.getEntourage_actuel()), cryptDecrypt.encryptSensitiveInformation(p1.getATCD()), cryptDecrypt.encryptSensitiveInformation(p1.getTabac()), cryptDecrypt.encryptSensitiveInformation(p1.getMotif_de_consultation()) );
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
    }
    public List<Patient> getAllPatient() throws Exception {
       /* List<Patient> patients = getUserByRoles(RoleName.valueOf("ROLE_MEDECIN"));*/

         List<Patient> patients = getAllPatient();
        List<Patient> decryptedMedecins = new ArrayList<>();
        for (Patient patient : patients) {
            // Décryptez les données sensibles pour chaque medecin
            patient.setName(cryptDecrypt.decryptSensitiveInformation(patient.getName()));
            patient.setUsername(cryptDecrypt.decryptSensitiveInformation(patient.getUsername()));
            patient.setEmail(cryptDecrypt.decryptSensitiveInformation(patient.getEmail()));
            patient.setAddresse(cryptDecrypt.decryptSensitiveInformation(patient.getAddresse()));
            decryptedMedecins.add(patient);
        }
        return decryptedMedecins;
    }

}













