package com.test.Inoteqia.Services;

import com.test.Inoteqia.Entity.ConsultationsArthrodese;
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

    public ResponseEntity<ConsultationsArthrodese> registerSuiviArthrodese(ConsultationsArthrodese p1) throws Exception {
        ConsultationsArthrodese suiviArthrodese = new ConsultationsArthrodese(
                cryptDecrypt.encryptSensitiveInformation(p1.getDateDeConsultation()),
                cryptDecrypt.encryptSensitiveInformation(p1.getAge()),
                cryptDecrypt.encryptSensitiveInformation(p1.getAddress()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTelephone()),
                cryptDecrypt.encryptSensitiveInformation(p1.getProfession()),
                cryptDecrypt.encryptSensitiveInformation(p1.getProfessionAutre()),
                cryptDecrypt.encryptSensitiveInformation(p1.getStatutSocial()),
                cryptDecrypt.encryptSensitiveInformation(p1.getEntourageActuel()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTabac()),
                cryptDecrypt.encryptSensitiveInformation(p1.getEvolution()),
                cryptDecrypt.encryptListeSensitiveInformation(p1.getEvolutionNouvellesSymptomatologies()),
                cryptDecrypt.encryptSensitiveInformation(p1.getLombalgieType()),
                cryptDecrypt.encryptSensitiveInformation(p1.getLombalgieIntensity()),
                cryptDecrypt.encryptSensitiveInformation(p1.getLombalgieMode()),
                cryptDecrypt.encryptSensitiveInformation(p1.getLombalgieVolution()),
                cryptDecrypt.encryptSensitiveInformation(p1.getLombalgieResponse()),
                cryptDecrypt.encryptSensitiveInformation(p1.getSciatiqueLocalisation()),
                cryptDecrypt.encryptSensitiveInformation(p1.getSciatiqueCote()),
                cryptDecrypt.encryptSensitiveInformation(p1.getSciatiqueIntensity()),
                cryptDecrypt.encryptSensitiveInformation(p1.getSciatiqueMode()),
                cryptDecrypt.encryptSensitiveInformation(p1.getSciatiqueVolution()),
                cryptDecrypt.encryptSensitiveInformation(p1.getSciatiqueResponse()),
                cryptDecrypt.encryptSensitiveInformation(p1.getCruralgieLocalisation()),
                cryptDecrypt.encryptSensitiveInformation(p1.getCruralgieCote()),
                cryptDecrypt.encryptSensitiveInformation(p1.getCruralgieIntensity()),
                cryptDecrypt.encryptSensitiveInformation(p1.getCruralgieMode()),
                cryptDecrypt.encryptSensitiveInformation(p1.getCruralgieVolution()),
                cryptDecrypt.encryptSensitiveInformation(p1.getCruralgieResponse()),
                cryptDecrypt.encryptSensitiveInformation(p1.getClaudicationType()),
                cryptDecrypt.encryptSensitiveInformation(p1.getClaudicationCote()),
                cryptDecrypt.encryptSensitiveInformation(p1.getDerobementType()),
                cryptDecrypt.encryptSensitiveInformation(p1.getDerobementCote()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTroubleSphincteriens()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTroubleSphincteriensUrinaire()),
                cryptDecrypt.encryptSensitiveInformation(p1.getPm()),
                cryptDecrypt.encryptSensitiveInformation(p1.getPmDistance()),
                cryptDecrypt.encryptSensitiveInformation(p1.getPmCauseArret()),
                cryptDecrypt.encryptSensitiveInformation(p1.getResultat()),
                cryptDecrypt.encryptSensitiveInformation(p1.getPoids()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTaille()),
                cryptDecrypt.encryptSensitiveInformation(p1.getBmi()),
                cryptDecrypt.encryptSensitiveInformation(p1.getDeformationRachidienne()),
                cryptDecrypt.encryptSensitiveInformation(p1.getDouleurPressionLombairerEpineuses()),
                cryptDecrypt.encryptSensitiveInformation(p1.getAmeliorationFlexionRachis()),
                cryptDecrypt.encryptSensitiveInformation(p1.getContractureMusclesParavertebraux()),
                cryptDecrypt.encryptSensitiveInformation(p1.getDms()),
                cryptDecrypt.encryptSensitiveInformation(p1.getSonnette()),
                cryptDecrypt.encryptSensitiveInformation(p1.getSonnetteNiveau()),
                cryptDecrypt.encryptSensitiveInformation(p1.getLasegue()),
                cryptDecrypt.encryptSensitiveInformation(p1.getLasegueControlateral()),
                cryptDecrypt.encryptSensitiveInformation(p1.getLeri()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIndiceShober()),
                cryptDecrypt.encryptSensitiveInformation(p1.getRotRotulien()),
                cryptDecrypt.encryptSensitiveInformation(p1.getRotAchillien()),
                cryptDecrypt.encryptSensitiveInformation(p1.getRotPerinee()),
                cryptDecrypt.encryptSensitiveInformation(p1.getMarcheTalons()),
                cryptDecrypt.encryptSensitiveInformation(p1.getMarchePointesPieds()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTestingMusculaireL2()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTestingMusculaireL3()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTestingMusculaireL4()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTestingMusculaireL5()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTestingMusculaireS1()),
                cryptDecrypt.encryptSensitiveInformation(p1.getSensibiliteL2()),
                cryptDecrypt.encryptSensitiveInformation(p1.getSensibiliteL3()),
                cryptDecrypt.encryptSensitiveInformation(p1.getSensibiliteL4()),
                cryptDecrypt.encryptSensitiveInformation(p1.getSensibiliteL5()),
                cryptDecrypt.encryptSensitiveInformation(p1.getSensibiliteS1()),
                cryptDecrypt.encryptSensitiveInformation(p1.getExamenPerineeSensibilite()),
                cryptDecrypt.encryptSensitiveInformation(p1.getExamenPerineeTonusAnal()),
                cryptDecrypt.encryptSensitiveInformation(p1.getExamenPerineeReflexeAnal()),
                cryptDecrypt.encryptSensitiveInformation(p1.getHypotheseDiagnosticHD()),
                cryptDecrypt.encryptSensitiveInformation(p1.getHypotheseDiagnosticType()),
                cryptDecrypt.encryptSensitiveInformation(p1.getHypotheseDiagnosticLocalisation()),
                cryptDecrypt.encryptSensitiveInformation(p1.getHypotheseDiagnosticCote()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTraitementPropose()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTraitementProposeNbreInfiltrations()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTraitementProposeNbreSeances()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTraitementProposeTypeChirurgie()),
                cryptDecrypt.encryptSensitiveInformation(p1.getRxStandard()),
                cryptDecrypt.encryptSensitiveInformation(p1.getRxStandardPincement()),
                cryptDecrypt.encryptSensitiveInformation(p1.getRxPincementDiscalEtage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getRxPincementDiscalPourcentage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getRxVideDiscal()),
                cryptDecrypt.encryptSensitiveInformation(p1.getRxVideDiscalEtage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getRxSPDL()),
                cryptDecrypt.encryptSensitiveInformation(p1.getRxSPDLEtage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getRxSPDLGrade()),
                cryptDecrypt.encryptSensitiveInformation(p1.getRxAnomalieTransitionnelle()),
                cryptDecrypt.encryptSensitiveInformation(p1.getRxCanalLombaireEtroit()),
                cryptDecrypt.encryptSensitiveInformation(p1.getRxLordoseLombaire()),
                cryptDecrypt.encryptSensitiveInformation(p1.getRxIncidencePelvienne()),
                cryptDecrypt.encryptSensitiveInformation(p1.getRxPenteSacree()),
                cryptDecrypt.encryptSensitiveInformation(p1.getRxVersionPerlvienne()),
                cryptDecrypt.encryptSensitiveInformation(p1.getRxDynamique()),
                cryptDecrypt.encryptSensitiveInformation(p1.getRxDynamiqueQualite()),
                cryptDecrypt.encryptSensitiveInformation(p1.getRxDynamiqueInstabilite()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTdm()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTdmPincementDiscal()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTdmPincementDiscalEtage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTdmPincementDiscalPourcentage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTdmVideDiscal()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTdmVideDiscalEtage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTdmHernieDiscale()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTdmHernieDiscaleType()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTdmHernieDiscaleEtage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTdmHernieDiscaleCote()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTdmSPDL()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTdmSPDLEtage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTdmSPDLGrade()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTdmInstabilite()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTdmInstabiliteEtage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTdmApophysaire()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTdmApophysaireEtage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTdmAnomalieTransitionnelle()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTdmCanalLombaireEtroit()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTdmQualiteFusion()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIrm()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIrmPincementDiscal()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIrmPincementDiscalEtage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIrmPincementDiscalPourcentage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIrmHernieDiscale()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIrmHernieDiscaleEtage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIrmHernieDiscaleType()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIrmHernieDiscaleCote()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIrmHypertrophieJaunes()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIrmArthroseApophysaire()),
        cryptDecrypt.encryptSensitiveInformation(p1.getIrmArthroseApophysaireEtage()),
        cryptDecrypt.encryptSensitiveInformation(p1.getIrmCanalLombaireEtroit()),
        cryptDecrypt.encryptSensitiveInformation(p1.getIrmVolumeDisqueHernie()),
        cryptDecrypt.encryptSensitiveInformation(p1.getIrmEtatDisquesSousJacent()),
        cryptDecrypt.encryptSensitiveInformation(p1.getIrmEtatDisquesSusJacent())
        );

        if (suiviArthrodese != null) {
            ConsultationsArthrodese suivi1Post = suiviArthrodeseReposotories.save(suiviArthrodese);
            return new ResponseEntity<ConsultationsArthrodese>(suivi1Post, HttpStatus.OK);
        } else
        {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
