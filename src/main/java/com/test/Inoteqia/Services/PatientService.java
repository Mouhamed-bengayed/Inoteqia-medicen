package com.test.Inoteqia.Services;

import com.test.Inoteqia.DTO.RoleName;
import com.test.Inoteqia.Entity.Medecin;
import com.test.Inoteqia.Entity.Patient;
import com.test.Inoteqia.Entity.Role;
import com.test.Inoteqia.Entity.Utilisateur;
import com.test.Inoteqia.Exception.ResourceNotFoundException;
import com.test.Inoteqia.Reposotories.PatientRepository;
import com.test.Inoteqia.Reposotories.RoleRepository;
import com.test.Inoteqia.Reposotories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.util.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

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


    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    public ResponseEntity<Utilisateur> registerPatient(Utilisateur p1, String roleName) throws Exception {

        Utilisateur u1 = new Patient(cryptDecrypt.encryptSensitiveInformation(p1.getName()), cryptDecrypt.encryptSensitiveInformation(p1.getUsername()), cryptDecrypt.encryptSensitiveInformation(p1.getEmail()), passwordEncoder.encode(p1.getPassword()), false, cryptDecrypt.encryptSensitiveInformation(p1.getAddress()), false);
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(RoleName.valueOf(roleName.trim()))
                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: Utilisateur Role not find."));
        roles.add(userRole);
        u1.setRoles(roles);
        u1.setValid(true);
        Utilisateur utilisateur = utilisateurRepository.save(u1);
        return new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.OK);
    }

    public List<Utilisateur> getUserByRoles(RoleName roleName) {
        Role role = roleRepository.findByName(roleName).get();
        return utilisateurRepository.findByRolesContains(role);
    }

    public List<Utilisateur> getAllPatients() throws Exception {

        List<Utilisateur> utilisateurs = getUserByRoles(RoleName.valueOf("ROLE_PATIENT"));
        List<Utilisateur> decryptedPatients = new ArrayList<>();
        for (Utilisateur utilisateur : utilisateurs) {
            // Décryptez les données sensibles pour chaque patient
            utilisateur.setName(cryptDecrypt.decryptSensitiveInformation(utilisateur.getName()));
            utilisateur.setUsername(cryptDecrypt.decryptSensitiveInformation(utilisateur.getUsername()));
            utilisateur.setEmail(cryptDecrypt.decryptSensitiveInformation(utilisateur.getEmail()));
            utilisateur.setAddress(cryptDecrypt.decryptSensitiveInformation(utilisateur.getAddress()));
            decryptedPatients.add(utilisateur);
        }
        return decryptedPatients;
    }





/*
 // Update Patient
    public Patient updatePatient(Long id, Patient PatientRequest){
        Patient Patient=patientRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("id Patient " + id + " not found"));
        Patient.setEmail(patientRepository.getEmail());
        Patient.setPrenom(patientRepository.getPrenom());
        Patient.setNom(patientRepository.getNom());
        Patient.setAdresse(patientRepository.getAdresse());
        Patient.setConact(patientRepository.getConact());
        Patient.setSpecialite(patientRepository.getSpecialite());
        Patient updateMedecin=patientRepository.save(medecin);
        return updatePatient;
    }



    // Méthode pour obtenir un patient par son ID
    public Optional<Patient> getPatientById(Long patientId) throws Exception {
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if (patientOptional.isPresent()) {
            Patient patient = patientOptional.get();
            // Décryptez les données sensibles du patient si nécessaire
            patient.setName(decryptSensitiveInformation(patient.getName()));
            patient.setUsername(decryptSensitiveInformation(patient.getUsername()));
            patient.setEmail(decryptSensitiveInformation(patient.getEmail()));
            patient.setAddress(decryptSensitiveInformation(patient.getAddress()));
            return Optional.of(patient);
        } else {
            return Optional.empty();
        }
    }


  */
}












