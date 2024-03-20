package com.test.Inoteqia.Services;

import com.test.Inoteqia.DTO.RoleName;
import com.test.Inoteqia.Entity.Medecin;
import com.test.Inoteqia.Entity.Role;
import com.test.Inoteqia.Entity.Utilisateur;
import com.test.Inoteqia.Exception.ResourceNotFoundException;
import com.test.Inoteqia.Interfaces.OTPInterface;
import com.test.Inoteqia.Reposotories.MedecinRepository;
import com.test.Inoteqia.Reposotories.RoleRepository;
import com.test.Inoteqia.Reposotories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class MedicenService {

    @Autowired
    MailSenderService mailSending;
    @Autowired
    MedecinRepository medecinRepository;
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
@Autowired
CryptDecrypt cryptDecrypt;
@Autowired
    OTPInterface otpInterface;


    // find  All Medecin
    /*
    public List<Medecin> getAllMedecin() {
        List<Medecin> medecins=medecinRepository.findAll();
        List<Medecin> medecins1=new ArrayList<>();

        for (Medecin medecin:medecins) {
            if (medecin.getBlocked().equals(true)){
                medecins1.add(medecin);
            }
        }
        return medecins1;
    }
*/
    public List<Utilisateur> getUserByRoles(RoleName roleName){
        Role role= roleRepository.findByName(roleName).get();
        return utilisateurRepository.findByRolesContains(role);
    }

    public List<Utilisateur> getAllMedecins() throws Exception {
        List<Utilisateur> utilisateurs = getUserByRoles(RoleName.valueOf("ROLE_MEDECIN"));
        List<Utilisateur> decryptedMedecins = new ArrayList<>();
        for (Utilisateur utilisateur : utilisateurs) {
            // Décryptez les données sensibles pour chaque medecin
            utilisateur.setName(cryptDecrypt.decryptSensitiveInformation(utilisateur.getName()));
            utilisateur.setUsername(cryptDecrypt.decryptSensitiveInformation(utilisateur.getUsername()));
            utilisateur.setEmail(cryptDecrypt.decryptSensitiveInformation(utilisateur.getEmail()));
            utilisateur.setAddresse(cryptDecrypt.decryptSensitiveInformation(utilisateur.getAddresse()));
            decryptedMedecins.add(utilisateur);
        }
        return decryptedMedecins;
    }

    // fiind  Medecin By Id
    public Medecin getMedecinById(Long idMedecin) {
        return medecinRepository.findById(idMedecin).
                orElseThrow(() -> new ResourceNotFoundException("id Medecin " + idMedecin + " not found"));
    }
    // Delete Medecin
    public ResponseEntity<?> deleteMed(Long id){
        Medecin medecin=getMedecinById(id);
        medecinRepository.delete(medecin);
        return ResponseEntity.ok().build();
    }

/*
    public ResponseEntity<Utilisateur> registerMe(Utilisateur m1, String roleName) throws Exception {
        if (UtilisateurRepository.existsByEmail(m1.getEmail())) {
            return new ResponseEntity<Utilisateur>(HttpStatus.BAD_REQUEST);
        }
        Utilisateur utilisateur = new Utilisateur(cryptDecrypt.encryptSensitiveInformation(m1.getName()), cryptDecrypt.encryptSensitiveInformation(m1.getUsername()), cryptDecrypt.encryptSensitiveInformation(m1.getEmail()), passwordEncoder.encode(m1.getPassword()), false, cryptDecrypt.encryptSensitiveInformation(m1.getAddress()), false);
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(RoleName.valueOf(roleName.trim()))
                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
        roles.add(userRole);
        utilisateur.setRoles(roles);
        utilisateur.setValid(false);
        Utilisateur suser = utilisateurRepository.save(utilisateur);
        if (suser != null) {
            String Newligne = System.getProperty("line.separator");
            String body = "Soyez le bienvenue dans notre platforme ECOtalan  \n  merci pour votre inscription vous attendre l'activation de votre cante apartier de admin" ;
            try {
                mailSending.send(utilisateur.getEmail(), "Welcome", body);
                return new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.OK);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }
*/

    public ResponseEntity<Utilisateur> registerMedecin(Utilisateur user1, String roleName) throws Exception {
        if (UtilisateurRepository.existsByEmail(user1.getEmail())) {
            return new ResponseEntity<Utilisateur>(HttpStatus.BAD_REQUEST);
        }
        Utilisateur utilisateur = new Utilisateur(user1.getName(), user1.getUsername(), user1.getEmail(), user1.getPassword(), false, user1.getAddresse(), false);
     /*   Utilisateur utilisateur = new Utilisateur(cryptDecrypt.encryptSensitiveInformation(user1.getName()), cryptDecrypt.encryptSensitiveInformation(user1.getUsername()), cryptDecrypt.encryptSensitiveInformation(user1.getEmail()), passwordEncoder.encode(user1.getPassword()), false, cryptDecrypt.encryptSensitiveInformation(user1.getAddresse()), false);*/

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(RoleName.valueOf(roleName.trim())).orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
        roles.add(userRole);
        utilisateur.setRoles(roles);
        utilisateur.setValid(false);
        Utilisateur suser = utilisateurRepository.save(utilisateur);
        if (suser != null) {
            //String Newligne = System.getProperty("line.separator");
            String url = "http://localhost:4200/#/verification" ;
            String verificationCode = otpInterface.GenerateOTp().getIdentification(); // Replace with your actual verification code
            String newLine = "<br/>"; // HTML line break
            String htmlMessage = "<div style='border: 1px solid #ccc; padding: 10px; margin-bottom: 10px;'>"
                    + "Soyez le bienvenue dans notre plateforme" + newLine
                    + "Veuillez utiliser ce lien pour vous authentifier : " + newLine
                    + "<a href='" + url + "'>" + url + "</a>" + newLine
                    + "<strong>Verification Code:</strong> " + verificationCode + newLine
                    + "</div>";
            /*String ms=cryptDecrypt.decryptSensitiveInformation(utilisateur.getEmail());*/
            String ms=utilisateur.getEmail();


            try {
                mailSending.send(ms, "Welcome"+ utilisateur.getName() , htmlMessage);
                return new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.OK);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }



}
