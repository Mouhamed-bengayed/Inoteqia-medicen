package com.test.Inoteqia.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medecin extends Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String specialite;
private String date;
    @OneToMany
    private List<FichePatient> FichePatients=new ArrayList<>();

    public Medecin(Long id, String name, String username, String email, String password, String number, String addresse, boolean blockedByAdmin, boolean mailvalid, String status, String token, Set<Role> roles, Long id1, String specialite, String date,List<FichePatient> fichePatients) {
        super(id, name, username, email, password, number, addresse, blockedByAdmin, mailvalid, status, token, roles);
        this.id = id1;
        this.specialite = specialite;
        this.date=date;
        FichePatients = fichePatients;
    }

    public Medecin(String name, String username, String email, String encode, boolean b, String address, boolean b1) {}

}
