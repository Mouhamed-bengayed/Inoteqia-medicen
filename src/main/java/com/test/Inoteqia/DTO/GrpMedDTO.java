package com.test.Inoteqia.DTO;
import java.util.Date;
import java.util.List;
public class GrpMedDTO {
    private String titre;
    private String description;
    private List<Long> medecins;
    private Date date;

    // Getters and Setters
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getMedecins() {
        return medecins;
    }

    public void setMedecins(List<Long> medecins) {
        this.medecins = medecins;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}