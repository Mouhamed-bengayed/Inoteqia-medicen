package com.test.Inoteqia.Entity;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Medecin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String specialite;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "medecin")
    private List<Patient> patients=new ArrayList<>();
    @OneToOne
    private Utilisateur utilisateur;
    public Medecin(String name, String username, String email, String encode, boolean b, String address, boolean b1) {}
    public Medecin(){}
}
