package com.test.Inoteqia.Services;

import com.test.Inoteqia.DTO.ConsultationsDto;
import com.test.Inoteqia.Entity.Consultations_ttt_Dissect;
import com.test.Inoteqia.Entity.FichePatient;
import com.test.Inoteqia.Reposotories.FichePatientRepository;
import com.test.Inoteqia.Reposotories.Suivi_ttt_Dissect_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@Service
//public class Suivi_ttt_Dissect_Services {
//
//    @Autowired
//    CryptDecrypt cryptDecrypt;
//    @Autowired
//    Suivi_ttt_Dissect_Repository suivi_ttt_dissect_repository;
//@Autowired
//    FichePatientRepository fichePatientRepository;
//    public ResponseEntity<Consultations_ttt_Dissect> registerSuivittt_Dissect(Consultations_ttt_Dissect p1,Long patientId) throws Exception {
//        Optional<FichePatient> fichePatient = fichePatientRepository.findById(patientId);
//        Consultations_ttt_Dissect suivi1Post_ttt=suivi_ttt_dissect_repository.findByFichePatientId(patientId);
//       suivi1Post_ttt.builder()
//
//                cryptDecrypt.encryptSensitiveInformation(p1.getDate_de_consultation()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getAge()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getAddresse()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTelephone()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getProfession()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getStatut_social()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getEntourage_actuel()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getAtcd()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTabac()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getEvolution()),
//                cryptDecrypt.encryptListeSensitiveInformation(p1.getEvolution_nouvelles_symptomatologies()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getPoids()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTaille()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getBMI()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getDeformation_rachidienne()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getDouleur_pression_lombairer_epineuses()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getAmelioration_flexion_rachis()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getContracture_muscles_paravertebraux()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getDMS()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getSonnette()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getSonnette_Niveau()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getLasegue()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getLasegue_controlateral()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getLeri()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getIndice_shober()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getROT_rotulien()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getROT_achillien()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getROT_perinee()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getMarche_talons()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getMarche_pointes_pieds()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTesting_musculaire_L2()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTesting_musculaire_L3()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTesting_musculaire_L4()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTesting_musculaire_L5()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTesting_musculaire_S1()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getSensibilte_L2()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getSensibilte_L3()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getSensibilte_L4()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getSensibilte_L5()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getSensibilte_S1()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getExamen_perinee_sensibilite()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getExamen_perinee_Tonus_anal()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getExamen_perinee_Reflexe_anal()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getIntensite_douleur()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getSoins_personnels()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getLevee()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getMarche()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getAssis()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getDebout()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getSommeil()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getVie_sexuelle()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getVie_sociale()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getVoyage()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getResultat()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getHypothese_diagnostic_HD()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getHypothese_diagnostic_type()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getHypothese_diagnostic_Localisation()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTraitement_propose()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTraitement_propose_Nbre_infiltrations()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTraitement_propose_Nbre_seances()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTraitement_propose_Type_chirurgie()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTraitement_propose_Auter()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getRx_standard()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getRx_standard_qualite()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getPincement_discal()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getPincement_discal_etage()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getPincement_discal_Pourcentage()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getVide_discal()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getVide_discal_etage()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getSPDL()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getSPDL_etage()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getSPDL_Grade()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getAnomalie_transitionnelle()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getCanal_lombaire_etroit()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getLordose_Lombaire()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getIncidence_pelvienne()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getPente_sacree()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getVersion_perlvienne()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getRx_dynamique()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getRx_dynamique_qualite()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getRx_dynamique_Instabilite()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTDM()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_pincement_discal()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_pincement_discal_etage()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_pincement_discal_pourcentage()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_vide_discal()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_vide_discal_etage()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_vide_discal_Pourcentage()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_hernie_discale()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_hernie_discale_type()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_hernie_discale_etage()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_sPDL()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_sPDL_etage()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_sPDL_grade()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_instabilite()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_instabilite_etage()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_apophysaire()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_apophysaire_etage()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_anomalie_transitionnelle()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_canal_lombaire_etroit()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getIRM()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getIRM_pincementdiscal()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getIRM_pincementdiscal_etage()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getIRM_pincementdiscal_Pourcentage()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getIRM_herniediscale()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getIRM_herniediscale_etage()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getIRM_herniediscale_Type()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getIRM_hypertrophie_jaunes()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getIRM_arthrose_apophysaire()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getIRM_arthrose_apophysaire_etage()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getIRM_canal_lombaire_etroit()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getIRM_volume_disque_hernie()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getIRM_etat_disques_sous_jacent()),
//                cryptDecrypt.encryptSensitiveInformation(p1.getIRM_etat_disques_sus_jacent())
//        );
//        suivi1Post_ttt.setFichePatient(fichePatient.get());
//        if (suivi1Post_ttt != null) {
//            Consultations_ttt_Dissect suivi1Post = suivi_ttt_dissect_repository.save(suivi1Post_ttt);
//            return new ResponseEntity<Consultations_ttt_Dissect>(suivi1Post, HttpStatus.OK);
//        } else {
//            return new ResponseEntity(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//
//}
@Service
public class Suivi_ttt_Dissect_Services {

