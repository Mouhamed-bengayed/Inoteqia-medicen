package com.test.Inoteqia.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public  class Consultations implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dateConsultation;

    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Medecin medecin;

    @ManyToOne
    private Administrateur administrateur;

}
