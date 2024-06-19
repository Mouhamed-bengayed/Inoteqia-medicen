package com.test.Inoteqia.Entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Patient {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date_de_consultation;
    private String dossierMedical;
    private String n_Dossier_medical;
    private String Dossier_medical_num;
    private String name;
    private String username;
    private String sexe;
    private String annee_de_naissance;
    private String origine;
    private String idPatient;
    private String addresse;
    private String telephone;
    private String profession;
    private String adresse_par;
    private String statut_social;
    private String entourage_actuel;
    private String atcd;
    private String Tabac;
    private String motif_de_consultation;
    private String motif_de_consultation_l;




    @OneToMany
    private List<Consultations> consultations=new ArrayList<>();




    public Patient(String date_de_consultation,String dossierMedical,String n_Dossier_medical,String Dossier_medical_num,String name,String username,String sexe,String annee_de_naissance,String origine,String idPatient,String addresse,String telephone,String profession,String adresse_par,String statut_social,String entourage_actuel,String atcd,String Tabac,String motif_de_consultation,String motif_de_consultation_l) {

        this.date_de_consultation = date_de_consultation;
        this.dossierMedical = dossierMedical;
        this.n_Dossier_medical = n_Dossier_medical;
        this.Dossier_medical_num = Dossier_medical_num;
        this.name = name;
        this.username = username;
        this.sexe = sexe;
        this.annee_de_naissance = annee_de_naissance;
        this.origine = origine;
        this.idPatient = idPatient;
        this.addresse = addresse;
        this.telephone = telephone;
        this.profession = profession;
        this.adresse_par = adresse_par;
        this.statut_social = statut_social;
        this.entourage_actuel = entourage_actuel;
        this.atcd = atcd;
        this.Tabac = Tabac;
        this.motif_de_consultation = motif_de_consultation;
        this.motif_de_consultation_l = motif_de_consultation_l;
    }
    public Patient() {
    }
}
