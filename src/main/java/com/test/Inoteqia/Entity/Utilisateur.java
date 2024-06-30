package com.test.Inoteqia.Entity;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String number;
    private String addresse;
    private boolean blockedByAdmin;

    private boolean mailvalid;

    private String Status ;
    private String token;



    @ManyToMany(fetch = FetchType.LAZY)

    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set <Role> roles = new HashSet<>();


    public Utilisateur(String name, String username, String email, String password, boolean blocked, String address, boolean valid) {

        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.addresse = address;




    }


    public Utilisateur(Long id, String name, String username, String email, String password, String number, String addresse, boolean blockedByAdmin, boolean mailvalid, String status, String token, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.number = number;
        this.addresse = addresse;
        this.blockedByAdmin = blockedByAdmin;
        this.mailvalid = mailvalid;
        Status = status;
        this.token = token;
        this.roles = roles;
    }
}
