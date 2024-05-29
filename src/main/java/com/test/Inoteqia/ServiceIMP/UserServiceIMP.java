package com.test.Inoteqia.ServiceIMP;


import com.test.Inoteqia.DTO.ResetPass;
import com.test.Inoteqia.DTO.RoleName;
import com.test.Inoteqia.Entity.Role;
import com.test.Inoteqia.Entity.Utilisateur;
import com.test.Inoteqia.Interfaces.OTPInterface;
import com.test.Inoteqia.Interfaces.UserServiceInterface;
import com.test.Inoteqia.Reposotories.RoleRepository;
import com.test.Inoteqia.Reposotories.UtilisateurRepository;
import com.test.Inoteqia.Services.CryptDecrypt;
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
public class UserServiceIMP implements UserServiceInterface {

    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    MailSenderService mailSending;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    CryptDecrypt cryptDecrypt;
    @Autowired
    OTPInterface otpInterface;


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


    public void bloqueUser(Long id) throws Exception {
        Optional<Utilisateur> user = utilisateurRepository.findById(id);
        Utilisateur user1 = user.get();
        String Newligne = System.getProperty("line.separator");
        String body = "compte bloque\n  use this link to verify your account is :" + Newligne ;
        String ms=cryptDecrypt.decryptSensitiveInformation(user1.getEmail());

        if (user.isPresent()) {

            user1.setValid(false);
            this.utilisateurRepository.save(user1);
            try {
                mailSending.send(ms, "bloque ", body);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }



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
    public ResponseEntity<Utilisateur> registerAdmin(@Valid @RequestBody Utilisateur user) {
        if (utilisateurRepository.existsByUsername(user.getUsername())) {
            return new ResponseEntity<Utilisateur>(HttpStatus.NOT_FOUND);
        }
        if (UtilisateurRepository.existsByEmail(user.getEmail())) {
            return new ResponseEntity<Utilisateur>(HttpStatus.NOT_FOUND);
        }
        String token = UUID.randomUUID().toString().replace("-", "");
        Utilisateur user1 = new Utilisateur(user.getName(), user.getUsername(), user.getEmail(), passwordEncoder.encode(user.getPassword()), false, user.getAddresse(), false);
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
    public ResponseEntity<?> userforgetpassword(String email) {
        Optional<Utilisateur> user = utilisateurRepository.findByEmail(email);
        if (user.isPresent()) {
            // String url = "http://localhost:4200/#/verifCaptch" ;
            String verificationCode = otpInterface.GenerateOTp().getIdentification();
            String newLine = "<br/>"; // HTML line break
            String htmlMessage = "<div style='border: 1px solid #ccc; padding: 10px; margin-bottom: 10px;'>"
                    + "Une tentative de Reset du Password à été effectuer " + newLine
                    //+ "Veuillez utiliser ce lien pour vous authentifier : " + newLine
                    //  + "<a href='" + url + "'>" + url + "</a>" + newLine
                    + "<strong>Verification Code:</strong> " + verificationCode + newLine
                    + "</div>";
            try {
                mailSending.send(user.get().getEmail(), "Did you Forget your password ?"+ user.get().getName() , htmlMessage);
                return new ResponseEntity<>( HttpStatus.OK);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public  ResponseEntity<?>  updatePassword(String username, ResetPass updatePasswordDto) {
        Optional<Utilisateur> user = utilisateurRepository.findByUsername(username);
        if (user.isPresent()) {
            String storedHashedPassword = user.get().getPassword();
            if (passwordEncoder.matches(updatePasswordDto.getOldPassword(), storedHashedPassword)) {
                user.get().setPassword(passwordEncoder.encode(updatePasswordDto.getNewPassword()));
                utilisateurRepository.save(user.get());
                return new ResponseEntity<>(HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    public  ResponseEntity<?>  updatePasswordBymail(String email, ResetPass updatePasswordDto) {
        Optional<Utilisateur> user = utilisateurRepository.findByEmail(email);
        if (user.isPresent()) {
            Boolean verif = otpInterface.VerifOTP(updatePasswordDto.getCode());
            if (verif == false) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            else {
                user.get().setPassword(passwordEncoder.encode(updatePasswordDto.getNewPassword()));
                utilisateurRepository.save(user.get());
                return new ResponseEntity<>(HttpStatus.OK);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

}



