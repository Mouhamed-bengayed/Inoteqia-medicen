package com.test.Inoteqia.Services;

import com.test.Inoteqia.Entity.Consultations_ttt_Dissect;
import com.test.Inoteqia.Entity.FichePatient;
import com.test.Inoteqia.Reposotories.FichePatientRepository;
import com.test.Inoteqia.Reposotories.Suivi_ttt_Dissect_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.ZoneId;

@Service
public class Suivi_ttt_Dissect_Services {

    @Autowired
    CryptDecrypt cryptDecrypt;
    @Autowired
    Suivi_ttt_Dissect_Repository suivi_ttt_dissect_repository;
    @Autowired
    FichePatientRepository fichePatientRepository;

    public ResponseEntity<Consultations_ttt_Dissect> registerSuivittt_Dissect(Consultations_ttt_Dissect p1, Long patientId) throws Exception {


        // Retrieve the existing entity by patient ID or create a new one if not found
        Consultations_ttt_Dissect suivi1Post_ttt = suivi_ttt_dissect_repository.findByFichePatientId(patientId)
                .orElse(new Consultations_ttt_Dissect());

        // Set the FichePatient on the entity
        suivi1Post_ttt.setFichePatient(fichePatientRepository.findById(patientId).get());
        // Check if the entity exists

            // Set encrypted values
            suivi1Post_ttt.setDateDeConsultation(p1.getDateDeConsultation().atZone(ZoneId.systemDefault()).toLocalDateTime());
            suivi1Post_ttt.setAge(cryptDecrypt.encryptSensitiveInformation(p1.getAge()));
            suivi1Post_ttt.setAddress(cryptDecrypt.encryptSensitiveInformation(p1.getAddress()));
            suivi1Post_ttt.setTelephone(cryptDecrypt.encryptSensitiveInformation(p1.getTelephone()));
            suivi1Post_ttt.setProfession(cryptDecrypt.encryptSensitiveInformation(p1.getProfession()));
            suivi1Post_ttt.setProfessionAutre(cryptDecrypt.encryptSensitiveInformation(p1.getProfessionAutre()));
            suivi1Post_ttt.setStatutSocial(cryptDecrypt.encryptSensitiveInformation(p1.getStatutSocial()));
            suivi1Post_ttt.setEntourageActuel(cryptDecrypt.encryptSensitiveInformation(p1.getEntourageActuel()));
            suivi1Post_ttt.setTabac(cryptDecrypt.encryptSensitiveInformation(p1.getTabac()));
            suivi1Post_ttt.setEvolution(cryptDecrypt.encryptSensitiveInformation(p1.getEvolution()));
            suivi1Post_ttt.setEvolutionNouvellesSymptomatologies(cryptDecrypt.encryptListeSensitiveInformation(p1.getEvolutionNouvellesSymptomatologies()));
            suivi1Post_ttt.setLombalgieType(cryptDecrypt.encryptSensitiveInformation(p1.getLombalgieType()));
            suivi1Post_ttt.setLombalgieIntensity(cryptDecrypt.encryptSensitiveInformation(p1.getLombalgieIntensity()));
            suivi1Post_ttt.setLombalgieMode(cryptDecrypt.encryptSensitiveInformation(p1.getLombalgieMode()));
            suivi1Post_ttt.setLombalgieVolution(cryptDecrypt.encryptSensitiveInformation(p1.getLombalgieVolution()));
            suivi1Post_ttt.setLombalgieResponse(cryptDecrypt.encryptSensitiveInformation(p1.getLombalgieResponse()));
            suivi1Post_ttt.setSciatiqueLocalisation(cryptDecrypt.encryptSensitiveInformation(p1.getSciatiqueLocalisation()));
            suivi1Post_ttt.setSciatiqueCote(cryptDecrypt.encryptSensitiveInformation(p1.getSciatiqueCote()));
            suivi1Post_ttt.setSciatiqueIntensity(cryptDecrypt.encryptSensitiveInformation(p1.getSciatiqueIntensity()));
            suivi1Post_ttt.setSciatiqueMode(cryptDecrypt.encryptSensitiveInformation(p1.getSciatiqueMode()));
            suivi1Post_ttt.setSciatiqueVolution(cryptDecrypt.encryptSensitiveInformation(p1.getSciatiqueVolution()));
            suivi1Post_ttt.setSciatiqueResponse(cryptDecrypt.encryptSensitiveInformation(p1.getSciatiqueResponse()));
            suivi1Post_ttt.setCruralgieLocalisation(cryptDecrypt.encryptSensitiveInformation(p1.getCruralgieLocalisation()));
            suivi1Post_ttt.setCruralgieCote(cryptDecrypt.encryptSensitiveInformation(p1.getCruralgieCote()));
            suivi1Post_ttt.setCruralgieIntensity(cryptDecrypt.encryptSensitiveInformation(p1.getCruralgieIntensity()));
            suivi1Post_ttt.setCruralgieMode(cryptDecrypt.encryptSensitiveInformation(p1.getCruralgieMode()));
            suivi1Post_ttt.setCruralgieVolution(cryptDecrypt.encryptSensitiveInformation(p1.getCruralgieVolution()));
            suivi1Post_ttt.setCruralgieResponse(cryptDecrypt.encryptSensitiveInformation(p1.getCruralgieResponse()));
            suivi1Post_ttt.setClaudicationType(cryptDecrypt.encryptSensitiveInformation(p1.getClaudicationType()));
            suivi1Post_ttt.setClaudicationCote(cryptDecrypt.encryptSensitiveInformation(p1.getClaudicationCote()));
            suivi1Post_ttt.setDerobementType(cryptDecrypt.encryptSensitiveInformation(p1.getDerobementType()));
            suivi1Post_ttt.setDerobementCote(cryptDecrypt.encryptSensitiveInformation(p1.getDerobementCote()));
            suivi1Post_ttt.setTroubleSphincteriens(cryptDecrypt.encryptSensitiveInformation(p1.getTroubleSphincteriens()));
            suivi1Post_ttt.setTroubleSphincteriensUrinaire(cryptDecrypt.encryptSensitiveInformation(p1.getTroubleSphincteriensUrinaire()));
            suivi1Post_ttt.setPm(cryptDecrypt.encryptSensitiveInformation(p1.getPm()));
            suivi1Post_ttt.setPmDistance(cryptDecrypt.encryptSensitiveInformation(p1.getPmDistance()));
            suivi1Post_ttt.setPmCauseArret(cryptDecrypt.encryptSensitiveInformation(p1.getPmCauseArret()));
            suivi1Post_ttt.setResultat(cryptDecrypt.encryptSensitiveInformation(p1.getResultat()));
            suivi1Post_ttt.setPoids(cryptDecrypt.encryptSensitiveInformation(p1.getPoids()));
            suivi1Post_ttt.setTaille(cryptDecrypt.encryptSensitiveInformation(p1.getTaille()));
            suivi1Post_ttt.setBmi(cryptDecrypt.encryptSensitiveInformation(p1.getBmi()));
            suivi1Post_ttt.setDeformationRachidienne(cryptDecrypt.encryptSensitiveInformation(p1.getDeformationRachidienne()));
            suivi1Post_ttt.setDouleurPressionLombairerEpineuses(cryptDecrypt.encryptSensitiveInformation(p1.getDouleurPressionLombairerEpineuses()));
            suivi1Post_ttt.setAmeliorationFlexionRachis(cryptDecrypt.encryptSensitiveInformation(p1.getAmeliorationFlexionRachis()));
            suivi1Post_ttt.setContractureMusclesParavertebraux(cryptDecrypt.encryptSensitiveInformation(p1.getContractureMusclesParavertebraux()));
            suivi1Post_ttt.setDms(cryptDecrypt.encryptSensitiveInformation(p1.getDms()));
            suivi1Post_ttt.setSonnette(cryptDecrypt.encryptSensitiveInformation(p1.getSonnette()));
            suivi1Post_ttt.setSonnetteNiveau(cryptDecrypt.encryptSensitiveInformation(p1.getSonnetteNiveau()));
            suivi1Post_ttt.setLasegue(cryptDecrypt.encryptSensitiveInformation(p1.getLasegue()));
            suivi1Post_ttt.setLasegueControlateral(cryptDecrypt.encryptSensitiveInformation(p1.getLasegueControlateral()));
            suivi1Post_ttt.setLeri(cryptDecrypt.encryptSensitiveInformation(p1.getLeri()));
            suivi1Post_ttt.setIndiceShober(cryptDecrypt.encryptSensitiveInformation(p1.getIndiceShober()));
            suivi1Post_ttt.setRotRotulien(cryptDecrypt.encryptSensitiveInformation(p1.getRotRotulien()));
            suivi1Post_ttt.setRotAchillien(cryptDecrypt.encryptSensitiveInformation(p1.getRotAchillien()));
            suivi1Post_ttt.setRotPerinee(cryptDecrypt.encryptSensitiveInformation(p1.getRotPerinee()));
            suivi1Post_ttt.setMarcheTalons(cryptDecrypt.encryptSensitiveInformation(p1.getMarcheTalons()));
            suivi1Post_ttt.setMarchePointesPieds(cryptDecrypt.encryptSensitiveInformation(p1.getMarchePointesPieds()));
            suivi1Post_ttt.setTestingMusculaireL2(cryptDecrypt.encryptSensitiveInformation(p1.getTestingMusculaireL2()));
            suivi1Post_ttt.setTestingMusculaireL3(cryptDecrypt.encryptSensitiveInformation(p1.getTestingMusculaireL3()));
            suivi1Post_ttt.setTestingMusculaireL4(cryptDecrypt.encryptSensitiveInformation(p1.getTestingMusculaireL4()));
            suivi1Post_ttt.setTestingMusculaireL5(cryptDecrypt.encryptSensitiveInformation(p1.getTestingMusculaireL5()));
            suivi1Post_ttt.setTestingMusculaireS1(cryptDecrypt.encryptSensitiveInformation(p1.getTestingMusculaireS1()));
            suivi1Post_ttt.setSensibiliteL2(cryptDecrypt.encryptSensitiveInformation(p1.getSensibiliteL2()));
            suivi1Post_ttt.setSensibiliteL3(cryptDecrypt.encryptSensitiveInformation(p1.getSensibiliteL3()));
            suivi1Post_ttt.setSensibiliteL4(cryptDecrypt.encryptSensitiveInformation(p1.getSensibiliteL4()));
            suivi1Post_ttt.setSensibiliteL5(cryptDecrypt.encryptSensitiveInformation(p1.getSensibiliteL5()));
            suivi1Post_ttt.setSensibiliteS1(cryptDecrypt.encryptSensitiveInformation(p1.getSensibiliteS1()));
            suivi1Post_ttt.setExamenPerineeSensibilite(cryptDecrypt.encryptSensitiveInformation(p1.getExamenPerineeSensibilite()));
            suivi1Post_ttt.setExamenPerineeTonusAnal(cryptDecrypt.encryptSensitiveInformation(p1.getExamenPerineeTonusAnal()));
            suivi1Post_ttt.setExamenPerineeReflexeAnal(cryptDecrypt.encryptSensitiveInformation(p1.getExamenPerineeReflexeAnal()));
            suivi1Post_ttt.setHypotheseDiagnosticHD(cryptDecrypt.encryptSensitiveInformation(p1.getHypotheseDiagnosticHD()));
            suivi1Post_ttt.setHypotheseDiagnosticType(cryptDecrypt.encryptSensitiveInformation(p1.getHypotheseDiagnosticType()));
            suivi1Post_ttt.setHypotheseDiagnosticLocalisation(cryptDecrypt.encryptSensitiveInformation(p1.getHypotheseDiagnosticLocalisation()));
            suivi1Post_ttt.setHypotheseDiagnosticCote(cryptDecrypt.encryptSensitiveInformation(p1.getHypotheseDiagnosticCote()));
            suivi1Post_ttt.setTraitementPropose(cryptDecrypt.encryptSensitiveInformation(p1.getTraitementPropose()));
            suivi1Post_ttt.setTraitementProposeNbreInfiltrations(cryptDecrypt.encryptSensitiveInformation(p1.getTraitementProposeNbreInfiltrations()));
            suivi1Post_ttt.setTraitementProposeNbreSeances(cryptDecrypt.encryptSensitiveInformation(p1.getTraitementProposeNbreSeances()));
            suivi1Post_ttt.setTraitementProposeTypeChirurgie(cryptDecrypt.encryptSensitiveInformation(p1.getTraitementProposeTypeChirurgie()));
            suivi1Post_ttt.setRxStandard(cryptDecrypt.encryptSensitiveInformation(p1.getRxStandard()));
            suivi1Post_ttt.setRxStandardPincement(cryptDecrypt.encryptSensitiveInformation(p1.getRxStandardPincement()));
            suivi1Post_ttt.setRxPincementDiscalEtage(cryptDecrypt.encryptSensitiveInformation(p1.getRxPincementDiscalEtage()));
            suivi1Post_ttt.setRxPincementDiscalPourcentage(cryptDecrypt.encryptSensitiveInformation(p1.getRxPincementDiscalPourcentage()));
            suivi1Post_ttt.setRxVideDiscal(cryptDecrypt.encryptSensitiveInformation(p1.getRxVideDiscal()));
            suivi1Post_ttt.setRxVideDiscalEtage(cryptDecrypt.encryptSensitiveInformation(p1.getRxVideDiscalEtage()));
            suivi1Post_ttt.setRxSPDL(cryptDecrypt.encryptSensitiveInformation(p1.getRxSPDL()));
            suivi1Post_ttt.setRxSPDLEtage(cryptDecrypt.encryptSensitiveInformation(p1.getRxSPDLEtage()));
            suivi1Post_ttt.setRxSPDLGrade(cryptDecrypt.encryptSensitiveInformation(p1.getRxSPDLGrade()));
            suivi1Post_ttt.setRxAnomalieTransitionnelle(cryptDecrypt.encryptSensitiveInformation(p1.getRxAnomalieTransitionnelle()));
            suivi1Post_ttt.setRxCanalLombaireEtroit(cryptDecrypt.encryptSensitiveInformation(p1.getRxCanalLombaireEtroit()));
            suivi1Post_ttt.setRxLordoseLombaire(cryptDecrypt.encryptSensitiveInformation(p1.getRxLordoseLombaire()));
            suivi1Post_ttt.setRxIncidencePelvienne(cryptDecrypt.encryptSensitiveInformation(p1.getRxIncidencePelvienne()));
            suivi1Post_ttt.setRxPenteSacree(cryptDecrypt.encryptSensitiveInformation(p1.getRxPenteSacree()));
            suivi1Post_ttt.setRxVersionPerlvienne(cryptDecrypt.encryptSensitiveInformation(p1.getRxVersionPerlvienne()));
            suivi1Post_ttt.setRxDynamique(cryptDecrypt.encryptSensitiveInformation(p1.getRxDynamique()));
            suivi1Post_ttt.setRxDynamiqueQualite(cryptDecrypt.encryptSensitiveInformation(p1.getRxDynamiqueQualite()));
            suivi1Post_ttt.setRxDynamiqueInstabilite(cryptDecrypt.encryptSensitiveInformation(p1.getRxDynamiqueInstabilite()));
            suivi1Post_ttt.setTdm(cryptDecrypt.encryptSensitiveInformation(p1.getTdm()));
            suivi1Post_ttt.setTdmPincementDiscal(cryptDecrypt.encryptSensitiveInformation(p1.getTdmPincementDiscal()));
            suivi1Post_ttt.setTdmPincementDiscalEtage(cryptDecrypt.encryptSensitiveInformation(p1.getTdmPincementDiscalEtage()));
            suivi1Post_ttt.setTdmPincementDiscalPourcentage(cryptDecrypt.encryptSensitiveInformation(p1.getTdmPincementDiscalPourcentage()));
            suivi1Post_ttt.setTdmVideDiscal(cryptDecrypt.encryptSensitiveInformation(p1.getTdmVideDiscal()));
            suivi1Post_ttt.setTdmVideDiscalEtage(cryptDecrypt.encryptSensitiveInformation(p1.getTdmVideDiscalEtage()));
            suivi1Post_ttt.setTdmHernieDiscale(cryptDecrypt.encryptSensitiveInformation(p1.getTdmHernieDiscale()));
            suivi1Post_ttt.setTdmHernieDiscaleType(cryptDecrypt.encryptSensitiveInformation(p1.getTdmHernieDiscaleType()));
            suivi1Post_ttt.setTdmHernieDiscaleEtage(cryptDecrypt.encryptSensitiveInformation(p1.getTdmHernieDiscaleEtage()));
            suivi1Post_ttt.setTdmHernieDiscaleCote(cryptDecrypt.encryptSensitiveInformation(p1.getTdmHernieDiscaleCote()));
            suivi1Post_ttt.setTdmSPDL(cryptDecrypt.encryptSensitiveInformation(p1.getTdmSPDL()));
            suivi1Post_ttt.setTdmSPDLEtage(cryptDecrypt.encryptSensitiveInformation(p1.getTdmSPDLEtage()));
            suivi1Post_ttt.setTdmSPDLGrade(cryptDecrypt.encryptSensitiveInformation(p1.getTdmSPDLGrade()));
            suivi1Post_ttt.setTdmInstabilite(cryptDecrypt.encryptSensitiveInformation(p1.getTdmInstabilite()));
            suivi1Post_ttt.setTdmInstabiliteEtage(cryptDecrypt.encryptSensitiveInformation(p1.getTdmInstabiliteEtage()));
            suivi1Post_ttt.setTdmApophysaire(cryptDecrypt.encryptSensitiveInformation(p1.getTdmApophysaire()));
            suivi1Post_ttt.setTdmApophysaireEtage(cryptDecrypt.encryptSensitiveInformation(p1.getTdmApophysaireEtage()));
            suivi1Post_ttt.setTdmAnomalieTransitionnelle(cryptDecrypt.encryptSensitiveInformation(p1.getTdmAnomalieTransitionnelle()));
            suivi1Post_ttt.setTdmCanalLombaireEtroit(cryptDecrypt.encryptSensitiveInformation(p1.getTdmCanalLombaireEtroit()));
            suivi1Post_ttt.setTdmQualiteFusion(cryptDecrypt.encryptSensitiveInformation(p1.getTdmQualiteFusion()));
            suivi1Post_ttt.setIrm(cryptDecrypt.encryptSensitiveInformation(p1.getIrm()));
            suivi1Post_ttt.setIrmPincementDiscal(cryptDecrypt.encryptSensitiveInformation(p1.getIrmPincementDiscal()));
            suivi1Post_ttt.setIrmPincementDiscalEtage(cryptDecrypt.encryptSensitiveInformation(p1.getIrmPincementDiscalEtage()));
            suivi1Post_ttt.setIrmPincementDiscalPourcentage(cryptDecrypt.encryptSensitiveInformation(p1.getIrmPincementDiscalPourcentage()));
            suivi1Post_ttt.setIrmHernieDiscale(cryptDecrypt.encryptSensitiveInformation(p1.getIrmHernieDiscale()));
            suivi1Post_ttt.setIrmHernieDiscaleEtage(cryptDecrypt.encryptSensitiveInformation(p1.getIrmHernieDiscaleEtage()));
            suivi1Post_ttt.setIrmHernieDiscaleType(cryptDecrypt.encryptSensitiveInformation(p1.getIrmHernieDiscaleType()));
            suivi1Post_ttt.setIrmHernieDiscaleCote(cryptDecrypt.encryptSensitiveInformation(p1.getIrmHernieDiscaleCote()));
            suivi1Post_ttt.setIrmHypertrophieJaunes(cryptDecrypt.encryptSensitiveInformation(p1.getIrmHypertrophieJaunes()));
            suivi1Post_ttt.setIrmArthroseApophysaire(cryptDecrypt.encryptSensitiveInformation(p1.getIrmArthroseApophysaire()));
            suivi1Post_ttt.setIrmArthroseApophysaireEtage(cryptDecrypt.encryptSensitiveInformation(p1.getIrmArthroseApophysaireEtage()));
            suivi1Post_ttt.setIrmCanalLombaireEtroit(cryptDecrypt.encryptSensitiveInformation(p1.getIrmCanalLombaireEtroit()));
            suivi1Post_ttt.setIrmVolumeDisqueHernie(cryptDecrypt.encryptSensitiveInformation(p1.getIrmVolumeDisqueHernie()));
            suivi1Post_ttt.setIrmEtatDisquesSousJacent(cryptDecrypt.encryptSensitiveInformation(p1.getIrmEtatDisquesSousJacent()));
            suivi1Post_ttt.setIrmEtatDisquesSusJacent(cryptDecrypt.encryptSensitiveInformation(p1.getIrmEtatDisquesSusJacent()));

            // Save the updated entity
            Consultations_ttt_Dissect suivi1Post = suivi_ttt_dissect_repository.save(suivi1Post_ttt);
            return new ResponseEntity<>(suivi1Post, HttpStatus.OK);

    }


}
