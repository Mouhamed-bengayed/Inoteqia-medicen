package com.test.Inoteqia.Entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

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
    @ElementCollection
    @CollectionTable(name = "patient_atcd", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "atcd")
    private List<String> atcd;

    private String Tabac;
    @ElementCollection
    @CollectionTable(name = "patient_atcd", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "motif_de_consultation")
    private List<String> motif_de_consultation;

//    private String motif_de_consultation_l;

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
    private String resultatodi;



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

    public FichePatient() {
    }

    public FichePatient(Long id, String date_de_consultation, String dossierMedical, String n_Dossier_medical, String dossier_medical_num, String name, String username, String sexe, String annee_de_naissance, String origine, String idPatient, String addresse, String telephone, String profession, String adresse_par, String statut_social, String entourage_actuel, List<String> atcd, String tabac, List<String> motif_de_consultation, String aucn, String date_debut_maladie, String depuis, String facture_declanchants, String date_1consultation_medicale, String date_1consultation_specialisee, String medecin_de_traitants, String medecins_traitants, String traitants_anterieur, String nbre_infiltration, String nbre_seances, String evalution, String n_symptomatologies, String indication_chirurgicale, String date, String poids, String taille, String bMI, String deformation_rachidienne, String douleur_pression_lombairer_epineuses, String amelioration_flexion_rachis, String contracture_muscles_paravertebraux, String dMS, String sonnette, String sonnette_Niveau, String lasegue, String lasegue_controlateral, String leri, String indice_shober, String rOT_Rotulien, String rOT_Achillien, String rOT_Perinee, String marche_talons, String marche_pointes_pieds, String testing_musculaire_L2, String testing_musculaire_L3, String testing_musculaire_L4, String testing_musculaire_L5, String testing_musculaire_S1, String sensibilte_L2, String sensibilte_L3, String sensibilte_L4, String sensibilte_L5, String sensibilte_S1, String examen_perinee_sensibilite, String examen_perinee_Tonus_anal, String examen_perinee_Reflexe_anal, String intensite_douleur, String soins_personnels, String levee, String marche, String assis, String debout, String sommeil, String vie_sexuelle, String vie_sociale, String voyage, String resultatodi, String resultat, String hypothese_diagnostic_HD, String hypothese_diagnostic_type, String hypothese_diagnostic_Localisation, String traitement_propose, String traitement_propose_Nbre_infiltrations, String traitement_propose_Nbre_seances, String traitement_propose_Type_chirurgie, String traitement_propose_Auter, String rx_Standard, String rx_Standard_qualite, String pincement_discal, String pincement_discal_etage, String pincement_discal_Pourcentage, String vide_discal, String vide_discal_etage, String sPDL, String sPDL_etage, String sPDL_Grade, String anomalie_transitionnelle, String canal_lombaire_etroit, String lordose_Lombaire, String incidence_pelvienne, String pente_sacree, String version_perlvienne, String rx_dynamique, String rx_dynamique_qualite, String rx_dynamique_Instabilite, String tDM, String tDM_Pincement_discal, String tDM_Pincement_discal_etage, String tDM_Pincement_discal_pourcentage, String tDM_vide_discal, String tDM_vide_discal_etage, String tDM_vide_discal_Pourcentage, String tDM_hernie_discale, String tDM_hernie_discale_type, String tDM_hernie_discale_etage, String tDM_SPDL, String tDM_SPDL_etage, String tDM_SPDL_Grade, String tDM_Instabilite, String tDM_Instabilite_etage, String tDM_apophysaire, String tDM_apophysaire_etage, String tDM_Anomalie_transitionnelle, String tDM_Canal_lombaire_etroit, String iRM, String iRM_Pincementdiscal, String iRM_Pincementdiscal_etage, String iRM_Pincementdiscal_Pourcentage, String iRM_Herniediscale, String iRM_Herniediscale_etage, String iRM_Herniediscale_Type, String iRM_Hypertrophie_jaunes, String iRM_Arthrose_apophysaire, String iRM_Arthrose_apophysaire_etage, String iRM_Canal_lombaire_etroit, String iRM_Volume_disque_hernie, String iRM_etat_disques_sous_jacent, String iRM_etat_disques_sus_jacent, Medecin medecin, Administrateur administrateur) {
        this.id = id;
        this.date_de_consultation = date_de_consultation;
        this.dossierMedical = dossierMedical;
        this.n_Dossier_medical = n_Dossier_medical;
        Dossier_medical_num = dossier_medical_num;
        this.name = name;
        this.username = username;
        this.sexe = sexe;
        this.annee_de_naissance = annee_de_naissance;
        this.origine = origine;
        this.idPatient = idPatient;
        this.addresse = addresse;
        this.telephone = telephone;
        this.profession = profession;
        this.adresse_par = adresse_par;
        this.statut_social = statut_social;
        this.entourage_actuel = entourage_actuel;
        this.atcd = atcd;
        Tabac = tabac;
        this.motif_de_consultation = motif_de_consultation;
        this.aucn = aucn;
        this.date_debut_maladie = date_debut_maladie;
        this.depuis = depuis;
        this.facture_declanchants = facture_declanchants;
        Date_1consultation_medicale = date_1consultation_medicale;
        Date_1consultation_specialisee = date_1consultation_specialisee;
        this.medecin_de_traitants = medecin_de_traitants;
        this.medecins_traitants = medecins_traitants;
        this.traitants_anterieur = traitants_anterieur;
        Nbre_infiltration = nbre_infiltration;
        Nbre_seances = nbre_seances;
        this.evalution = evalution;
        this.n_symptomatologies = n_symptomatologies;
        this.indication_chirurgicale = indication_chirurgicale;
        this.date = date;
        this.poids = poids;
        this.taille = taille;
        this.bMI = bMI;
        this.deformation_rachidienne = deformation_rachidienne;
        this.douleur_pression_lombairer_epineuses = douleur_pression_lombairer_epineuses;
        Amelioration_flexion_rachis = amelioration_flexion_rachis;
        Contracture_muscles_paravertebraux = contracture_muscles_paravertebraux;
        this.dMS = dMS;
        this.sonnette = sonnette;
        this.sonnette_Niveau = sonnette_Niveau;
        this.lasegue = lasegue;
        this.lasegue_controlateral = lasegue_controlateral;
        this.leri = leri;
        this.indice_shober = indice_shober;
        this.rOT_Rotulien = rOT_Rotulien;
        this.rOT_Achillien = rOT_Achillien;
        this.rOT_Perinee = rOT_Perinee;
        this.marche_talons = marche_talons;
        this.marche_pointes_pieds = marche_pointes_pieds;
        this.testing_musculaire_L2 = testing_musculaire_L2;
        this.testing_musculaire_L3 = testing_musculaire_L3;
        this.testing_musculaire_L4 = testing_musculaire_L4;
        this.testing_musculaire_L5 = testing_musculaire_L5;
        this.testing_musculaire_S1 = testing_musculaire_S1;
        Sensibilte_L2 = sensibilte_L2;
        Sensibilte_L3 = sensibilte_L3;
        Sensibilte_L4 = sensibilte_L4;
        Sensibilte_L5 = sensibilte_L5;
        Sensibilte_S1 = sensibilte_S1;
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
        this.resultatodi = resultatodi;
        this.resultat = resultat;
        Hypothese_diagnostic_HD = hypothese_diagnostic_HD;
        Hypothese_diagnostic_type = hypothese_diagnostic_type;
        Hypothese_diagnostic_Localisation = hypothese_diagnostic_Localisation;
        Traitement_propose = traitement_propose;
        Traitement_propose_Nbre_infiltrations = traitement_propose_Nbre_infiltrations;
        Traitement_propose_Nbre_seances = traitement_propose_Nbre_seances;
        Traitement_propose_Type_chirurgie = traitement_propose_Type_chirurgie;
        Traitement_propose_Auter = traitement_propose_Auter;
        this.rx_Standard = rx_Standard;
        this.rx_Standard_qualite = rx_Standard_qualite;
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
        Lordose_Lombaire = lordose_Lombaire;
        this.incidence_pelvienne = incidence_pelvienne;
        this.pente_sacree = pente_sacree;
        this.version_perlvienne = version_perlvienne;
        this.rx_dynamique = rx_dynamique;
        this.rx_dynamique_qualite = rx_dynamique_qualite;
        this.rx_dynamique_Instabilite = rx_dynamique_Instabilite;
        this.tDM = tDM;
        this.tDM_Pincement_discal = tDM_Pincement_discal;
        this.tDM_Pincement_discal_etage = tDM_Pincement_discal_etage;
        this.tDM_Pincement_discal_pourcentage = tDM_Pincement_discal_pourcentage;
        this.tDM_vide_discal = tDM_vide_discal;
        this.tDM_vide_discal_etage = tDM_vide_discal_etage;
        this.tDM_vide_discal_Pourcentage = tDM_vide_discal_Pourcentage;
        this.tDM_hernie_discale = tDM_hernie_discale;
        this.tDM_hernie_discale_type = tDM_hernie_discale_type;
        this.tDM_hernie_discale_etage = tDM_hernie_discale_etage;
        this.tDM_SPDL = tDM_SPDL;
        this.tDM_SPDL_etage = tDM_SPDL_etage;
        this.tDM_SPDL_Grade = tDM_SPDL_Grade;
        this.tDM_Instabilite = tDM_Instabilite;
        this.tDM_Instabilite_etage = tDM_Instabilite_etage;
        this.tDM_apophysaire = tDM_apophysaire;
        this.tDM_apophysaire_etage = tDM_apophysaire_etage;
        this.tDM_Anomalie_transitionnelle = tDM_Anomalie_transitionnelle;
        this.tDM_Canal_lombaire_etroit = tDM_Canal_lombaire_etroit;
        this.iRM = iRM;
        this.iRM_Pincementdiscal = iRM_Pincementdiscal;
        this.iRM_Pincementdiscal_etage = iRM_Pincementdiscal_etage;
        this.iRM_Pincementdiscal_Pourcentage = iRM_Pincementdiscal_Pourcentage;
        this.iRM_Herniediscale = iRM_Herniediscale;
        this.iRM_Herniediscale_etage = iRM_Herniediscale_etage;
        this.iRM_Herniediscale_Type = iRM_Herniediscale_Type;
        this.iRM_Hypertrophie_jaunes = iRM_Hypertrophie_jaunes;
        this.iRM_Arthrose_apophysaire = iRM_Arthrose_apophysaire;
        this.iRM_Arthrose_apophysaire_etage = iRM_Arthrose_apophysaire_etage;
        this.iRM_Canal_lombaire_etroit = iRM_Canal_lombaire_etroit;
        this.iRM_Volume_disque_hernie = iRM_Volume_disque_hernie;
        this.iRM_etat_disques_sous_jacent = iRM_etat_disques_sous_jacent;
        this.iRM_etat_disques_sus_jacent = iRM_etat_disques_sus_jacent;
        this.medecin = medecin;
        this.administrateur = administrateur;
    }
}
