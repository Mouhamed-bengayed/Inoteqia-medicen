package com.test.Inoteqia.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medecin extends Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String specialite;

    @OneToMany
    private List<FichePatient> FichePatients=new ArrayList<>();

     public Medecin(String name, String username, String email, String encode, boolean b, String address, boolean b1) {}
}
