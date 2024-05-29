package com.test.Inoteqia.Entity;
import lombok.Data;
import javax.persistence.*;



@Entity
@Data
public class Suivi1Post_Immediat extends Suivi{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date_chirurgie;
    private String date_suiui;
    private String  dissectomie_etage;
    private String  liberation_post_etage;
    private String  arthrodese_etage;

    private String  complications_per_operatoire;
    private String  complications_per_operatoire_auter;
    private String  symptomatologie_Lombalgie;
    private String  symptomatologie_Sciatique;
    private String  symptomatologie_Cruralgie;
    private String  symptomatologie_sphinctériens;

    private String examen_Post_Testing_musculaire_l2;
    private String examen_Post_Testing_musculaire_l3;
    private String examen_Post_Testing_musculaire_l4;
    private String examen_Post_Testing_musculaire_l5;
    private String examen_Post_Testing_musculaire_s1;
    private String examen_Post_Sensibilte_musculaire_l2;
    private String examen_Post_Sensibilte_musculaire_l3;
    private String examen_Post_Sensibilte_musculaire_l4;
    private String examen_Post_Sensibilte_musculaire_l5;
    private String examen_Post_Sensibilte_musculaire_s1;
    private String examen_Post_Examen_perinee_sensibilite;
    private String examen_Post_Examen_perinee_Tonus_anal;
    private String examen_Post_Examen_perinee_Reflexe_anal;



    public Suivi1Post_Immediat(String date_chirurgie, String date_suiui, String dissectomie_etage, String liberation_post_etage, String arthrodese_etage, String complications_per_operatoire, String complications_per_operatoire_auter, String symptomatologie_Lombalgie, String symptomatologie_Sciatique, String symptomatologie_Cruralgie, String symptomatologie_sphinctériens, String examen_Post_Testing_musculaire_l2, String examen_Post_Testing_musculaire_l3, String examen_Post_Testing_musculaire_l4, String examen_Post_Testing_musculaire_l5, String examen_Post_Testing_musculaire_s1, String examen_Post_Sensibilte_musculaire_l2, String examen_Post_Sensibilte_musculaire_l3, String examen_Post_Sensibilte_musculaire_l4, String examen_Post_Sensibilte_musculaire_l5, String examen_Post_Sensibilte_musculaire_s1, String examen_Post_Examen_perinee_sensibilite, String examen_Post_Examen_perinee_Tonus_anal, String examen_Post_Examen_perinee_Reflexe_anal) {
        this.date_chirurgie = date_chirurgie;
        this.date_suiui = date_suiui;
        this.dissectomie_etage = dissectomie_etage;
        this.liberation_post_etage = liberation_post_etage;
        this.arthrodese_etage = arthrodese_etage;
        this.complications_per_operatoire = complications_per_operatoire;
        this.complications_per_operatoire_auter = complications_per_operatoire_auter;
        this.symptomatologie_Lombalgie = symptomatologie_Lombalgie;
        this.symptomatologie_Sciatique = symptomatologie_Sciatique;
        this.symptomatologie_Cruralgie = symptomatologie_Cruralgie;
        this.symptomatologie_sphinctériens = symptomatologie_sphinctériens;
        this.examen_Post_Testing_musculaire_l2 = examen_Post_Testing_musculaire_l2;
        this.examen_Post_Testing_musculaire_l3 = examen_Post_Testing_musculaire_l3;
        this.examen_Post_Testing_musculaire_l4 = examen_Post_Testing_musculaire_l4;
        this.examen_Post_Testing_musculaire_l5 = examen_Post_Testing_musculaire_l5;
        this.examen_Post_Testing_musculaire_s1 = examen_Post_Testing_musculaire_s1;
        this.examen_Post_Sensibilte_musculaire_l2 = examen_Post_Sensibilte_musculaire_l2;
        this.examen_Post_Sensibilte_musculaire_l3 = examen_Post_Sensibilte_musculaire_l3;
        this.examen_Post_Sensibilte_musculaire_l4 = examen_Post_Sensibilte_musculaire_l4;
        this.examen_Post_Sensibilte_musculaire_l5 = examen_Post_Sensibilte_musculaire_l5;
        this.examen_Post_Sensibilte_musculaire_s1 = examen_Post_Sensibilte_musculaire_s1;
        this.examen_Post_Examen_perinee_sensibilite = examen_Post_Examen_perinee_sensibilite;
        this.examen_Post_Examen_perinee_Tonus_anal = examen_Post_Examen_perinee_Tonus_anal;
        this.examen_Post_Examen_perinee_Reflexe_anal = examen_Post_Examen_perinee_Reflexe_anal;
    }


    public Suivi1Post_Immediat() {

    }
}
