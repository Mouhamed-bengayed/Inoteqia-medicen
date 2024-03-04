package com.test.Inoteqia.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.*;
import java.util.Base64;
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


    public Patient(String encryptSensitiveInformation, String encryptSensitiveInformation1, String encryptSensitiveInformation2, String encode, boolean b, String encryptSensitiveInformation3, boolean b1) {
    }
}
