package com.test.Inoteqia.Controllers;
import com.test.Inoteqia.DTO.ResetPass;
import com.test.Inoteqia.DTO.RoleName;
import com.test.Inoteqia.Entity.Role;
import com.test.Inoteqia.Entity.Utilisateur;
import com.test.Inoteqia.Reposotories.RoleRepository;
import com.test.Inoteqia.Reposotories.UtilisateurRepository;
import com.test.Inoteqia.ServiceIMP.UserServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {

@Autowired
UserServiceIMP userServiceIMP;
@Autowired
UtilisateurRepository utilisateurRepository;
@Autowired
    RoleRepository roleRepository;

    @GetMapping("/list-user")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Utilisateur> ListUser() {
        return userServiceIMP.getAllUser();
    }
    @PutMapping("/validate-user/{idUser}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void validInscription(@PathVariable("idUser") Long idUser) {
        userServiceIMP.validInscription(idUser);
    }

    @PutMapping("/bloque-user/{idUser}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void bloqueUser(@PathVariable("idUser") Long idUser) throws Exception {
        userServiceIMP.bloqueUser(idUser);
    }

    @DeleteMapping("/delete-user/{idUser}")
    public void deleteAccount(@PathVariable("idUser") Long idUser) {
        userServiceIMP.deleteUser(idUser);
    }

    @GetMapping("/list-userByRolesName/{RolesName}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Utilisateur> ListUserByRoles(@PathVariable("RolesName") RoleName roleName) {
        return userServiceIMP.getUserByRoles(roleName);
    }

    @PutMapping("/addRole/{RolesName}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public  void addRole(@PathVariable("RolesName") RoleName roleName){
        Role role=new Role();
        role.setName(roleName);
        roleRepository.save(role);
    }
    @PutMapping("forgetpass/{username}")
    public ResponseEntity<?> forgetPassword(@PathVariable("username") String username, @RequestBody ResetPass resetPass) {
        return userServiceIMP.updatePassword(username,resetPass);
    }
    @PostMapping("forgetpassword/{email}")
    public ResponseEntity<?> userForgetPassword(@PathVariable("email") String email) {
        return userServiceIMP.userforgetpassword(email);
    }
    @PutMapping("forgetpassbyemail/{email}")
    public ResponseEntity<?> forgetPasswordbyemail(@PathVariable("email") String email, @RequestBody ResetPass resetPass) {
        return userServiceIMP.updatePasswordBymail(email,resetPass);
    }





}
