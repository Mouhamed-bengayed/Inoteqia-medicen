package com.test.Inoteqia.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Suivis {
    @Id
    @GeneratedValue
            (strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Patient patient;
    @OneToOne
    private Staff Staff;
    @OneToMany
    private List<Consultations1Post_Immediat> Consultations1Post_Immediat=new ArrayList<>();
    @OneToMany
    private List<Consultations_ttt_Dissect> Consultations_ttt_Dissect=new ArrayList<>();
    @OneToMany
    private List<ConsultationsArthrodese> ConsultationsArthrodese=new ArrayList<>();
}
