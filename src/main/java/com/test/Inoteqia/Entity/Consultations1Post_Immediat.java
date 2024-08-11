package com.test.Inoteqia.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "suivi_Post_Immediatt")

@Data
public class Consultations1Post_Immediat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date_chirurgie;
    private String date_suivi;
    private String  dissectomie_etage;
    private String  liberation_post_etage;
    @ElementCollection
    @CollectionTable(name = "patient_arthrodese_etage", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "arthrodese_etage")
    private List<String>  arthrodese_etage;
    private String  complications_per_operatoire;
    private String  complications_per_operatoire_auter;

    private String lombalgie;
    private String sciatique;
    private String cruralgie;

    @ElementCollection
    @CollectionTable(name = "patient_sphincteriens", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "trouble_vesico_sphincteriens")
    private List<String> trouble_vesico_sphincteriens;

    private String trouble_vesico_sphincteriens_Incontinence_urinaire;

    private String testing_musculaire_l2;
    private String testing_musculaire_l3;
    private String testing_musculaire_l4;
    private String testing_musculaire_l5;
    private String testing_musculaire_s1;
    private String sensibilte_musculaire_l2;
    private String sensibilte_musculaire_l3;
    private String sensibilte_musculaire_l4;
    private String sensibilte_musculaire_l5;
    private String sensibilte_musculaire_s1;
    private String examen_perinee_sensibilite;
    private String examen_perinee_Tonus_anal;
    private String examen_perinee_Reflexe_anal;
    @ManyToOne
    private Medecin medecin;
// In Consultations1Post_Immediat.java
@ManyToOne( fetch = FetchType.LAZY)
@JoinColumn(name = "fiche_patient_id")
@JsonIgnore
private FichePatient fichePatient;


    public Consultations1Post_Immediat(String date_chirurgie, String date_suivi, String dissectomie_etage, String liberation_post_etage, List<String> arthrodese_etage, String complications_per_operatoire, String complications_per_operatoire_auter, String lombalgie, String sciatique, String cruralgie, List<String> trouble_vesico_sphincteriens, String trouble_vesico_sphincteriens_Incontinence_urinaire, String testing_musculaire_l2, String testing_musculaire_l3, String testing_musculaire_l4, String testing_musculaire_l5, String testing_musculaire_s1, String sensibilte_musculaire_l2, String sensibilte_musculaire_l3, String sensibilte_musculaire_l4, String sensibilte_musculaire_l5, String sensibilte_musculaire_s1, String examen_perinee_sensibilite, String examen_perinee_Tonus_anal, String examen_perinee_Reflexe_anal) {
        this.date_chirurgie = date_chirurgie;
        this.date_suivi = date_suivi;
        this.dissectomie_etage = dissectomie_etage;
        this.liberation_post_etage = liberation_post_etage;
        this.arthrodese_etage = arthrodese_etage;
        this.complications_per_operatoire = complications_per_operatoire;
        this.complications_per_operatoire_auter = complications_per_operatoire_auter;
        this.lombalgie = lombalgie;
        this.sciatique = sciatique;
        this.cruralgie = cruralgie;
        this.trouble_vesico_sphincteriens = trouble_vesico_sphincteriens;
        this.trouble_vesico_sphincteriens_Incontinence_urinaire = trouble_vesico_sphincteriens_Incontinence_urinaire;
        this.testing_musculaire_l2 = testing_musculaire_l2;
        this.testing_musculaire_l3 = testing_musculaire_l3;
        this.testing_musculaire_l4 = testing_musculaire_l4;
        this.testing_musculaire_l5 = testing_musculaire_l5;
        this.testing_musculaire_s1 = testing_musculaire_s1;
        this.sensibilte_musculaire_l2 = sensibilte_musculaire_l2;
        this.sensibilte_musculaire_l3 = sensibilte_musculaire_l3;
        this.sensibilte_musculaire_l4 = sensibilte_musculaire_l4;
        this.sensibilte_musculaire_l5 = sensibilte_musculaire_l5;
        this.sensibilte_musculaire_s1 = sensibilte_musculaire_s1;
        this.examen_perinee_sensibilite = examen_perinee_sensibilite;
        this.examen_perinee_Tonus_anal = examen_perinee_Tonus_anal;
        this.examen_perinee_Reflexe_anal = examen_perinee_Reflexe_anal;
    }

    public Consultations1Post_Immediat() {

    }


}
