package com.test.Inoteqia.Entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "suivi_ttt_dissect")
@Data
public class Consultations_ttt_Dissect {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date_de_consultation;
    private String age;
    private String addresse;
    private String telephone;
    private String profession;
    private String statut_social;
    private String entourage_actuel;
    private String atcd;
    private String tabac;
    private String evolution;
    private String evolution_nouvelles_symptomatologies;


    private String poids;
    private String taille;
    private String bMI;
    private String deformation_rachidienne;
    private String douleur_pression_lombairer_epineuses;
    private String amelioration_flexion_rachis;
    private String contracture_muscles_paravertebraux;
    private String dMS;
    private String sonnette;
    private String sonnette_Niveau;
    private String lasegue;
    private String lasegue_controlateral;
    private String leri;
    private String indice_shober;
    private String rOT_rotulien;
    private String rOT_achillien;
    private String rOT_perinee;

    private String marche_talons;
    private String marche_pointes_pieds;
    private String testing_musculaire_L2;
    private String testing_musculaire_L3;
    private String testing_musculaire_L4;
    private String testing_musculaire_L5;
    private String testing_musculaire_S1;
    private String sensibilte_L2;
    private String sensibilte_L3;
    private String sensibilte_L4;
    private String sensibilte_L5;
    private String sensibilte_S1;
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
    private String hypothese_diagnostic_HD;
    private String hypothese_diagnostic_type;
    private String hypothese_diagnostic_Localisation;
    private String traitement_propose ;
    private String traitement_propose_Nbre_infiltrations ;
    private String traitement_propose_Nbre_seances;
    private String traitement_propose_Type_chirurgie;
    private String traitement_propose_Auter        ;

    private String rx_standard;
    private String rx_standard_qualite;
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
    private String lordose_Lombaire;
    private String incidence_pelvienne;
    private String pente_sacree;
    private String version_perlvienne;
    private String rx_dynamique;
    private String rx_dynamique_qualite;
    private String rx_dynamique_Instabilite;

    private String tDM;
    private String tDM_pincement_discal;
    private String tDM_pincement_discal_etage;
    private String tDM_pincement_discal_pourcentage;
    private String tDM_vide_discal;
    private String tDM_vide_discal_etage;
    private String tDM_vide_discal_Pourcentage;
    private String tDM_hernie_discale;
    private String tDM_hernie_discale_type;
    private String tDM_hernie_discale_etage;
    private String tDM_sPDL;
    private String tDM_sPDL_etage;
    private String tDM_sPDL_grade;
    private String tDM_instabilite;
    private String tDM_instabilite_etage;
    private String tDM_apophysaire;
    private String tDM_apophysaire_etage;
    private String tDM_anomalie_transitionnelle;
    private String tDM_canal_lombaire_etroit;
    private String tDM_qualite_fusion;
    private String iRM;
    private String iRM_pincementdiscal;
    private String iRM_pincementdiscal_etage;
    private String iRM_pincementdiscal_Pourcentage;
    private String iRM_herniediscale;
    private String iRM_herniediscale_etage;
    private String iRM_herniediscale_Type;
    private String iRM_hypertrophie_jaunes ;
    private String iRM_arthrose_apophysaire;
    private String iRM_arthrose_apophysaire_etage;
    private String iRM_canal_lombaire_etroit;
    private String iRM_volume_disque_hernie;
    private String iRM_etat_disques_sous_jacent;
    private String iRM_etat_disques_sus_jacent;
    @ManyToOne
    private Medecin medecin;





