package com.test.Inoteqia.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupeMed {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date Date;
    private String Description;
    @OneToMany
    private List<Medecin> medecins=new ArrayList<>();

}
