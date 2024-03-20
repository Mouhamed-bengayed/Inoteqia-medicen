package com.test.Inoteqia.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Consultations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Dossier_medical;
    private String N_Dossier_médical;
    private String address;
    private String Sexe;
    private String nom;
    private String prenom;
    private String Année_de_naissance;
    private String Origine;
    private String Télephone;
    private String Profession;
    private String Adressé_par;
    private String Statut_social;
    private String Tabac;
    private String ATCD;
    private String Motif_de_consultation;
    private String Localisation;
    private String number;


    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Patient patient;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Medecin medecin;

    public Consultations(String name, String username, String address) {
    }

    public Consultations() {

    }
}
