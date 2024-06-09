package com.test.Inoteqia.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff extends Suivi{

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
    private String indication_Arthrodese;
    private String conclusion;

    public Staff(String date, String diagnostic_preop, String indication_Antalgique, String indication_Infiltrations_Nbreinfiltrations, String indication_Reeducation_Nbreseances, String indication_Dissectomie_etage, String indication_Liberation_etage, String indication_Arthrodese, String conclusion) {
        this.date = date;
        this.diagnostic_preop = diagnostic_preop;
        this.indication_Antalgique = indication_Antalgique;
        this.indication_Infiltrations_Nbreinfiltrations = indication_Infiltrations_Nbreinfiltrations;
        this.indication_Reeducation_Nbreseances = indication_Reeducation_Nbreseances;
        this.indication_Dissectomie_etage = indication_Dissectomie_etage;
        this.indication_Liberation_etage = indication_Liberation_etage;
        this.indication_Arthrodese = indication_Arthrodese;
        this.conclusion = conclusion;
    }
}