    public Consultations_ttt_Dissect(String date_de_consultation, String age, String addresse, String telephone, String profession, String statut_social, String entourage_actuel, String atcd, String tabac, String evolution, String evolution_nouvelles_symptomatologies, String poids, String taille, String bMI, String deformation_rachidienne, String douleur_pression_lombairer_epineuses, String amelioration_flexion_rachis, String contracture_muscles_paravertebraux, String dMS, String sonnette, String sonnette_Niveau, String lasegue, String lasegue_controlateral, String leri, String indice_shober, String rOT_rotulien, String rOT_achillien, String rOT_perinee, String marche_talons, String marche_pointes_pieds, String testing_musculaire_L2, String testing_musculaire_L3, String testing_musculaire_L4, String testing_musculaire_L5, String testing_musculaire_S1, String sensibilte_L2, String sensibilte_L3, String sensibilte_L4, String sensibilte_L5, String sensibilte_S1, String examen_perinee_sensibilite, String examen_perinee_Tonus_anal, String examen_perinee_Reflexe_anal, String intensite_douleur, String soins_personnels, String levee, String marche, String assis, String debout, String sommeil, String vie_sexuelle, String vie_sociale, String voyage, String resultat, String hypothese_diagnostic_HD, String hypothese_diagnostic_type, String hypothese_diagnostic_Localisation, String traitement_propose, String traitement_propose_Nbre_infiltrations, String traitement_propose_Nbre_seances, String traitement_propose_Type_chirurgie, String traitement_propose_Auter, String rx_standard, String rx_standard_qualite, String pincement_discal, String pincement_discal_etage, String pincement_discal_Pourcentage, String vide_discal, String vide_discal_etage, String sPDL, String sPDL_etage, String sPDL_Grade, String anomalie_transitionnelle, String canal_lombaire_etroit, String lordose_Lombaire, String incidence_pelvienne, String pente_sacree, String version_perlvienne, String rx_dynamique, String rx_dynamique_qualite, String rx_dynamique_Instabilite, String tDM, String tDM_pincement_discal, String tDM_pincement_discal_etage, String tDM_pincement_discal_pourcentage, String tDM_vide_discal, String tDM_vide_discal_etage, String tDM_vide_discal_Pourcentage, String tDM_hernie_discale, String tDM_hernie_discale_type, String tDM_hernie_discale_etage, String tDM_sPDL, String tDM_sPDL_etage, String tDM_sPDL_grade, String tDM_instabilite, String tDM_instabilite_etage, String tDM_apophysaire, String tDM_apophysaire_etage, String tDM_anomalie_transitionnelle, String tDM_canal_lombaire_etroit, String iRM, String iRM_pincementdiscal, String iRM_pincementdiscal_etage, String iRM_pincementdiscal_Pourcentage, String iRM_herniediscale, String iRM_herniediscale_etage, String iRM_herniediscale_Type, String iRM_hypertrophie_jaunes, String iRM_arthrose_apophysaire, String iRM_arthrose_apophysaire_etage, String iRM_canal_lombaire_etroit, String iRM_volume_disque_hernie, String iRM_etat_disques_sous_jacent, String iRM_etat_disques_sus_jacent) {
        this.date_de_consultation = date_de_consultation;
        this.age = age;
        this.addresse = addresse;
        this.telephone = telephone;
        this.profession = profession;
        this.statut_social = statut_social;
        this.entourage_actuel = entourage_actuel;
        this.atcd = atcd;
        this.tabac = tabac;
        this.evolution = evolution;
        this.evolution_nouvelles_symptomatologies = evolution_nouvelles_symptomatologies;
        this.poids = poids;
        this.taille = taille;
        this.bMI = bMI;
        this.deformation_rachidienne = deformation_rachidienne;
        this.douleur_pression_lombairer_epineuses = douleur_pression_lombairer_epineuses;
        this.amelioration_flexion_rachis = amelioration_flexion_rachis;
        this.contracture_muscles_paravertebraux = contracture_muscles_paravertebraux;
        this.dMS = dMS;
        this.sonnette = sonnette;
        this.sonnette_Niveau = sonnette_Niveau;
        this.lasegue = lasegue;
        this.lasegue_controlateral = lasegue_controlateral;
        this.leri = leri;
        this.indice_shober = indice_shober;
        this.rOT_rotulien = rOT_rotulien;
        this.rOT_achillien = rOT_achillien;
        this.rOT_perinee = rOT_perinee;
        this.marche_talons = marche_talons;
        this.marche_pointes_pieds = marche_pointes_pieds;
        this.testing_musculaire_L2 = testing_musculaire_L2;
        this.testing_musculaire_L3 = testing_musculaire_L3;
        this.testing_musculaire_L4 = testing_musculaire_L4;
        this.testing_musculaire_L5 = testing_musculaire_L5;
        this.testing_musculaire_S1 = testing_musculaire_S1;
        this.sensibilte_L2 = sensibilte_L2;
        this.sensibilte_L3 = sensibilte_L3;
        this.sensibilte_L4 = sensibilte_L4;
        this.sensibilte_L5 = sensibilte_L5;
        this.sensibilte_S1 = sensibilte_S1;
        this.examen_perinee_sensibilite = examen_perinee_sensibilite;
        this.examen_perinee_Tonus_anal = examen_perinee_Tonus_anal;
        this.examen_perinee_Reflexe_anal = examen_perinee_Reflexe_anal;
        this.intensite_douleur = intensite_douleur;
        this.soins_personnels = soins_personnels;
        this.levee = levee;
        this.marche = marche;
        this.assis = assis;
        this.debout = debout;
        this.sommeil = sommeil;
        this.vie_sexuelle = vie_sexuelle;
        this.vie_sociale = vie_sociale;
        this.voyage = voyage;
        this.resultat = resultat;
        this.hypothese_diagnostic_HD = hypothese_diagnostic_HD;
        this.hypothese_diagnostic_type = hypothese_diagnostic_type;
        this.hypothese_diagnostic_Localisation = hypothese_diagnostic_Localisation;
        this.traitement_propose = traitement_propose;
        this.traitement_propose_Nbre_infiltrations = traitement_propose_Nbre_infiltrations;
        this.traitement_propose_Nbre_seances = traitement_propose_Nbre_seances;
        this.traitement_propose_Type_chirurgie = traitement_propose_Type_chirurgie;
        this.traitement_propose_Auter = traitement_propose_Auter;
        this.rx_standard = rx_standard;
        this.rx_standard_qualite = rx_standard_qualite;
        this.pincement_discal = pincement_discal;
        this.pincement_discal_etage = pincement_discal_etage;
        this.pincement_discal_Pourcentage = pincement_discal_Pourcentage;
        this.vide_discal = vide_discal;
        this.vide_discal_etage = vide_discal_etage;
        this.sPDL = sPDL;
        this.sPDL_etage = sPDL_etage;
        this.sPDL_Grade = sPDL_Grade;
        this.anomalie_transitionnelle = anomalie_transitionnelle;
        this.canal_lombaire_etroit = canal_lombaire_etroit;
        this.lordose_Lombaire = lordose_Lombaire;
        this.incidence_pelvienne = incidence_pelvienne;
        this.pente_sacree = pente_sacree;
        this.version_perlvienne = version_perlvienne;
        this.rx_dynamique = rx_dynamique;
        this.rx_dynamique_qualite = rx_dynamique_qualite;
        this.rx_dynamique_Instabilite = rx_dynamique_Instabilite;
        this.tDM = tDM;
        this.tDM_pincement_discal = tDM_pincement_discal;
        this.tDM_pincement_discal_etage = tDM_pincement_discal_etage;
        this.tDM_pincement_discal_pourcentage = tDM_pincement_discal_pourcentage;
        this.tDM_vide_discal = tDM_vide_discal;
        this.tDM_vide_discal_etage = tDM_vide_discal_etage;
        this.tDM_vide_discal_Pourcentage = tDM_vide_discal_Pourcentage;
        this.tDM_hernie_discale = tDM_hernie_discale;
        this.tDM_hernie_discale_type = tDM_hernie_discale_type;
        this.tDM_hernie_discale_etage = tDM_hernie_discale_etage;
        this.tDM_sPDL = tDM_sPDL;
        this.tDM_sPDL_etage = tDM_sPDL_etage;
        this.tDM_sPDL_grade = tDM_sPDL_grade;
        this.tDM_instabilite = tDM_instabilite;
        this.tDM_instabilite_etage = tDM_instabilite_etage;
        this.tDM_apophysaire = tDM_apophysaire;
        this.tDM_apophysaire_etage = tDM_apophysaire_etage;
        this.tDM_anomalie_transitionnelle = tDM_anomalie_transitionnelle;
        this.tDM_canal_lombaire_etroit = tDM_canal_lombaire_etroit;
        this.iRM = iRM;
        this.iRM_pincementdiscal = iRM_pincementdiscal;
        this.iRM_pincementdiscal_etage = iRM_pincementdiscal_etage;
        this.iRM_pincementdiscal_Pourcentage = iRM_pincementdiscal_Pourcentage;
        this.iRM_herniediscale = iRM_herniediscale;
        this.iRM_herniediscale_etage = iRM_herniediscale_etage;
        this.iRM_herniediscale_Type = iRM_herniediscale_Type;
        this.iRM_hypertrophie_jaunes = iRM_hypertrophie_jaunes;
        this.iRM_arthrose_apophysaire = iRM_arthrose_apophysaire;
        this.iRM_arthrose_apophysaire_etage = iRM_arthrose_apophysaire_etage;
        this.iRM_canal_lombaire_etroit = iRM_canal_lombaire_etroit;
        this.iRM_volume_disque_hernie = iRM_volume_disque_hernie;
        this.iRM_etat_disques_sous_jacent = iRM_etat_disques_sous_jacent;
        this.iRM_etat_disques_sus_jacent = iRM_etat_disques_sus_jacent;
    }




    public Consultations_ttt_Dissect() {}


}
