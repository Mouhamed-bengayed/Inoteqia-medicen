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
        ConsultationsArthrodese suiviArthrodese= new ConsultationsArthrodese(
                cryptDecrypt.encryptSensitiveInformation(p1.getDate_de_consultation()),
                cryptDecrypt.encryptSensitiveInformation(p1.getAge()),
                cryptDecrypt.encryptSensitiveInformation(p1.getAddresse()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTelephone()),
                cryptDecrypt.encryptSensitiveInformation(p1.getProfession()),
                cryptDecrypt.encryptSensitiveInformation(p1.getStatut_social()),
                cryptDecrypt.encryptSensitiveInformation(p1.getEntourage_actuel()),
                cryptDecrypt.encryptSensitiveInformation(p1.getAtcd()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTabac()),
                cryptDecrypt.encryptSensitiveInformation(p1.getEvolution()),
                cryptDecrypt.encryptSensitiveInformation(p1.getEvolution_nouvelles_symptomatologies()),
                cryptDecrypt.encryptSensitiveInformation(p1.getPoids()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTaille()),
                cryptDecrypt.encryptSensitiveInformation(p1.getBMI()),
                cryptDecrypt.encryptSensitiveInformation(p1.getDeformation_rachidienne()),
                cryptDecrypt.encryptSensitiveInformation(p1.getDouleur_pression_lombairer_epineuses()),
                cryptDecrypt.encryptSensitiveInformation(p1.getAmelioration_flexion_rachis()),
                cryptDecrypt.encryptSensitiveInformation(p1.getContracture_muscles_paravertebraux()),
                cryptDecrypt.encryptSensitiveInformation(p1.getDMS()),
                cryptDecrypt.encryptSensitiveInformation(p1.getSonnette()),
                cryptDecrypt.encryptSensitiveInformation(p1.getSonnette_Niveau()),
                cryptDecrypt.encryptSensitiveInformation(p1.getLasegue()),
                cryptDecrypt.encryptSensitiveInformation(p1.getLasegue_controlateral()),
                cryptDecrypt.encryptSensitiveInformation(p1.getLeri()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIndice_shober()),
                cryptDecrypt.encryptSensitiveInformation(p1.getROT_rotulien()),
                cryptDecrypt.encryptSensitiveInformation(p1.getROT_achillien()),
                cryptDecrypt.encryptSensitiveInformation(p1.getROT_perinee()),
                cryptDecrypt.encryptSensitiveInformation(p1.getMarche_talons()),
                cryptDecrypt.encryptSensitiveInformation(p1.getMarche_pointes_pieds()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTesting_musculaire_L2()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTesting_musculaire_L3()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTesting_musculaire_L4()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTesting_musculaire_L5()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTesting_musculaire_S1()),
                cryptDecrypt.encryptSensitiveInformation(p1.getSensibilte_L2()),
                cryptDecrypt.encryptSensitiveInformation(p1.getSensibilte_L3()),
                cryptDecrypt.encryptSensitiveInformation(p1.getSensibilte_L4()),
                cryptDecrypt.encryptSensitiveInformation(p1.getSensibilte_L5()),
                cryptDecrypt.encryptSensitiveInformation(p1.getSensibilte_S1()),
                cryptDecrypt.encryptSensitiveInformation(p1.getExamen_perinee_sensibilite()),
                cryptDecrypt.encryptSensitiveInformation(p1.getExamen_perinee_Tonus_anal()),
                cryptDecrypt.encryptSensitiveInformation(p1.getExamen_perinee_Reflexe_anal()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIntensite_douleur()),
                cryptDecrypt.encryptSensitiveInformation(p1.getSoins_personnels()),
                cryptDecrypt.encryptSensitiveInformation(p1.getLevee()),
                cryptDecrypt.encryptSensitiveInformation(p1.getMarche()),
                cryptDecrypt.encryptSensitiveInformation(p1.getAssis()),
                cryptDecrypt.encryptSensitiveInformation(p1.getDebout()),
                cryptDecrypt.encryptSensitiveInformation(p1.getSommeil()),
                cryptDecrypt.encryptSensitiveInformation(p1.getVie_sexuelle()),
                cryptDecrypt.encryptSensitiveInformation(p1.getVie_sociale()),
                cryptDecrypt.encryptSensitiveInformation(p1.getVoyage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getResultat()),
                cryptDecrypt.encryptSensitiveInformation(p1.getHypothese_diagnostic_HD()),
                cryptDecrypt.encryptSensitiveInformation(p1.getHypothese_diagnostic_type()),
                cryptDecrypt.encryptSensitiveInformation(p1.getHypothese_diagnostic_Localisation()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTraitement_propose()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTraitement_propose_Nbre_infiltrations()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTraitement_propose_Nbre_seances()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTraitement_propose_Type_chirurgie()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTraitement_propose_Auter()),
                cryptDecrypt.encryptSensitiveInformation(p1.getRx_Standard()),
                cryptDecrypt.encryptSensitiveInformation(p1.getRx_Standard_qualite()),
                cryptDecrypt.encryptSensitiveInformation(p1.getPincement_discal()),
                cryptDecrypt.encryptSensitiveInformation(p1.getPincement_discal_etage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getPincement_discal_Pourcentage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getVide_discal()),
                cryptDecrypt.encryptSensitiveInformation(p1.getVide_discal_etage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getSPDL()),
                cryptDecrypt.encryptSensitiveInformation(p1.getSPDL_etage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getSPDL_Grade()),
                cryptDecrypt.encryptSensitiveInformation(p1.getAnomalie_transitionnelle()),
                cryptDecrypt.encryptSensitiveInformation(p1.getCanal_lombaire_etroit()),
                cryptDecrypt.encryptSensitiveInformation(p1.getLordose_Lombaire()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIncidence_pelvienne()),
                cryptDecrypt.encryptSensitiveInformation(p1.getPente_sacree()),
                cryptDecrypt.encryptSensitiveInformation(p1.getVersion_perlvienne()),
                cryptDecrypt.encryptSensitiveInformation(p1.getRx_dynamique()),
                cryptDecrypt.encryptSensitiveInformation(p1.getRx_dynamique_qualite()),
                cryptDecrypt.encryptSensitiveInformation(p1.getRx_dynamique_Instabilite()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTDM()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_pincement_discal()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_pincement_discal_etage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_pincement_discal_pourcentage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_vide_discal()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_vide_discal_etage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_vide_discal_Pourcentage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_hernie_discale()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_hernie_discale_type()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_hernie_discale_etage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_sPDL()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_sPDL_etage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_sPDL_grade()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_instabilite()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_instabilite_etage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_apophysaire()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_apophysaire_etage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_anomalie_transitionnelle()),
                cryptDecrypt.encryptSensitiveInformation(p1.getTDM_canal_lombaire_etroit()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIRM()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIRM_pincementdiscal()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIRM_pincementdiscal_etage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIRM_pincementdiscal_Pourcentage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIRM_herniediscale()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIRM_herniediscale_etage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIRM_herniediscale_Type()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIRM_hypertrophie_jaunes()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIRM_arthrose_apophysaire()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIRM_arthrose_apophysaire_etage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIRM_canal_lombaire_etroit()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIRM_volume_disque_hernie()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIRM_etat_disques_sous_jacent()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIRM_etat_disques_sus_jacent())
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
