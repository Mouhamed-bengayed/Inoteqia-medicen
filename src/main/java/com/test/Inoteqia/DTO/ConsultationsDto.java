package com.test.Inoteqia.DTO;

import java.time.LocalDateTime;
import java.util.List;

public class ConsultationsDto {

    private LocalDateTime date_de_consultation;
    private String age;
    private String addresse;
    private String telephone;
    private String profession;
    private String statut_social;
    private String entourage_actuel;
    private String atcd;
    private String tabac;
    private String evolution;
    private List<String> evolution_nouvelles_symptomatologies;
    private int resultatodi;

    // Getters and Setters

    public LocalDateTime getDate_de_consultation() {
        return date_de_consultation;
    }

    public void setDate_de_consultation(LocalDateTime date_de_consultation) {
        this.date_de_consultation = date_de_consultation;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getStatut_social() {
        return statut_social;
    }

    public void setStatut_social(String statut_social) {
        this.statut_social = statut_social;
    }

    public String getEntourage_actuel() {
        return entourage_actuel;
    }

    public void setEntourage_actuel(String entourage_actuel) {
        this.entourage_actuel = entourage_actuel;
    }

    public String getAtcd() {
        return atcd;
    }

    public void setAtcd(String atcd) {
        this.atcd = atcd;
    }

    public String getTabac() {
        return tabac;
    }

    public void setTabac(String tabac) {
        this.tabac = tabac;
    }

    public String getEvolution() {
        return evolution;
    }

    public void setEvolution(String evolution) {
        this.evolution = evolution;
    }

    public List<String> getEvolution_nouvelles_symptomatologies() {
        return evolution_nouvelles_symptomatologies;
    }

    public void setEvolution_nouvelles_symptomatologies(List<String> evolution_nouvelles_symptomatologies) {
        this.evolution_nouvelles_symptomatologies = evolution_nouvelles_symptomatologies;
    }

    public int getResultatodi() {
        return resultatodi;
    }

    public void setResultatodi(int resultatodi) {
        this.resultatodi = resultatodi;
    }
}
