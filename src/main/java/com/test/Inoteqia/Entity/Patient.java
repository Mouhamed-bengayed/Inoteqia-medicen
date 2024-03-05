package com.test.Inoteqia.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Patient extends Utilisateur{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Medecin medecin;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "patient")
    private List<Consultations> consultations;




    public Patient(String name, String username, String email, String password, boolean blocked, String address, boolean valid) {

       super(name,username,email,password,blocked,address,valid);

    }


    public Patient() {

    }
}
