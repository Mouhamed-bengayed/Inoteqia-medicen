package com.test.Inoteqia.ServiceIMP;


import com.test.Inoteqia.DTO.ResetPass;
import com.test.Inoteqia.DTO.RoleName;
import com.test.Inoteqia.Entity.*;
import com.test.Inoteqia.Interfaces.OTPInterface;
import com.test.Inoteqia.Interfaces.UserServiceInterface;
import com.test.Inoteqia.Reposotories.*;
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
    AdministrateurRepository administrateurRepository;
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

    @Autowired
    MedecinRepository medecinRepository;
    @Autowired
    NotificationRepository notificationRepository;
    public List<Utilisateur> getAllUser() {
        return utilisateurRepository.findAll();
    }


    public Utilisateur getUserById(Long idUser) {
        return utilisateurRepository.findById(idUser).orElseThrow(() -> new IllegalArgumentException("Provider ID not Found"));
    }

    public List<Utilisateur> getUserByRoles(RoleName roleName){
        Role role= roleRepository.findByName(roleName).get();
        List<Utilisateur> users = utilisateurRepository.findByRolesContains(role);
        List<Utilisateur> users1 = new ArrayList<>();
        for(Utilisateur user : users){
           if(user.isMailvalid()){
                users1.add(user);
           }
        }
        return users1;
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
//        String ms=cryptDecrypt.decryptSensitiveInformation(user1.getEmail());
        String ms=user1.getEmail();

        if (user.isPresent()) {

            user1.setBlockedByAdmin(true);
            user1.setStatus("Bloqué");

            this.utilisateurRepository.save(user1);
            try {
                mailSending.send(ms, "bloquage du compte ", body);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void Débloquer(Long id) {
        Optional<Utilisateur> user = utilisateurRepository.findById(id);
        Utilisateur user1 = user.get();
        String Newligne = System.getProperty("line.separator");
//        String url = "http://localhost:4200/auth/verification/" + user1.getToken();
        String body = "Soyez le bienvenue une autre fois  "+ Newligne+"  Votre compte est maintenant débloqué  vous pouvez consulter une autre fois votre espace sur le plateforme"+ Newligne ;
        if (user.isPresent()) {

            user1.setStatus("Activé");
            user1.setBlockedByAdmin(false);
            this.utilisateurRepository.save(user1);
            try {
                mailSending.send(user1.getEmail(), "bienvenue ce compte est débloqué" + user1.getUsername(), body);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public void validInscription(Long id) {
        Optional<Utilisateur> user = utilisateurRepository.findById(id);
        Utilisateur user1 = user.get();
        String Newligne = System.getProperty("line.separator");
//        String url = "http://localhost:4200/auth/verification/" + user1.getToken();
        String body = "Soyez le bienvenue dans notre platforme  "+ Newligne+"  Votre compte est maintenant activé vous pouvez consulter votre espace sur le plateforme"+ Newligne ;
        if (user.isPresent()) {

            user1.setStatus("Activé");
            user1.setValidtologin(true);
            this.utilisateurRepository.save(user1);
            try {
                mailSending.send(user1.getEmail(), "Soyez le bienvenue dans notre platforme" + user1.getUsername(), body);
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
                mailSending.send(user.get().getEmail(), "Avez-Vous  oublié votre  mot de passe  ?"+ user.get().getName() , htmlMessage);
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
    public Utilisateur updateUser(Utilisateur userInfo) {
        Utilisateur user = utilisateurRepository.findById(userInfo.getId()).orElseThrow(() -> new IllegalArgumentException("User ID not Found"));
        user.setName(userInfo.getName());
        user.setUsername(userInfo.getUsername());
        user.setEmail(userInfo.getEmail());
        user.setNumber(userInfo.getNumber());
        user.setAddresse(userInfo.getAddresse());
        user.setLieu_deducation(userInfo.getLieu_deducation());
        user.setDate_de_naissance(userInfo.getDate_de_naissance());
        user.setSexe(userInfo.getSexe());
        user.setDiplome(userInfo.getDiplome());
        user.setDescreption_Personelle(userInfo.getDescreption_Personelle());
        user.setAnnee_dexperience(userInfo.getAnnee_dexperience());
        user.setSpecialite(userInfo.getSpecialite());

        return utilisateurRepository.save(user);
    }
    public Boolean userExists(String email) {
        try {
            Optional<Utilisateur> optionalUser = utilisateurRepository.findByEmail(email);
            if (optionalUser.isPresent()) {
                Utilisateur user = optionalUser.get();
                user.setStatus("En attente de réactivation");
                user.setAskForReactivation(true);
                utilisateurRepository.save(user);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            // Log the exception or handle it as needed
            e.printStackTrace();
            return false;
        }
    }
    public Utilisateur reactiveuser(Long id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        if (utilisateur.isPresent()) {
            Utilisateur user = utilisateur.get();

            user.setBlockedByAdmin(false);
            user.setValidtologin(true);
            user.setAskForReactivation(false);
            user.setStatus("Réactivé");
            return utilisateurRepository.save(user);
        } else {
            return null;
        }
    }
    public Medecin reactiveuserMed(Long id) {
        Optional<Medecin> medecin = medecinRepository.findById(id);
        if (medecin.isPresent()) {
            Medecin user = medecin.get();
            Notification notification = new Notification();
            notification.setDate(new Date());
            notification.setTitle("Demande de ractivation du compte de Dr " + user.getUsername());
            notification.setMessage(" Dr " + user.getUsername()+" a demandé la réactivation de son compte une autre fois." +
                    "Si vous êtes d'accord," + " veuillez cliquer sur le bouton ci-dessous  (réactivater) pour réactiver de " +
                    "nouveau son compte.");
//            user.getAdministrateurs().forEach(admin->{
//               notification.getAdministrateurs().add(admin);
//            });
            notificationRepository.save(notification);
            user.setBlockedByAdmin(false);
            user.setValidtologin(true);
            user.setAskForReactivation(false);
            user.setStatus("Réactivé");
            return medecinRepository.save(user);
        } else {
            return null;
        }
    }
    @Override
    public Medecin AffctAdmintoMed(Long id, Long idAdmin) {
        Optional<Utilisateur> medecin = utilisateurRepository.findById(id);
        Optional<Utilisateur> admin = utilisateurRepository.findById(idAdmin);
        if (medecin.isPresent() && admin.isPresent()) {
            Medecin med =(Medecin) medecin.get();
            Administrateur adm = (Administrateur) admin.get();
//            med.getAdministrateurs().add(adm);
            return utilisateurRepository.save(med);
        } else {
            return null;
        }
    }
}



