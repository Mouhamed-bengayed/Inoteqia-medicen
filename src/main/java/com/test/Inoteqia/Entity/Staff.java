package com.test.Inoteqia.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Staff  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String diagnostic_preop;
    private String indication_Antalgique;
    private String indication_Infiltrations_Nbreinfiltrations ;
    private String indication_Reeducation_Nbreseances;
    private String indication_Dissectomie_etage;
    private String indication_Liberation_etage;
    @ElementCollection
    @CollectionTable(name = "indication_Arthrodese", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "indication_Arthrodese")
    private List<String> indication_Arthrodese;
    private String autreindication_Arthrodese;
    private String conclusion;

    @ManyToOne
    private Medecin medecin;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fiche_patient_id")
//    @JsonManagedReference
    @JsonIgnore

    private FichePatient fichePatient;


    public Staff(String date, String diagnostic_preop, String indication_Antalgique, String indication_Infiltrations_Nbreinfiltrations, String indication_Reeducation_Nbreseances, String indication_Dissectomie_etage, String indication_Liberation_etage, List<String> Indication_Arthrodese, String autreindication_Arthrodese,String conclusion) {
        this.date = date;
        this.diagnostic_preop = diagnostic_preop;
        this.indication_Antalgique = indication_Antalgique;
        this.indication_Infiltrations_Nbreinfiltrations = indication_Infiltrations_Nbreinfiltrations;
        this.indication_Reeducation_Nbreseances = indication_Reeducation_Nbreseances;
        this.indication_Dissectomie_etage = indication_Dissectomie_etage;
        this.indication_Liberation_etage = indication_Liberation_etage;
        this.indication_Arthrodese=Indication_Arthrodese;
        this.autreindication_Arthrodese=autreindication_Arthrodese;
        this.conclusion = conclusion;
    }

    public Staff() {

    }
}