    @Autowired
    private CryptDecrypt cryptDecrypt;

    @Autowired
    private Suivi_ttt_Dissect_Repository suivi_ttt_dissect_repository;

    @Autowired
    private FichePatientRepository fichePatientRepository;

    public ResponseEntity<Consultations_ttt_Dissect> registerSuivittt_Dissect(ConsultationsDto updatedData, Long patientId) throws Exception {
//        Optional<FichePatient> fichePatientOptional = fichePatientRepository.findById(patientId);
//
//        if (!fichePatientOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        FichePatient fichePatient = fichePatientOptional.get();
        Consultations_ttt_Dissect existingSuivi = suivi_ttt_dissect_repository.findByFichePatientId(patientId);

        if (existingSuivi == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Encrypt and update fields
//        existingSuivi.setDate_de_consultation(cryptDecrypt.encryptSensitiveInformation(updatedData.getDate_de_consultation()));
//        existingSuivi.setAge(cryptDecrypt.encryptSensitiveInformation(updatedData.getAge()));
//        existingSuivi.setAddresse(cryptDecrypt.encryptSensitiveInformation(updatedData.getAddresse()));
//        existingSuivi.setTelephone(cryptDecrypt.encryptSensitiveInformation(updatedData.getTelephone()));
//        existingSuivi.setProfession(cryptDecrypt.encryptSensitiveInformation(updatedData.getProfession()));
//        existingSuivi.setStatut_social(cryptDecrypt.encryptSensitiveInformation(updatedData.getStatut_social()));
//        existingSuivi.setEntourage_actuel(cryptDecrypt.encryptSensitiveInformation(updatedData.getEntourage_actuel()));
//        existingSuivi.setAtcd(cryptDecrypt.encryptSensitiveInformation(updatedData.getAtcd()));
//        existingSuivi.setTabac(cryptDecrypt.encryptSensitiveInformation(updatedData.getTabac()));
//        existingSuivi.setEvolution(cryptDecrypt.encryptSensitiveInformation(updatedData.getEvolution()));
//        existingSuivi.setEvolution_nouvelles_symptomatologies(cryptDecrypt.encryptListeSensitiveInformation(updatedData.getEvolution_nouvelles_symptomatologies()));
//        existingSuivi.setPoids(cryptDecrypt.encryptSensitiveInformation(updatedData.getPoids()));
//        existingSuivi.setTaille(cryptDecrypt.encryptSensitiveInformation(updatedData.getTaille()));
//        existingSuivi.setBMI(cryptDecrypt.encryptSensitiveInformation(updatedData.getBMI()));
//        existingSuivi.setDeformation_rachidienne(cryptDecrypt.encryptSensitiveInformation(updatedData.getDeformation_rachidienne()));
//        existingSuivi.setDouleur_pression_lombairer_epineuses(cryptDecrypt.encryptSensitiveInformation(updatedData.getDouleur_pression_lombairer_epineuses()));
//        existingSuivi.setAmelioration_flexion_rachis(cryptDecrypt.encryptSensitiveInformation(updatedData.getAmelioration_flexion_rachis()));
//        existingSuivi.setContracture_muscles_paravertebraux(cryptDecrypt.encryptSensitiveInformation(updatedData.getContracture_muscles_paravertebraux()));
//        existingSuivi.setDMS(cryptDecrypt.encryptSensitiveInformation(updatedData.getDMS()));
//        existingSuivi.setSonnette(cryptDecrypt.encryptSensitiveInformation(updatedData.getSonnette()));
//        existingSuivi.setSonnette_Niveau(cryptDecrypt.encryptSensitiveInformation(updatedData.getSonnette_Niveau()));
//        existingSuivi.setLasegue(cryptDecrypt.encryptSensitiveInformation(updatedData.getLasegue()));
//        existingSuivi.setLasegue_controlateral(cryptDecrypt.encryptSensitiveInformation(updatedData.getLasegue_controlateral()));
//        existingSuivi.setLeri(cryptDecrypt.encryptSensitiveInformation(updatedData.getLeri()));
//        existingSuivi.setIndice_shober(cryptDecrypt.encryptSensitiveInformation(updatedData.getIndice_shober()));
//        existingSuivi.setROT_rotulien(cryptDecrypt.encryptSensitiveInformation(updatedData.getROT_rotulien()));
//        existingSuivi.setROT_achillien(cryptDecrypt.encryptSensitiveInformation(updatedData.getROT_achillien()));
//        existingSuivi.setROT_perinee(cryptDecrypt.encryptSensitiveInformation(updatedData.getROT_perinee()));
//        existingSuivi.setMarche_talons(cryptDecrypt.encryptSensitiveInformation(updatedData.getMarche_talons()));
//        existingSuivi.setMarche_pointes_pieds(cryptDecrypt.encryptSensitiveInformation(updatedData.getMarche_pointes_pieds()));
//        existingSuivi.setTesting_musculaire_L2(cryptDecrypt.encryptSensitiveInformation(updatedData.getTesting_musculaire_L2()));
//        existingSuivi.setTesting_musculaire_L3(cryptDecrypt.encryptSensitiveInformation(updatedData.getTesting_musculaire_L3()));
//        existingSuivi.setTesting_musculaire_L4(cryptDecrypt.encryptSensitiveInformation(updatedData.getTesting_musculaire_L4()));
//        existingSuivi.setTesting_musculaire_L5(cryptDecrypt.encryptSensitiveInformation(updatedData.getTesting_musculaire_L5()));
//        existingSuivi.setTesting_musculaire_S1(cryptDecrypt.encryptSensitiveInformation(updatedData.getTesting_musculaire_S1()));
//        existingSuivi.setSensibilte_L2(cryptDecrypt.encryptSensitiveInformation(updatedData.getSensibilte_L2()));
//        existingSuivi.setSensibilte_L3(cryptDecrypt.encryptSensitiveInformation(updatedData.getSensibilte_L3()));
//        existingSuivi.setSensibilte_L4(cryptDecrypt.encryptSensitiveInformation(updatedData.getSensibilte_L4()));
//        existingSuivi.setSensibilte_L5(cryptDecrypt.encryptSensitiveInformation(updatedData.getSensibilte_L5()));
//        existingSuivi.setSensibilte_S1(cryptDecrypt.encryptSensitiveInformation(updatedData.getSensibilte_S1()));
//        existingSuivi.setExamen_perinee_sensibilite(cryptDecrypt.encryptSensitiveInformation(updatedData.getExamen_perinee_sensibilite()));
//        existingSuivi.setExamen_perinee_Tonus_anal(cryptDecrypt.encryptSensitiveInformation(updatedData.getExamen_perinee_Tonus_anal()));
//        existingSuivi.setExamen_perinee_Reflexe_anal(cryptDecrypt.encryptSensitiveInformation(updatedData.getExamen_perinee_Reflexe_anal()));
//        existingSuivi.setIntensite_douleur(cryptDecrypt.encryptSensitiveInformation(updatedData.getIntensite_douleur()));
//        existingSuivi.setSoins_personnels(cryptDecrypt.encryptSensitiveInformation(updatedData.getSoins_personnels()));
//        existingSuivi.setLevee(cryptDecrypt.encryptSensitiveInformation(updatedData.getLevee()));
//        existingSuivi.setMarche(cryptDecrypt.encryptSensitiveInformation(updatedData.getMarche()));
//        existingSuivi.setAssis(cryptDecrypt.encryptSensitiveInformation(updatedData.getAssis()));
//        existingSuivi.setDebout(cryptDecrypt.encryptSensitiveInformation(updatedData.getDebout()));
//        existingSuivi.setSommeil(cryptDecrypt.encryptSensitiveInformation(updatedData.getSommeil()));
//        existingSuivi.setVie_sexuelle(cryptDecrypt.encryptSensitiveInformation(updatedData.getVie_sexuelle()));
//        existingSuivi.setVie_sociale(cryptDecrypt.encryptSensitiveInformation(updatedData.getVie_sociale()));
//        existingSuivi.setVoyage(cryptDecrypt.encryptSensitiveInformation(updatedData.getVoyage()));
//        existingSuivi.setResultat(cryptDecrypt.encryptSensitiveInformation(updatedData.getResultat()));
//        existingSuivi.setHypothese_diagnostic_HD(cryptDecrypt.encryptSensitiveInformation(updatedData.getHypothese_diagnostic_HD()));
//        existingSuivi.setHypothese_diagnostic_type(cryptDecrypt.encryptSensitiveInformation(updatedData.getHypothese_diagnostic_type()));
//        existingSuivi.setHypothese_diagnostic_Localisation(cryptDecrypt.encryptSensitiveInformation(updatedData.getHypothese_diagnostic_Localisation()));
//        existingSuivi.setTraitement_propose(cryptDecrypt.encryptSensitiveInformation(updatedData.getTraitement_propose()));
//        existingSuivi.setTraitement_propose_Nbre_infiltrations(cryptDecrypt.encryptSensitiveInformation(updatedData.getTraitement_propose_Nbre_infiltrations()));
//        existingSuivi.setTraitement_propose_Nbre_seances(cryptDecrypt.encryptSensitiveInformation(updatedData.getTraitement_propose_Nbre_seances()));
//        existingSuivi.setTraitement_propose_Type_chirurgie(cryptDecrypt.encryptSensitiveInformation(updatedData.getTraitement_propose_Type_chirurgie()));
//        existingSuivi.setTraitement_propose_Auter(cryptDecrypt.encryptSensitiveInformation(updatedData.getTraitement_propose_Auter()));
//        existingSuivi.setRx_standard(cryptDecrypt.encryptSensitiveInformation(updatedData.getRx_standard()));
//        existingSuivi.setRx_standard_qualite(cryptDecrypt.encryptSensitiveInformation(updatedData.getRx_standard_qualite()));
//        existingSuivi.setPincement_discal(cryptDecrypt.encryptSensitiveInformation(updatedData.getPincement_discal()));
//        existingSuivi.setPincement_discal_etage(cryptDecrypt.encryptSensitiveInformation(updatedData.getPincement_discal_etage()));
//        existingSuivi.setPincement_discal_Pourcentage(cryptDecrypt.encryptSensitiveInformation(updatedData.getPincement_discal_Pourcentage()));
//        existingSuivi.setVide_discal(cryptDecrypt.encryptSensitiveInformation(updatedData.getVide_discal()));
//        existingSuivi.setVide_discal_etage(cryptDecrypt.encryptSensitiveInformation(updatedData.getVide_discal_etage()));
//        existingSuivi.setSPDL(cryptDecrypt.encryptSensitiveInformation(updatedData.getSPDL()));
//        existingSuivi.setSPDL_etage(cryptDecrypt.encryptSensitiveInformation(updatedData.getSPDL_etage()));
//        existingSuivi.setSPDL_Grade(cryptDecrypt.encryptSensitiveInformation(updatedData.getSPDL_Grade()));
//        existingSuivi.setAnomalie_transitionnelle(cryptDecrypt.encryptSensitiveInformation(updatedData.getAnomalie_transitionnelle()));
//        existingSuivi.setCanal_lombaire_etroit(cryptDecrypt.encryptSensitiveInformation(updatedData.getCanal_lombaire_etroit()));
//        existingSuivi.setLordose_Lombaire(cryptDecrypt.encryptSensitiveInformation(updatedData.getLordose_Lombaire()));
//        existingSuivi.setIncidence_pelvienne(cryptDecrypt.encryptSensitiveInformation(updatedData.getIncidence_pelvienne()));
//        existingSuivi.setPente_sacree(cryptDecrypt.encryptSensitiveInformation(updatedData.getPente_sacree()));
//        existingSuivi.setVersion_perlvienne(cryptDecrypt.encryptSensitiveInformation(updatedData.getVersion_perlvienne()));
//        existingSuivi.setRx_dynamique(cryptDecrypt.encryptSensitiveInformation(updatedData.getRx_dynamique()));
//        existingSuivi.setRx_dynamique_qualite(cryptDecrypt.encryptSensitiveInformation(updatedData.getRx_dynamique_qualite()));
//        existingSuivi.setRx_dynamique_Instabilite(cryptDecrypt.encryptSensitiveInformation(updatedData.getRx_dynamique_Instabilite()));
//        existingSuivi.setTDM(cryptDecrypt.encryptSensitiveInformation(updatedData.getTDM()));
//        existingSuivi.setTDM_pincement_discal(cryptDecrypt.encryptSensitiveInformation(updatedData.getTDM_pincement_discal()));
//        existingSuivi.setTDM_pincement_discal_etage(cryptDecrypt.encryptSensitiveInformation(updatedData.getTDM_pincement_discal_etage()));
//        existingSuivi.setTDM_pincement_discal_pourcentage(cryptDecrypt.encryptSensitiveInformation(updatedData.getTDM_pincement_discal_pourcentage()));
//        existingSuivi.setTDM_vide_discal(cryptDecrypt.encryptSensitiveInformation(updatedData.getTDM_vide_discal()));
//        existingSuivi.setTDM_vide_discal_etage(cryptDecrypt.encryptSensitiveInformation(updatedData.getTDM_vide_discal_etage()));
//        existingSuivi.setTDM_vide_discal_Pourcentage(cryptDecrypt.encryptSensitiveInformation(updatedData.getTDM_vide_discal_Pourcentage()));
//        existingSuivi.setTDM_hernie_discale(cryptDecrypt.encryptSensitiveInformation(updatedData.getTDM_hernie_discale()));
//        existingSuivi.setTDM_hernie_discale_type(cryptDecrypt.encryptSensitiveInformation(updatedData.getTDM_hernie_discale_type()));
//        existingSuivi.setTDM_hernie_discale_etage(cryptDecrypt.encryptSensitiveInformation(updatedData.getTDM_hernie_discale_etage()));
//        existingSuivi.setTDM_sPDL(cryptDecrypt.encryptSensitiveInformation(updatedData.getTDM_sPDL()));
//        existingSuivi.setTDM_sPDL_etage(cryptDecrypt.encryptSensitiveInformation(updatedData.getTDM_sPDL_etage()));
//        existingSuivi.setTDM_sPDL_grade(cryptDecrypt.encryptSensitiveInformation(updatedData.getTDM_sPDL_grade()));
//        existingSuivi.setTDM_instabilite(cryptDecrypt.encryptSensitiveInformation(updatedData.getTDM_instabilite()));
//        existingSuivi.setTDM_instabilite_etage(cryptDecrypt.encryptSensitiveInformation(updatedData.getTDM_instabilite_etage()));
//        existingSuivi.setTDM_apophysaire(cryptDecrypt.encryptSensitiveInformation(updatedData.getTDM_apophysaire()));
//        existingSuivi.setTDM_apophysaire_etage(cryptDecrypt.encryptSensitiveInformation(updatedData.getTDM_apophysaire_etage()));
//        existingSuivi.setTDM_anomalie_transitionnelle(cryptDecrypt.encryptSensitiveInformation(updatedData.getTDM_anomalie_transitionnelle()));
//        existingSuivi.setTDM_canal_lombaire_etroit(cryptDecrypt.encryptSensitiveInformation(updatedData.getTDM_canal_lombaire_etroit()));
//        existingSuivi.setIRM(cryptDecrypt.encryptSensitiveInformation(updatedData.getIRM()));
//        existingSuivi.setIRM_pincementdiscal(cryptDecrypt.encryptSensitiveInformation(updatedData.getIRM_pincementdiscal()));
//        existingSuivi.setIRM_pincementdiscal_etage(cryptDecrypt.encryptSensitiveInformation(updatedData.getIRM_pincementdiscal_etage()));
//        existingSuivi.setIRM_pincementdiscal_Pourcentage(cryptDecrypt.encryptSensitiveInformation(updatedData.getIRM_pincementdiscal_Pourcentage()));
//        existingSuivi.setIRM_herniediscale(cryptDecrypt.encryptSensitiveInformation(updatedData.getIRM_herniediscale()));
//        existingSuivi.setIRM_herniediscale_etage(cryptDecrypt.encryptSensitiveInformation(updatedData.getIRM_herniediscale_etage()));
//        existingSuivi.setIRM_herniediscale_Type(cryptDecrypt.encryptSensitiveInformation(updatedData.getIRM_herniediscale_Type()));
//        existingSuivi.setIRM_hypertrophie_jaunes(cryptDecrypt.encryptSensitiveInformation(updatedData.getIRM_hypertrophie_jaunes()));
//        existingSuivi.setIRM_arthrose_apophysaire(cryptDecrypt.encryptSensitiveInformation(updatedData.getIRM_arthrose_apophysaire()));
//        existingSuivi.setIRM_arthrose_apophysaire_etage(cryptDecrypt.encryptSensitiveInformation(updatedData.getIRM_arthrose_apophysaire_etage()));
//        existingSuivi.setIRM_canal_lombaire_etroit(cryptDecrypt.encryptSensitiveInformation(updatedData.getIRM_canal_lombaire_etroit()));
//        existingSuivi.setIRM_volume_disque_hernie(cryptDecrypt.encryptSensitiveInformation(updatedData.getIRM_volume_disque_hernie()));
//        existingSuivi.setIRM_etat_disques_sous_jacent(cryptDecrypt.encryptSensitiveInformation(updatedData.getIRM_etat_disques_sous_jacent()));
//        existingSuivi.setIRM_etat_disques_sus_jacent(cryptDecrypt.encryptSensitiveInformation(updatedData.getIRM_etat_disques_sus_jacent()));
            existingSuivi.setDate_de_consultation(updatedData.getDate_de_consultation());
//        existingSuivi.setFichePatient(fichePatient);

        // Save and return response
        Consultations_ttt_Dissect savedSuivi = suivi_ttt_dissect_repository.save(existingSuivi);
        return new ResponseEntity<>(savedSuivi, HttpStatus.OK);
    }
}
