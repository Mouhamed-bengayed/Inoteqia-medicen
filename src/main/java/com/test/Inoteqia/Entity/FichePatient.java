package com.test.Inoteqia.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class FichePatient  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date_de_consultation;
    private String dossierMedical;
    private String n_Dossier_medical;
    private String Dossier_medical_num;
    private String name;
    private String username;
    private String sexe;
    private String annee_de_naissance;
    private String origine;
    private String idPatient;
    private String addresse;
    private String telephone;
    private String profession;
    private String adresse_par;
    private String statut_social;
    private String entourage_actuel;
    private String atcd;
    private String Tabac;
    private String motif_de_consultation;
    private String motif_de_consultation_l;

    private String aucn;
    private String date_debut_maladie;
    private String depuis;
    private String facture_declanchants;
    private String Date_1consultation_medicale;
    private String Date_1consultation_specialisee;
    private String medecin_de_traitants;
    private String medecins_traitants;
    private String traitants_anterieur;
    private String Nbre_infiltration;
    private String Nbre_seances;
    private String evalution;
    private String n_symptomatologies;
    private String indication_chirurgicale;
    private String date;

    private String poids;
    private String taille;
    private String bMI;
    private String deformation_rachidienne;
    private String douleur_pression_lombairer_epineuses;
    private String Amelioration_flexion_rachis;
    private String Contracture_muscles_paravertebraux;
    private String dMS;
    private String sonnette;
    private String sonnette_Niveau;
    private String lasegue;
    private String lasegue_controlateral;
    private String leri;
    private String indice_shober;
    private String rOT_Rotulien;
    private String rOT_Achillien;
    private String rOT_Perinee;

    private String marche_talons;
    private String marche_pointes_pieds;
    private String testing_musculaire_L2;
    private String testing_musculaire_L3;
    private String testing_musculaire_L4;
    private String testing_musculaire_L5;
    private String testing_musculaire_S1;
    private String Sensibilte_L2;
    private String Sensibilte_L3;
    private String Sensibilte_L4;
    private String Sensibilte_L5;
    private String Sensibilte_S1;
    private String examen_perinee_sensibilite;
    private String examen_perinee_Tonus_anal;
    private String examen_perinee_Reflexe_anal ;
    private String intensite_douleur;
    private String soins_personnels;
    private String levee;
    private String marche;
    private String assis;
    private String debout;
    private String sommeil;
    private String vie_sexuelle;
    private String vie_sociale;
    private String voyage;
    private String resultat;
    private String Hypothese_diagnostic_HD;
    private String Hypothese_diagnostic_type;
    private String Hypothese_diagnostic_Localisation;
    private String Traitement_propose ;
    private String Traitement_propose_Nbre_infiltrations ;
    private String Traitement_propose_Nbre_seances;
    private String Traitement_propose_Type_chirurgie;
    private String Traitement_propose_Auter        ;

    private String rx_Standard;
    private String rx_Standard_qualite;
    private String pincement_discal;
    private String pincement_discal_etage;
    private String pincement_discal_Pourcentage;
    private String vide_discal;
    private String vide_discal_etage;
    private String sPDL;
    private String sPDL_etage;
    private String sPDL_Grade;
    private String anomalie_transitionnelle;
    private String canal_lombaire_etroit;
    private String Lordose_Lombaire;
    private String incidence_pelvienne;
    private String pente_sacree;
    private String version_perlvienne;
    private String rx_dynamique;
    private String rx_dynamique_qualite;
    private String rx_dynamique_Instabilite;

    private String tDM;
    private String tDM_Pincement_discal;
    private String tDM_Pincement_discal_etage;
    private String tDM_Pincement_discal_pourcentage;
    private String tDM_vide_discal;
    private String tDM_vide_discal_etage;
    private String tDM_vide_discal_Pourcentage;
    private String tDM_hernie_discale;
    private String tDM_hernie_discale_type;
    private String tDM_hernie_discale_etage;
    private String tDM_SPDL;
    private String tDM_SPDL_etage;
    private String tDM_SPDL_Grade;
    private String tDM_Instabilite;
    private String tDM_Instabilite_etage;
    private String tDM_apophysaire;
    private String tDM_apophysaire_etage;
    private String tDM_Anomalie_transitionnelle;
    private String tDM_Canal_lombaire_etroit;
    private String iRM;
    private String iRM_Pincementdiscal;
    private String iRM_Pincementdiscal_etage;
    private String iRM_Pincementdiscal_Pourcentage;
    private String iRM_Herniediscale;
    private String iRM_Herniediscale_etage;
    private String iRM_Herniediscale_Type;
    private String iRM_Hypertrophie_jaunes ;
    private String iRM_Arthrose_apophysaire;
    private String iRM_Arthrose_apophysaire_etage;
    private String iRM_Canal_lombaire_etroit;
    private String iRM_Volume_disque_hernie;
    private String iRM_etat_disques_sous_jacent;
    private String iRM_etat_disques_sus_jacent;
    @ManyToOne
    private Medecin medecin;
    @ManyToOne
    private Administrateur administrateur;



}
