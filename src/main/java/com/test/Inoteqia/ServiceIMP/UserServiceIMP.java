package com.test.Inoteqia.ServiceIMP;


import com.test.Inoteqia.DTO.RoleName;
import com.test.Inoteqia.Entity.Role;
import com.test.Inoteqia.Entity.Utilisateur;
import com.test.Inoteqia.Interfaces.UserServiceInterface;
import com.test.Inoteqia.Reposotories.RoleRepository;
import com.test.Inoteqia.Reposotories.UtilisateurRepository;
import com.test.Inoteqia.Services.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.*;

@Service
public class
UserServiceIMP implements UserServiceInterface {

    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    MailSenderService mailSending;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;


    public List<Utilisateur> getAllUser() {
        return utilisateurRepository.findAll();
    }


    public Utilisateur getUserById(Long idUser) {
        return utilisateurRepository.findById(idUser).orElseThrow(() -> new IllegalArgumentException("Provider ID not Found"));
    }

    public List<Utilisateur> getUserByRoles(RoleName roleName){
        Role role= roleRepository.findByName(roleName).get();
        return utilisateurRepository.findByRolesContains(role);
    }

    public Utilisateur deleteUser(Long id) {
        Optional<Utilisateur> user = utilisateurRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }


    public void bloqueUser(Long id) {
        Optional<Utilisateur> user = utilisateurRepository.findById(id);
        Utilisateur user1 = user.get();
        String Newligne = System.getProperty("line.separator");
        String url = "http://localhost:4200/auth/verification/" + user1.getToken();
        String body = "compte bloque\n  use this link to verify your account is :" + Newligne + url;
        if (user.isPresent()) {

            user1.setValid(false);
            this.utilisateurRepository.save(user1);
            try {
                mailSending.send(user1.getEmail(), "bloque ", body);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

/*
    public List<Utilisateur> getUsersOrderBySum_totalAsc(){
        return utilisateurRepository.findUsersOrderByBilanSum_totalAsc();
    }
    public List<Utilisateur> getAllUserByRoleOrderSum_total(RoleName role) {
        return utilisateurRepository.findAllUserByRoleOrderSum_total(role);
    }
*/

    public void validInscription(Long id) {
        Optional<Utilisateur> user = utilisateurRepository.findById(id);
        Utilisateur user1 = user.get();
        String Newligne = System.getProperty("line.separator");
        String url = "http://localhost:4200/auth/verification/" + user1.getToken();
        String body = "Soyez le bienvenue dans notre platforme ECOtalan  \n  veuillez utuliser ce lien là pour s'authentifier :" + Newligne + url + Newligne + "verification" +
                "Voici votre code de verfication  TN1122" ;
        if (user.isPresent()) {

            user1.setValid(true);
            this.utilisateurRepository.save(user1);
            try {
                mailSending.send(user1.getEmail(), "Welcome Provaider", body);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public ResponseEntity<Utilisateur> registerUser(Utilisateur user1, String roleName) {
        if (utilisateurRepository.existsByUsername(user1.getUsername())) {
            return new ResponseEntity<Utilisateur>(HttpStatus.NOT_FOUND);
        }
        if (utilisateurRepository.existsByEmail(user1.getEmail())) {
            return new ResponseEntity<Utilisateur>(HttpStatus.BAD_REQUEST);
        }
        Utilisateur user = new Utilisateur(user1.getName(), user1.getUsername(), user1.getEmail(), passwordEncoder.encode(user1.getPassword()), false, user1.getAddress(), false);
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(RoleName.valueOf(roleName.trim()))
                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: Utilisateur Role not find."));
        roles.add(userRole);
        user.setRoles(roles);
        user.setValid(true);
        Utilisateur suser = utilisateurRepository.save(user);
        if (suser != null) {
            //String Newligne = System.getProperty("line.separator");
            String url = "http://localhost:4200/#/verification" ;
            String verificationCode = "TN1122"; // Replace with your actual verification code
            String newLine = "<br/>"; // HTML line break
            String htmlMessage = "<div style='border: 1px solid #ccc; padding: 10px; margin-bottom: 10px;'>"
                    + "Soyez le bienvenue dans notre plateforme" + newLine
                    + "Veuillez utiliser ce lien pour vous authentifier : " + newLine
                    + "<a href='" + url + "'>" + url + "</a>" + newLine
                    + "<strong>Verification Code:</strong> " + verificationCode + newLine
                    + "</div>";
            try {
                mailSending.send(user.getEmail(), "Welcome"+ user.getName() , htmlMessage);
                return new ResponseEntity<Utilisateur>(user, HttpStatus.OK);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<Utilisateur> registerEntreprise(Utilisateur user1) {
        if (utilisateurRepository.existsByUsername(user1.getUsername())) {
            return new ResponseEntity<Utilisateur>(HttpStatus.NOT_FOUND);
        }
        if (utilisateurRepository.existsByEmail(user1.getEmail())) {
            return new ResponseEntity<Utilisateur>(HttpStatus.BAD_REQUEST);
        }
        Utilisateur user = new Utilisateur(user1.getName(), user1.getUsername(), user1.getEmail(), passwordEncoder.encode(user1.getPassword()), false, user1.getAddress(), false);
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(RoleName.ROLE_Entreprise)
                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: Utilisateur Role not find."));
        roles.add(userRole);
        user.setRoles(roles);
        user.setValid(true);
        Utilisateur suser = utilisateurRepository.save(user);
        if (suser != null) {
            String Newligne = System.getProperty("line.separator");
            String url = "http://localhost:4200/auth/verification/" + suser.getToken();
            String body = "Soyez le bienvenue dans notre platforme ECOtalan  \n  veuillez utuliser ce lien là pour s'authentifier :" + Newligne + url + Newligne + "verification" +
                    "Voici votre code de verfication  TN1122" ;
            try {
                mailSending.send(user.getEmail(), "Welcome", body);
                return new ResponseEntity<Utilisateur>(user, HttpStatus.OK);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }


    }

    public ResponseEntity<Utilisateur> registerAdmin(@Valid @RequestBody Utilisateur user) {
        if (utilisateurRepository.existsByUsername(user.getUsername())) {
            return new ResponseEntity<Utilisateur>(HttpStatus.NOT_FOUND);
        }
        if (utilisateurRepository.existsByEmail(user.getEmail())) {
            return new ResponseEntity<Utilisateur>(HttpStatus.NOT_FOUND);
        }
        String token = UUID.randomUUID().toString().replace("-", "");
        Utilisateur user1 = new Utilisateur(user.getName(), user.getUsername(), user.getEmail(), passwordEncoder.encode(user.getPassword()), false, user.getAddress(), false);
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: Utilisateur Role not find."));
        roles.add(userRole);
        user1.setRoles(roles);
        utilisateurRepository.save(user1);
        return new ResponseEntity<Utilisateur>(user1, HttpStatus.OK);
    }

    public Optional<Utilisateur> getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return utilisateurRepository.findByUsername(username);
    }

}



