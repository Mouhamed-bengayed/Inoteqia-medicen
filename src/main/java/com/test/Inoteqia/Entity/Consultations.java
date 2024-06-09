package com.test.Inoteqia.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@MappedSuperclass
public abstract class Consultations implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Patient patient;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Medecin medecin;

}
