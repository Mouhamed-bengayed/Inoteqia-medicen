package com.test.Inoteqia.Entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "suivi_Arthrodese")

@Data
public class ConsultationsArthrodese  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dateDeConsultation;
    private String age;
    private String address;
    private String telephone;
    private String profession;
    private String professionAutre;
    private String statutSocial;
    private String entourageActuel;
    private String tabac;
    private String evolution;

    @ElementCollection
    @CollectionTable(name = "evolutionNouvellesSymptomatologies", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "evolutionNouvellesSymptomatologies")
    private List<String> evolutionNouvellesSymptomatologies;

    private String lombalgieType;
    private String lombalgieIntensity;
    private String lombalgieMode;
    private String lombalgieVolution;
    private String lombalgieResponse;
    private String sciatiqueLocalisation;
    private String sciatiqueCote;
    private String sciatiqueIntensity;
    private String sciatiqueMode;
    private String sciatiqueVolution;
    private String sciatiqueResponse;
    private String cruralgieLocalisation;
    private String cruralgieCote;
    private String cruralgieIntensity;
    private String cruralgieMode;
    private String cruralgieVolution;
    private String cruralgieResponse;
    private String claudicationType;
    private String claudicationCote;
    private String derobementType;
    private String derobementCote;
    private String troubleSphincteriens;
    private String troubleSphincteriensUrinaire;
    private String pm;
    private String pmDistance;
    private String pmCauseArret;
    private String resultat;

    private String poids;
    private String taille;
    private String bmi;
    private String deformationRachidienne;
    private String douleurPressionLombairerEpineuses;
    private String ameliorationFlexionRachis;
    private String contractureMusclesParavertebraux;
    private String dms;
    private String sonnette;
    private String sonnetteNiveau;
    private String lasegue;
    private String lasegueControlateral;
    private String leri;
    private String indiceShober;
    private String rotRotulien;
    private String rotAchillien;
    private String rotPerinee;
    private String marcheTalons;
    private String marchePointesPieds;
    private String testingMusculaireL2;
    private String testingMusculaireL3;
    private String testingMusculaireL4;
    private String testingMusculaireL5;
    private String testingMusculaireS1;
    private String sensibiliteL2;
    private String sensibiliteL3;
    private String sensibiliteL4;
    private String sensibiliteL5;
    private String sensibiliteS1;
    private String examenPerineeSensibilite;
    private String examenPerineeTonusAnal;
    private String examenPerineeReflexeAnal;

    private String hypotheseDiagnosticHD;
    private String hypotheseDiagnosticType;
    private String hypotheseDiagnosticLocalisation;
    private String hypotheseDiagnosticCote;
    private String traitementPropose;
    private String traitementProposeNbreInfiltrations;
    private String traitementProposeNbreSeances;
    private String traitementProposeTypeChirurgie;

    private String rxStandard;
    private String rxStandardPincement;
    private String rxPincementDiscalEtage;
    private String rxPincementDiscalPourcentage;
    private String rxVideDiscal;
    private String rxVideDiscalEtage;
    private String rxSPDL;
    private String rxSPDLEtage;
    private String rxSPDLGrade;
    private String rxAnomalieTransitionnelle;
    private String rxCanalLombaireEtroit;
    private String rxLordoseLombaire;
    private String rxIncidencePelvienne;
    private String rxPenteSacree;
    private String rxVersionPerlvienne;

    private String rxDynamique;
    private String rxDynamiqueQualite;
    private String rxDynamiqueInstabilite;

    private String tdm;
    private String tdmPincementDiscal;
    private String tdmPincementDiscalEtage;
    private String tdmPincementDiscalPourcentage;
    private String tdmVideDiscal;
    private String tdmVideDiscalEtage;
    private String tdmHernieDiscale;
    private String tdmHernieDiscaleType;
    private String tdmHernieDiscaleEtage;
    private String tdmHernieDiscaleCote;
    private String tdmSPDL;
    private String tdmSPDLEtage;
    private String tdmSPDLGrade;
    private String tdmInstabilite;
    private String tdmInstabiliteEtage;
    private String tdmApophysaire;
    private String tdmApophysaireEtage;
    private String tdmAnomalieTransitionnelle;
    private String tdmCanalLombaireEtroit;
    private String tdmQualiteFusion;

    private String irm;
    private String irmPincementDiscal;
    private String irmPincementDiscalEtage;
    private String irmPincementDiscalPourcentage;
    private String irmHernieDiscale;
    private String irmHernieDiscaleEtage;
    private String irmHernieDiscaleType;
    private String irmHernieDiscaleCote;
    private String irmHypertrophieJaunes;
    private String irmArthroseApophysaire;
    private String irmArthroseApophysaireEtage;
    private String irmCanalLombaireEtroit;
    private String irmVolumeDisqueHernie;
    private String irmEtatDisquesSousJacent;
    private String irmEtatDisquesSusJacent;

    @ManyToOne
    private Medecin medecin;

    public ConsultationsArthrodese(String dateDeConsultation, String age, String address, String telephone, String profession, String professionAutre, String statutSocial, String entourageActuel, String tabac, String evolution, List<String> evolutionNouvellesSymptomatologies, String lombalgieType, String lombalgieIntensity, String lombalgieMode, String lombalgieVolution, String lombalgieResponse, String sciatiqueLocalisation, String sciatiqueCote, String sciatiqueIntensity, String sciatiqueMode, String sciatiqueVolution, String sciatiqueResponse, String cruralgieLocalisation, String cruralgieCote, String cruralgieIntensity, String cruralgieMode, String cruralgieVolution, String cruralgieResponse, String claudicationType, String claudicationCote, String derobementType, String derobementCote, String troubleSphincteriens, String troubleSphincteriensUrinaire, String pm, String pmDistance, String pmCauseArret, String resultat, String poids, String taille, String bmi, String deformationRachidienne, String douleurPressionLombairerEpineuses, String ameliorationFlexionRachis, String contractureMusclesParavertebraux, String dms, String sonnette, String sonnetteNiveau, String lasegue, String lasegueControlateral, String leri, String indiceShober, String rotRotulien, String rotAchillien, String rotPerinee, String marcheTalons, String marchePointesPieds, String testingMusculaireL2, String testingMusculaireL3, String testingMusculaireL4, String testingMusculaireL5, String testingMusculaireS1, String sensibiliteL2, String sensibiliteL3, String sensibiliteL4, String sensibiliteL5, String sensibiliteS1, String examenPerineeSensibilite, String examenPerineeTonusAnal, String examenPerineeReflexeAnal, String hypotheseDiagnosticHD, String hypotheseDiagnosticType, String hypotheseDiagnosticLocalisation, String hypotheseDiagnosticCote, String traitementPropose, String traitementProposeNbreInfiltrations, String traitementProposeNbreSeances, String traitementProposeTypeChirurgie, String rxStandard, String rxStandardPincement, String rxPincementDiscalEtage, String rxPincementDiscalPourcentage, String rxVideDiscal, String rxVideDiscalEtage, String rxSPDL, String rxSPDLEtage, String rxSPDLGrade, String rxAnomalieTransitionnelle, String rxCanalLombaireEtroit, String rxLordoseLombaire, String rxIncidencePelvienne, String rxPenteSacree, String rxVersionPerlvienne, String rxDynamique, String rxDynamiqueQualite, String rxDynamiqueInstabilite, String tdm, String tdmPincementDiscal, String tdmPincementDiscalEtage, String tdmPincementDiscalPourcentage, String tdmVideDiscal, String tdmVideDiscalEtage, String tdmHernieDiscale, String tdmHernieDiscaleType, String tdmHernieDiscaleEtage, String tdmHernieDiscaleCote, String tdmSPDL, String tdmSPDLEtage, String tdmSPDLGrade, String tdmInstabilite, String tdmInstabiliteEtage, String tdmApophysaire, String tdmApophysaireEtage, String tdmAnomalieTransitionnelle, String tdmCanalLombaireEtroit, String tdmQualiteFusion, String irm, String irmPincementDiscal, String irmPincementDiscalEtage, String irmPincementDiscalPourcentage, String irmHernieDiscale, String irmHernieDiscaleEtage, String irmHernieDiscaleType, String irmHernieDiscaleCote, String irmHypertrophieJaunes, String irmArthroseApophysaire, String irmArthroseApophysaireEtage, String irmCanalLombaireEtroit, String irmVolumeDisqueHernie, String irmEtatDisquesSousJacent, String irmEtatDisquesSusJacent) {
        this.dateDeConsultation = dateDeConsultation;
        this.age = age;
        this.address = address;
        this.telephone = telephone;
        this.profession = profession;
        this.professionAutre = professionAutre;
        this.statutSocial = statutSocial;
        this.entourageActuel = entourageActuel;
        this.tabac = tabac;
        this.evolution = evolution;
        this.evolutionNouvellesSymptomatologies = evolutionNouvellesSymptomatologies;
        this.lombalgieType = lombalgieType;
        this.lombalgieIntensity = lombalgieIntensity;
        this.lombalgieMode = lombalgieMode;
        this.lombalgieVolution = lombalgieVolution;
        this.lombalgieResponse = lombalgieResponse;
        this.sciatiqueLocalisation = sciatiqueLocalisation;
        this.sciatiqueCote = sciatiqueCote;
        this.sciatiqueIntensity = sciatiqueIntensity;
        this.sciatiqueMode = sciatiqueMode;
        this.sciatiqueVolution = sciatiqueVolution;
        this.sciatiqueResponse = sciatiqueResponse;
        this.cruralgieLocalisation = cruralgieLocalisation;
        this.cruralgieCote = cruralgieCote;
        this.cruralgieIntensity = cruralgieIntensity;
        this.cruralgieMode = cruralgieMode;
        this.cruralgieVolution = cruralgieVolution;
        this.cruralgieResponse = cruralgieResponse;
        this.claudicationType = claudicationType;
        this.claudicationCote = claudicationCote;
        this.derobementType = derobementType;
        this.derobementCote = derobementCote;
        this.troubleSphincteriens = troubleSphincteriens;
        this.troubleSphincteriensUrinaire = troubleSphincteriensUrinaire;
        this.pm = pm;
        this.pmDistance = pmDistance;
        this.pmCauseArret = pmCauseArret;
        this.resultat = resultat;
        this.poids = poids;
        this.taille = taille;
        this.bmi = bmi;
        this.deformationRachidienne = deformationRachidienne;
        this.douleurPressionLombairerEpineuses = douleurPressionLombairerEpineuses;
        this.ameliorationFlexionRachis = ameliorationFlexionRachis;
        this.contractureMusclesParavertebraux = contractureMusclesParavertebraux;
        this.dms = dms;
        this.sonnette = sonnette;
        this.sonnetteNiveau = sonnetteNiveau;
        this.lasegue = lasegue;
        this.lasegueControlateral = lasegueControlateral;
        this.leri = leri;
        this.indiceShober = indiceShober;
        this.rotRotulien = rotRotulien;
        this.rotAchillien = rotAchillien;
        this.rotPerinee = rotPerinee;
        this.marcheTalons = marcheTalons;
        this.marchePointesPieds = marchePointesPieds;
        this.testingMusculaireL2 = testingMusculaireL2;
        this.testingMusculaireL3 = testingMusculaireL3;
        this.testingMusculaireL4 = testingMusculaireL4;
        this.testingMusculaireL5 = testingMusculaireL5;
        this.testingMusculaireS1 = testingMusculaireS1;
        this.sensibiliteL2 = sensibiliteL2;
        this.sensibiliteL3 = sensibiliteL3;
        this.sensibiliteL4 = sensibiliteL4;
        this.sensibiliteL5 = sensibiliteL5;
        this.sensibiliteS1 = sensibiliteS1;
        this.examenPerineeSensibilite = examenPerineeSensibilite;
        this.examenPerineeTonusAnal = examenPerineeTonusAnal;
        this.examenPerineeReflexeAnal = examenPerineeReflexeAnal;
        this.hypotheseDiagnosticHD = hypotheseDiagnosticHD;
        this.hypotheseDiagnosticType = hypotheseDiagnosticType;
        this.hypotheseDiagnosticLocalisation = hypotheseDiagnosticLocalisation;
        this.hypotheseDiagnosticCote = hypotheseDiagnosticCote;
        this.traitementPropose = traitementPropose;
        this.traitementProposeNbreInfiltrations = traitementProposeNbreInfiltrations;
        this.traitementProposeNbreSeances = traitementProposeNbreSeances;
        this.traitementProposeTypeChirurgie = traitementProposeTypeChirurgie;
        this.rxStandard = rxStandard;
        this.rxStandardPincement = rxStandardPincement;
        this.rxPincementDiscalEtage = rxPincementDiscalEtage;
        this.rxPincementDiscalPourcentage = rxPincementDiscalPourcentage;
        this.rxVideDiscal = rxVideDiscal;
        this.rxVideDiscalEtage = rxVideDiscalEtage;
        this.rxSPDL = rxSPDL;
        this.rxSPDLEtage = rxSPDLEtage;
        this.rxSPDLGrade = rxSPDLGrade;
        this.rxAnomalieTransitionnelle = rxAnomalieTransitionnelle;
        this.rxCanalLombaireEtroit = rxCanalLombaireEtroit;
        this.rxLordoseLombaire = rxLordoseLombaire;
        this.rxIncidencePelvienne = rxIncidencePelvienne;
        this.rxPenteSacree = rxPenteSacree;
        this.rxVersionPerlvienne = rxVersionPerlvienne;
        this.rxDynamique = rxDynamique;
        this.rxDynamiqueQualite = rxDynamiqueQualite;
        this.rxDynamiqueInstabilite = rxDynamiqueInstabilite;
        this.tdm = tdm;
        this.tdmPincementDiscal = tdmPincementDiscal;
        this.tdmPincementDiscalEtage = tdmPincementDiscalEtage;
        this.tdmPincementDiscalPourcentage = tdmPincementDiscalPourcentage;
        this.tdmVideDiscal = tdmVideDiscal;
        this.tdmVideDiscalEtage = tdmVideDiscalEtage;
        this.tdmHernieDiscale = tdmHernieDiscale;
        this.tdmHernieDiscaleType = tdmHernieDiscaleType;
        this.tdmHernieDiscaleEtage = tdmHernieDiscaleEtage;
        this.tdmHernieDiscaleCote = tdmHernieDiscaleCote;
        this.tdmSPDL = tdmSPDL;
        this.tdmSPDLEtage = tdmSPDLEtage;
        this.tdmSPDLGrade = tdmSPDLGrade;
        this.tdmInstabilite = tdmInstabilite;
        this.tdmInstabiliteEtage = tdmInstabiliteEtage;
        this.tdmApophysaire = tdmApophysaire;
        this.tdmApophysaireEtage = tdmApophysaireEtage;
        this.tdmAnomalieTransitionnelle = tdmAnomalieTransitionnelle;
        this.tdmCanalLombaireEtroit = tdmCanalLombaireEtroit;
        this.tdmQualiteFusion = tdmQualiteFusion;
        this.irm = irm;
        this.irmPincementDiscal = irmPincementDiscal;
        this.irmPincementDiscalEtage = irmPincementDiscalEtage;
        this.irmPincementDiscalPourcentage = irmPincementDiscalPourcentage;
        this.irmHernieDiscale = irmHernieDiscale;
        this.irmHernieDiscaleEtage = irmHernieDiscaleEtage;
        this.irmHernieDiscaleType = irmHernieDiscaleType;
        this.irmHernieDiscaleCote = irmHernieDiscaleCote;
        this.irmHypertrophieJaunes = irmHypertrophieJaunes;
        this.irmArthroseApophysaire = irmArthroseApophysaire;
        this.irmArthroseApophysaireEtage = irmArthroseApophysaireEtage;
        this.irmCanalLombaireEtroit = irmCanalLombaireEtroit;
        this.irmVolumeDisqueHernie = irmVolumeDisqueHernie;
        this.irmEtatDisquesSousJacent = irmEtatDisquesSousJacent;
        this.irmEtatDisquesSusJacent = irmEtatDisquesSusJacent;
    }

    public ConsultationsArthrodese(){

    }


}


