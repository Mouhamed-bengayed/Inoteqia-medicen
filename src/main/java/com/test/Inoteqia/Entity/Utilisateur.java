package com.test.Inoteqia.Entity;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
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
    //affichage profile
    private String lieu_deducation;
    private Date date_de_naissance;
    private String sexe;
    private String image;
    private String diplome;
    private String descreption_Personelle ;
    private String annee_dexperience;
    ;



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






}
