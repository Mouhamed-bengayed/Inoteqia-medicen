package com.test.Inoteqia.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Ttttt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Patient patient;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Medecin medecin;

    public Ttttt() {
    }


}
