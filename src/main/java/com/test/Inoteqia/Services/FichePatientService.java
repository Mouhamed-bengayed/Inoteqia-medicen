package com.test.Inoteqia.Services;

import com.test.Inoteqia.Entity.*;
import com.test.Inoteqia.Reposotories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FichePatientService {
@Autowired
private Suivi_ttt_Dissect_Repository consultations_ttt_dissectRepository;
@Autowired
private Suivi1Post_immediatRrepository consultations1PostImmediatRepository;
@Autowired
private SuiviArthrodeseReposotories consultationsArthrodeseRepository;
@Autowired
private StafffRepository stafffRepository;

    @Autowired
    private FichePatientRepository fichePatientRepository;
@Autowired
private MedecinRepository medecinRepository;
@Autowired
private AdministrateurRepository administrateurRepository;

    @Autowired
    CryptDecrypt cryptDecrypt;


    public ResponseEntity<FichePatient> registerPatient(FichePatient p1, Long id, String isSpecialTreatmentSelected) {

        FichePatient savedPatient;
        try {
            savedPatient = new FichePatient(
                   p1.getDateDeConsultation(),
                    cryptDecrypt.encryptSensitiveInformation(p1.getDossierMedical()),
                    cryptDecrypt.encryptSensitiveInformation(p1.getNDossierMedical()),
                    cryptDecrypt.encryptSensitiveInformation(p1.getDossierMedicalNum()),
                    cryptDecrypt.encryptSensitiveInformation(p1.getName()),
                    cryptDecrypt.encryptSensitiveInformation(p1.getUsername()),
                    cryptDecrypt.encryptSensitiveInformation(p1.getSexe()),
                    cryptDecrypt.encryptSensitiveInformation(p1.getAnneeDeNaissance()),
                    cryptDecrypt.encryptSensitiveInformation(p1.getOrigine()),
                    cryptDecrypt.encryptSensitiveInformation(p1.getIdPatient()),
                    cryptDecrypt.encryptSensitiveInformation(p1.getAddresse()),
                    cryptDecrypt.encryptSensitiveInformation(p1.getTelephone()),
                    cryptDecrypt.encryptSensitiveInformation(p1.getProfession()),
                    cryptDecrypt.encryptSensitiveInformation(p1.getAdressePar()),
                    cryptDecrypt.encryptSensitiveInformation(p1.getStatutSocial()),
                    cryptDecrypt.encryptSensitiveInformation(p1.getEntourageActuel()),
                    cryptDecrypt.encryptListeSensitiveInformation(p1.getAtcd()),
                    cryptDecrypt.encryptSensitiveInformation(p1.getTabac()),
                    cryptDecrypt.encryptSensitiveInformation(p1.getAucn()),
                    cryptDecrypt.encryptSensitiveInformation(p1.getDateDebutMaladie()),
                    cryptDecrypt.encryptSensitiveInformation(p1.getDepuis()),
                    cryptDecrypt.encryptSensitiveInformation(p1.getFactureDeclanchants()),
                    cryptDecrypt.encryptSensitiveInformation(p1.getDate1consultationMedicale()),
                    cryptDecrypt.encryptSensitiveInformation(p1.getDate1consultationSpecialisee()),
                    cryptDecrypt.encryptSensitiveInformation(p1.getMedecinDeTraitants()),
                    cryptDecrypt.encryptSensitiveInformation(p1.getMedecinsTraitants()),
                    cryptDecrypt.encryptSensitiveInformation(p1.getTraitantsAnterieur()),
                    cryptDecrypt.encryptSensitiveInformation(p1.getNbreSeances()),
                    cryptDecrypt.encryptSensitiveInformation(p1.getBreInfiltration()),
                    cryptDecrypt.encryptSensitiveInformation(p1.getEvalution()),
                    cryptDecrypt.encryptSensitiveInformation(p1.getNSymptomatologies()),
                    cryptDecrypt.encryptSensitiveInformation(p1.getIndicationChirurgicale()),
                    cryptDecrypt.encryptSensitiveInformation(p1.getDate()),
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
                    isSpecialTreatmentSelected,
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

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // Find the Medecin and Administrateur by their IDs
        Administrateur administrateur = administrateurRepository.findById(id).orElse(null);
        Medecin medecin = medecinRepository.findById(id).orElse(null);

        // Set the Medecin and Administrateur to the FichePatient
        savedPatient.setMedecin(medecin);
        savedPatient.setAdministrateur(administrateur);
//        savedPatient.setTraitementPropose(isSpecialTreatmentSelected);
        fichePatientRepository.save(savedPatient);

        // If special treatment is selected, create and save the Consultations_ttt_Dissect instance
        if (isSpecialTreatmentSelected.equals("antalgique")||isSpecialTreatmentSelected.equals("infiltrations")||
                isSpecialTreatmentSelected.equals("corticoide")||isSpecialTreatmentSelected.equals("reeducation")
                ||isSpecialTreatmentSelected.equals("Anti inflammatoire non stéroidien")||isSpecialTreatmentSelected.equals("autre")
        )

        {
            Consultations_ttt_Dissect consultations_ttt_dissect = new Consultations_ttt_Dissect();
            consultations_ttt_dissect.setFichePatient(savedPatient);
            savedPatient.getConsultationsTttDissects().add(consultations_ttt_dissect);
            consultations_ttt_dissectRepository.save(consultations_ttt_dissect);
        }
        if (isSpecialTreatmentSelected.equals("Discectomie")||isSpecialTreatmentSelected.equals("Arthrodèse")){
            Consultations1Post_Immediat consultationPost_Immediat = new Consultations1Post_Immediat();
            consultationPost_Immediat.setFichePatient(savedPatient);
            savedPatient.getConsultations1PostImmediats().add(consultationPost_Immediat);
            consultations1PostImmediatRepository.save(consultationPost_Immediat);
        }
        if (isSpecialTreatmentSelected.equals("Arthrodèse")){
            ConsultationsArthrodese consultationsArthrodese = new ConsultationsArthrodese();
            consultationsArthrodese.setFichePatient(savedPatient);
            savedPatient.getConsultationsArthrodeses().add(consultationsArthrodese);
            consultationsArthrodeseRepository.save(consultationsArthrodese);
        }
        if (isSpecialTreatmentSelected.equals("Staff")){
            Staff stafff = new Staff();
            stafff.setFichePatient(savedPatient);
            savedPatient.getStaffs().add(stafff);
            stafffRepository.save(stafff);
        }
        fichePatientRepository.save(savedPatient);


        return ResponseEntity.ok(savedPatient);
    }



    public ResponseEntity<FichePatient> updatePatient (FichePatient p1) {
        FichePatient savedPatient = fichePatientRepository.save(p1);
        return ResponseEntity.ok(savedPatient);
           }

    public ResponseEntity<FichePatient> deletePatient(Long id) {
        return fichePatientRepository.findById(id)
                .map(patient -> {
                    fichePatientRepository.delete(patient);
                    return ResponseEntity.ok(patient);
                })
                .orElse(ResponseEntity.notFound().build());
    }
    public List<FichePatient> getAllPatient(Long id) throws Exception {
        List<FichePatient> patients = new ArrayList<>();

        // Check if id is for Administrateur or Medecin and fetch accordingly
        if (id != null) {
//            patients.addAll(fichePatientRepository.findAllByAdministrateurId(id));
            patients.addAll(fichePatientRepository.findAllByMedecinId(id));
        } else {
            throw new Exception("ID cannot be null");
        }

        return patients;
    }
    public FichePatient getPatientById(Long id) {
        return fichePatientRepository.findById(id).orElse(null);
    }
}
