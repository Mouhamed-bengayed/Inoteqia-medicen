package com.test.Inoteqia.Services;

import com.test.Inoteqia.Entity.ConsultationsArthrodese;
import com.test.Inoteqia.Reposotories.FichePatientRepository;
import com.test.Inoteqia.Reposotories.SuiviArthrodeseReposotories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SuiviArthrodeseServices {
    @Autowired
    CryptDecrypt cryptDecrypt;

    @Autowired
    SuiviArthrodeseReposotories suiviArthrodeseReposotories;
    @Autowired
    FichePatientRepository fichePatientRepository;

    public ResponseEntity<ConsultationsArthrodese> registerSuiviArthrodese(ConsultationsArthrodese p1, Long patientId) throws Exception {
        // Retrieve existing entity by patient ID or create a new instance
        ConsultationsArthrodese suiviArthrodese = suiviArthrodeseReposotories.findByFichePatientId(patientId)
                .orElse(new ConsultationsArthrodese());
        suiviArthrodese.setFichePatient(fichePatientRepository.findById(patientId).get());
        // Encrypt sensitive information and set it in the entity
        suiviArthrodese.setDateDeConsultation(p1.getDateDeConsultation());
        suiviArthrodese.setAge(cryptDecrypt.encryptSensitiveInformation(p1.getAge()));
        suiviArthrodese.setAddress(cryptDecrypt.encryptSensitiveInformation(p1.getAddress()));
        suiviArthrodese.setTelephone(cryptDecrypt.encryptSensitiveInformation(p1.getTelephone()));
        suiviArthrodese.setProfession(cryptDecrypt.encryptSensitiveInformation(p1.getProfession()));
        suiviArthrodese.setProfessionAutre(cryptDecrypt.encryptSensitiveInformation(p1.getProfessionAutre()));
        suiviArthrodese.setStatutSocial(cryptDecrypt.encryptSensitiveInformation(p1.getStatutSocial()));
        suiviArthrodese.setEntourageActuel(cryptDecrypt.encryptSensitiveInformation(p1.getEntourageActuel()));
        suiviArthrodese.setTabac(cryptDecrypt.encryptSensitiveInformation(p1.getTabac()));
        suiviArthrodese.setEvolution(cryptDecrypt.encryptSensitiveInformation(p1.getEvolution()));
        suiviArthrodese.setEvolutionNouvellesSymptomatologies(cryptDecrypt.encryptListeSensitiveInformation(p1.getEvolutionNouvellesSymptomatologies()));
        suiviArthrodese.setLombalgieType(cryptDecrypt.encryptSensitiveInformation(p1.getLombalgieType()));
        suiviArthrodese.setLombalgieIntensity(cryptDecrypt.encryptSensitiveInformation(p1.getLombalgieIntensity()));
        suiviArthrodese.setLombalgieMode(cryptDecrypt.encryptSensitiveInformation(p1.getLombalgieMode()));
        suiviArthrodese.setLombalgieVolution(cryptDecrypt.encryptSensitiveInformation(p1.getLombalgieVolution()));
        suiviArthrodese.setLombalgieResponse(cryptDecrypt.encryptSensitiveInformation(p1.getLombalgieResponse()));
        suiviArthrodese.setSciatiqueLocalisation(cryptDecrypt.encryptSensitiveInformation(p1.getSciatiqueLocalisation()));
        suiviArthrodese.setSciatiqueCote(cryptDecrypt.encryptSensitiveInformation(p1.getSciatiqueCote()));
        suiviArthrodese.setSciatiqueIntensity(cryptDecrypt.encryptSensitiveInformation(p1.getSciatiqueIntensity()));
        suiviArthrodese.setSciatiqueMode(cryptDecrypt.encryptSensitiveInformation(p1.getSciatiqueMode()));
        suiviArthrodese.setSciatiqueVolution(cryptDecrypt.encryptSensitiveInformation(p1.getSciatiqueVolution()));
        suiviArthrodese.setSciatiqueResponse(cryptDecrypt.encryptSensitiveInformation(p1.getSciatiqueResponse()));
        suiviArthrodese.setCruralgieLocalisation(cryptDecrypt.encryptSensitiveInformation(p1.getCruralgieLocalisation()));
        suiviArthrodese.setCruralgieCote(cryptDecrypt.encryptSensitiveInformation(p1.getCruralgieCote()));
        suiviArthrodese.setCruralgieIntensity(cryptDecrypt.encryptSensitiveInformation(p1.getCruralgieIntensity()));
        suiviArthrodese.setCruralgieMode(cryptDecrypt.encryptSensitiveInformation(p1.getCruralgieMode()));
        suiviArthrodese.setCruralgieVolution(cryptDecrypt.encryptSensitiveInformation(p1.getCruralgieVolution()));
        suiviArthrodese.setCruralgieResponse(cryptDecrypt.encryptSensitiveInformation(p1.getCruralgieResponse()));
        suiviArthrodese.setClaudicationType(cryptDecrypt.encryptSensitiveInformation(p1.getClaudicationType()));
        suiviArthrodese.setClaudicationCote(cryptDecrypt.encryptSensitiveInformation(p1.getClaudicationCote()));
        suiviArthrodese.setDerobementType(cryptDecrypt.encryptSensitiveInformation(p1.getDerobementType()));
        suiviArthrodese.setDerobementCote(cryptDecrypt.encryptSensitiveInformation(p1.getDerobementCote()));
        suiviArthrodese.setTroubleSphincteriens(cryptDecrypt.encryptSensitiveInformation(p1.getTroubleSphincteriens()));
        suiviArthrodese.setTroubleSphincteriensUrinaire(cryptDecrypt.encryptSensitiveInformation(p1.getTroubleSphincteriensUrinaire()));
        suiviArthrodese.setPm(cryptDecrypt.encryptSensitiveInformation(p1.getPm()));
        suiviArthrodese.setPmDistance(cryptDecrypt.encryptSensitiveInformation(p1.getPmDistance()));
        suiviArthrodese.setPmCauseArret(cryptDecrypt.encryptSensitiveInformation(p1.getPmCauseArret()));
        suiviArthrodese.setResultat(cryptDecrypt.encryptSensitiveInformation(p1.getResultat()));
        suiviArthrodese.setPoids(cryptDecrypt.encryptSensitiveInformation(p1.getPoids()));
        suiviArthrodese.setTaille(cryptDecrypt.encryptSensitiveInformation(p1.getTaille()));
        suiviArthrodese.setBmi(cryptDecrypt.encryptSensitiveInformation(p1.getBmi()));
        suiviArthrodese.setDeformationRachidienne(cryptDecrypt.encryptSensitiveInformation(p1.getDeformationRachidienne()));
        suiviArthrodese.setDouleurPressionLombairerEpineuses(cryptDecrypt.encryptSensitiveInformation(p1.getDouleurPressionLombairerEpineuses()));
        suiviArthrodese.setAmeliorationFlexionRachis(cryptDecrypt.encryptSensitiveInformation(p1.getAmeliorationFlexionRachis()));
        suiviArthrodese.setContractureMusclesParavertebraux(cryptDecrypt.encryptSensitiveInformation(p1.getContractureMusclesParavertebraux()));
        suiviArthrodese.setDms(cryptDecrypt.encryptSensitiveInformation(p1.getDms()));
        suiviArthrodese.setSonnette(cryptDecrypt.encryptSensitiveInformation(p1.getSonnette()));
        suiviArthrodese.setSonnetteNiveau(cryptDecrypt.encryptSensitiveInformation(p1.getSonnetteNiveau()));
        suiviArthrodese.setLasegue(cryptDecrypt.encryptSensitiveInformation(p1.getLasegue()));
        suiviArthrodese.setLasegueControlateral(cryptDecrypt.encryptSensitiveInformation(p1.getLasegueControlateral()));
        suiviArthrodese.setLeri(cryptDecrypt.encryptSensitiveInformation(p1.getLeri()));
        suiviArthrodese.setIndiceShober(cryptDecrypt.encryptSensitiveInformation(p1.getIndiceShober()));
        suiviArthrodese.setRotRotulien(cryptDecrypt.encryptSensitiveInformation(p1.getRotRotulien()));
        suiviArthrodese.setRotAchillien(cryptDecrypt.encryptSensitiveInformation(p1.getRotAchillien()));
        suiviArthrodese.setRotPerinee(cryptDecrypt.encryptSensitiveInformation(p1.getRotPerinee()));
        suiviArthrodese.setMarcheTalons(cryptDecrypt.encryptSensitiveInformation(p1.getMarcheTalons()));
        suiviArthrodese.setMarchePointesPieds(cryptDecrypt.encryptSensitiveInformation(p1.getMarchePointesPieds()));
        suiviArthrodese.setTestingMusculaireL2(cryptDecrypt.encryptSensitiveInformation(p1.getTestingMusculaireL2()));
        suiviArthrodese.setTestingMusculaireL3(cryptDecrypt.encryptSensitiveInformation(p1.getTestingMusculaireL3()));
        suiviArthrodese.setTestingMusculaireL4(cryptDecrypt.encryptSensitiveInformation(p1.getTestingMusculaireL4()));
        suiviArthrodese.setTestingMusculaireL5(cryptDecrypt.encryptSensitiveInformation(p1.getTestingMusculaireL5()));
        suiviArthrodese.setTestingMusculaireS1(cryptDecrypt.encryptSensitiveInformation(p1.getTestingMusculaireS1()));
        suiviArthrodese.setSensibiliteL2(cryptDecrypt.encryptSensitiveInformation(p1.getSensibiliteL2()));
        suiviArthrodese.setSensibiliteL3(cryptDecrypt.encryptSensitiveInformation(p1.getSensibiliteL3()));
        suiviArthrodese.setSensibiliteL4(cryptDecrypt.encryptSensitiveInformation(p1.getSensibiliteL4()));
        suiviArthrodese.setSensibiliteL5(cryptDecrypt.encryptSensitiveInformation(p1.getSensibiliteL5()));
        suiviArthrodese.setSensibiliteS1(cryptDecrypt.encryptSensitiveInformation(p1.getSensibiliteS1()));
        suiviArthrodese.setExamenPerineeSensibilite(cryptDecrypt.encryptSensitiveInformation(p1.getExamenPerineeSensibilite()));
        suiviArthrodese.setExamenPerineeTonusAnal(cryptDecrypt.encryptSensitiveInformation(p1.getExamenPerineeTonusAnal()));
        suiviArthrodese.setExamenPerineeReflexeAnal(cryptDecrypt.encryptSensitiveInformation(p1.getExamenPerineeReflexeAnal()));
        suiviArthrodese.setHypotheseDiagnosticHD(cryptDecrypt.encryptSensitiveInformation(p1.getHypotheseDiagnosticHD()));
        suiviArthrodese.setHypotheseDiagnosticType(cryptDecrypt.encryptSensitiveInformation(p1.getHypotheseDiagnosticType()));
        suiviArthrodese.setHypotheseDiagnosticLocalisation(cryptDecrypt.encryptSensitiveInformation(p1.getHypotheseDiagnosticLocalisation()));
        suiviArthrodese.setHypotheseDiagnosticCote(cryptDecrypt.encryptSensitiveInformation(p1.getHypotheseDiagnosticCote()));
        suiviArthrodese.setTraitementPropose(cryptDecrypt.encryptSensitiveInformation(p1.getTraitementPropose()));
        suiviArthrodese.setTraitementProposeNbreInfiltrations(cryptDecrypt.encryptSensitiveInformation(p1.getTraitementProposeNbreInfiltrations()));
        suiviArthrodese.setTraitementProposeNbreSeances(cryptDecrypt.encryptSensitiveInformation(p1.getTraitementProposeNbreSeances()));
        suiviArthrodese.setTraitementProposeTypeChirurgie(cryptDecrypt.encryptSensitiveInformation(p1.getTraitementProposeTypeChirurgie()));
        suiviArthrodese.setRxStandard(cryptDecrypt.encryptSensitiveInformation(p1.getRxStandard()));
        suiviArthrodese.setRxStandardPincement(cryptDecrypt.encryptSensitiveInformation(p1.getRxStandardPincement()));
        suiviArthrodese.setRxPincementDiscalEtage(cryptDecrypt.encryptSensitiveInformation(p1.getRxPincementDiscalEtage()));
        suiviArthrodese.setRxPincementDiscalPourcentage(cryptDecrypt.encryptSensitiveInformation(p1.getRxPincementDiscalPourcentage()));
        suiviArthrodese.setRxVideDiscal(cryptDecrypt.encryptSensitiveInformation(p1.getRxVideDiscal()));
        suiviArthrodese.setRxVideDiscalEtage(cryptDecrypt.encryptSensitiveInformation(p1.getRxVideDiscalEtage()));
        suiviArthrodese.setRxSPDL(cryptDecrypt.encryptSensitiveInformation(p1.getRxSPDL()));
        suiviArthrodese.setRxSPDLEtage(cryptDecrypt.encryptSensitiveInformation(p1.getRxSPDLEtage()));
        suiviArthrodese.setRxSPDLGrade(cryptDecrypt.encryptSensitiveInformation(p1.getRxSPDLGrade()));
        suiviArthrodese.setRxAnomalieTransitionnelle(cryptDecrypt.encryptSensitiveInformation(p1.getRxAnomalieTransitionnelle()));
        suiviArthrodese.setRxCanalLombaireEtroit(cryptDecrypt.encryptSensitiveInformation(p1.getRxCanalLombaireEtroit()));
        suiviArthrodese.setRxLordoseLombaire(cryptDecrypt.encryptSensitiveInformation(p1.getRxLordoseLombaire()));
        suiviArthrodese.setRxIncidencePelvienne(cryptDecrypt.encryptSensitiveInformation(p1.getRxIncidencePelvienne()));
        suiviArthrodese.setRxPenteSacree(cryptDecrypt.encryptSensitiveInformation(p1.getRxPenteSacree()));
        suiviArthrodese.setRxVersionPerlvienne(cryptDecrypt.encryptSensitiveInformation(p1.getRxVersionPerlvienne()));
        suiviArthrodese.setRxDynamique(cryptDecrypt.encryptSensitiveInformation(p1.getRxDynamique()));
        suiviArthrodese.setRxDynamiqueQualite(cryptDecrypt.encryptSensitiveInformation(p1.getRxDynamiqueQualite()));
        suiviArthrodese.setRxDynamiqueInstabilite(cryptDecrypt.encryptSensitiveInformation(p1.getRxDynamiqueInstabilite()));
        suiviArthrodese.setTdm(cryptDecrypt.encryptSensitiveInformation(p1.getTdm()));
        suiviArthrodese.setTdmPincementDiscal(cryptDecrypt.encryptSensitiveInformation(p1.getTdmPincementDiscal()));
        suiviArthrodese.setTdmPincementDiscalEtage(cryptDecrypt.encryptSensitiveInformation(p1.getTdmPincementDiscalEtage()));
        suiviArthrodese.setTdmPincementDiscalPourcentage(cryptDecrypt.encryptSensitiveInformation(p1.getTdmPincementDiscalPourcentage()));
        suiviArthrodese.setTdmVideDiscal(cryptDecrypt.encryptSensitiveInformation(p1.getTdmVideDiscal()));
        suiviArthrodese.setTdmVideDiscalEtage(cryptDecrypt.encryptSensitiveInformation(p1.getTdmVideDiscalEtage()));
        suiviArthrodese.setTdmHernieDiscale(cryptDecrypt.encryptSensitiveInformation(p1.getTdmHernieDiscale()));
        suiviArthrodese.setTdmHernieDiscaleType(cryptDecrypt.encryptSensitiveInformation(p1.getTdmHernieDiscaleType()));
        suiviArthrodese.setTdmHernieDiscaleEtage(cryptDecrypt.encryptSensitiveInformation(p1.getTdmHernieDiscaleEtage()));
        suiviArthrodese.setTdmHernieDiscaleCote(cryptDecrypt.encryptSensitiveInformation(p1.getTdmHernieDiscaleCote()));
        suiviArthrodese.setTdmSPDL(cryptDecrypt.encryptSensitiveInformation(p1.getTdmSPDL()));
        suiviArthrodese.setTdmSPDLEtage(cryptDecrypt.encryptSensitiveInformation(p1.getTdmSPDLEtage()));
        suiviArthrodese.setTdmSPDLGrade(cryptDecrypt.encryptSensitiveInformation(p1.getTdmSPDLGrade()));
        suiviArthrodese.setTdmInstabilite(cryptDecrypt.encryptSensitiveInformation(p1.getTdmInstabilite()));
        suiviArthrodese.setTdmInstabiliteEtage(cryptDecrypt.encryptSensitiveInformation(p1.getTdmInstabiliteEtage()));
        suiviArthrodese.setTdmApophysaire(cryptDecrypt.encryptSensitiveInformation(p1.getTdmApophysaire()));
        suiviArthrodese.setTdmApophysaireEtage(cryptDecrypt.encryptSensitiveInformation(p1.getTdmApophysaireEtage()));
        suiviArthrodese.setTdmAnomalieTransitionnelle(cryptDecrypt.encryptSensitiveInformation(p1.getTdmAnomalieTransitionnelle()));
        suiviArthrodese.setTdmCanalLombaireEtroit(cryptDecrypt.encryptSensitiveInformation(p1.getTdmCanalLombaireEtroit()));
        suiviArthrodese.setTdmQualiteFusion(cryptDecrypt.encryptSensitiveInformation(p1.getTdmQualiteFusion()));
        suiviArthrodese.setIrm(cryptDecrypt.encryptSensitiveInformation(p1.getIrm()));
        suiviArthrodese.setIrmPincementDiscal(cryptDecrypt.encryptSensitiveInformation(p1.getIrmPincementDiscal()));
        suiviArthrodese.setIrmPincementDiscalEtage(cryptDecrypt.encryptSensitiveInformation(p1.getIrmPincementDiscalEtage()));
        suiviArthrodese.setIrmPincementDiscalPourcentage(cryptDecrypt.encryptSensitiveInformation(p1.getIrmPincementDiscalPourcentage()));
        suiviArthrodese.setIrmHernieDiscale(cryptDecrypt.encryptSensitiveInformation(p1.getIrmHernieDiscale()));
        suiviArthrodese.setIrmHernieDiscaleEtage(cryptDecrypt.encryptSensitiveInformation(p1.getIrmHernieDiscaleEtage()));
        suiviArthrodese.setIrmHernieDiscaleType(cryptDecrypt.encryptSensitiveInformation(p1.getIrmHernieDiscaleType()));
        suiviArthrodese.setIrmHernieDiscaleCote(cryptDecrypt.encryptSensitiveInformation(p1.getIrmHernieDiscaleCote()));
        suiviArthrodese.setIrmHypertrophieJaunes(cryptDecrypt.encryptSensitiveInformation(p1.getIrmHypertrophieJaunes()));
        suiviArthrodese.setIrmArthroseApophysaire(cryptDecrypt.encryptSensitiveInformation(p1.getIrmArthroseApophysaire()));
        suiviArthrodese.setIrmArthroseApophysaireEtage(cryptDecrypt.encryptSensitiveInformation(p1.getIrmArthroseApophysaireEtage()));
        suiviArthrodese.setIrmCanalLombaireEtroit(cryptDecrypt.encryptSensitiveInformation(p1.getIrmCanalLombaireEtroit()));
        suiviArthrodese.setIrmVolumeDisqueHernie(cryptDecrypt.encryptSensitiveInformation(p1.getIrmVolumeDisqueHernie()));
        suiviArthrodese.setIrmEtatDisquesSousJacent(cryptDecrypt.encryptSensitiveInformation(p1.getIrmEtatDisquesSousJacent()));
        suiviArthrodese.setIrmEtatDisquesSusJacent(cryptDecrypt.encryptSensitiveInformation(p1.getIrmEtatDisquesSusJacent()));

        // Save the updated or new entity
        ConsultationsArthrodese savedSuiviArthrodese = suiviArthrodeseReposotories.save(suiviArthrodese);

        // Return appropriate response
        if (savedSuiviArthrodese != null) {
            return new ResponseEntity<>(savedSuiviArthrodese, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}