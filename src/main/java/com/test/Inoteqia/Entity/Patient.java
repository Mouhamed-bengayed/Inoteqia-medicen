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
    private String Date_de_consultation;
    private String dossier_médical;
    private String n_Dossier_médical;
    private String dexe;
    private String année_de_naissance;
    private int Télephone;
    private String origine;
    private String profession;
    private String adresse_par;
    private String statut_social;
    private String entourage_actuel;
    private String aTCD;
    private String tabac;
    private String motif_de_consultation;



    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Medecin medecin;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "patient")
    private List<Consultations> consultations;




    public Patient(String name, String username, String email, String password, boolean blocked, String address,  boolean valid) {

       super(name,username,email,password,blocked,address,valid);

    }


    public Patient() {

    }



}
