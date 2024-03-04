package com.test.Inoteqia.Services;

import com.test.Inoteqia.DTO.RoleName;
import com.test.Inoteqia.Entity.Medecin;
import com.test.Inoteqia.Entity.Role;
import com.test.Inoteqia.Exception.ResourceNotFoundException;
import com.test.Inoteqia.Reposotories.MedecinRepository;
import com.test.Inoteqia.Reposotories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

public class MedicenService {

    @Autowired
    MailSenderService mailSending;
    @Autowired
    MedecinRepository medecinRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;



    // fiind  All Medecin
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

    // fiind  Medecin By Id
    public Medecin getMedecinById(Long idMedecin)
    {
        return medecinRepository.findById(idMedecin).
                orElseThrow(() -> new ResourceNotFoundException("id Medecin " + idMedecin + " not found"));
    }
    // Delete Medecin
    public ResponseEntity<?> deleteMed(Long id){
        Medecin medecin=getMedecinById(id);
        medecinRepository.delete(medecin);
        return ResponseEntity.ok().build();
    }

    public void validInscription(Long id) {
        Optional<Medecin> medecin = medecinRepository.findById(id);
        Medecin medecin1 = medecin.get();
        String Newligne = System.getProperty("line.separator");
        String url = "http://localhost:4200/auth/verification/" +medecin1.getToken();
        String body = "Soyez le bienvenue dans notre platforme ECOtalan  \n  veuillez utuliser ce lien là pour s'authentifier :" + Newligne + url + Newligne + "verification" +
                "Voici votre code de verfication  TN1122" ;
        if (medecin.isPresent()) {

            medecin1.setValid(true);
            this.medecinRepository.save(medecin1);
            try {
                mailSending.send(medecin1.getEmail(), "Welcome Pa", body);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public ResponseEntity<Medecin> registerMedecin(Medecin m1) {
        if (medecinRepository.existsByEmail(m1.getEmail())) {
            return new ResponseEntity<Medecin>(HttpStatus.BAD_REQUEST);
        }
        Medecin medecin = new Medecin(m1.getName(), m1.getUsername(), m1.getEmail(), passwordEncoder.encode(m1.getPassword()), false, m1.getAddress(), false);
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(RoleName.ROLE_Employee)
                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
        roles.add(userRole);
        medecin.setRoles(roles);
        medecin.setValid(true);
        Medecin suser = medecinRepository.save(medecin);
        if (suser != null) {
            String Newligne = System.getProperty("line.separator");
            String url = "http://localhost:4200/#/verification" ;
            String body = "Soyez le bienvenue dans notre platforme ECOtalan  \n  veuillez utuliser ce lien là pour s'authentifier :" + Newligne + url + Newligne + "verification" +
                    "Voici votre code de verfication  TN1122" ;
            try {
                mailSending.send(medecin.getEmail(), "Welcome", body);
                return new ResponseEntity<Medecin>(medecin, HttpStatus.OK);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }


}
