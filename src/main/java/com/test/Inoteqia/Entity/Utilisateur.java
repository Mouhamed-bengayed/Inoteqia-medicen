package com.test.Inoteqia.Entity;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
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
    private Boolean blocked;
    private boolean valid;
    private String token;


    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set <Role> roles = new HashSet<>();


    public Utilisateur(String name, String username, String email, String password, boolean blocked, String address, boolean valid) {

        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.blocked = blocked;
        this.addresse = address;
        this.valid = valid;



    }

    public Utilisateur() {

    }
}
