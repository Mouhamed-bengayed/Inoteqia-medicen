package com.test.Inoteqia.Entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Fiche_patient extends Consultations{
    private String Date_de_début_de_la_maladie;
    private String Facteurs_déclanchants;
    private String Date_de_la_1ére_consultation_médicale;
    private String Les_médecins_traitants;





}
