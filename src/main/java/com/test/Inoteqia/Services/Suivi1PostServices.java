package com.test.Inoteqia.Services;

import com.test.Inoteqia.Entity.Consultations1Post_Immediat;
import com.test.Inoteqia.Reposotories.FichePatientRepository;
import com.test.Inoteqia.Reposotories.Suivi1Post_immediatRrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Suivi1PostServices {
    @Autowired
    FichePatientRepository fichePatientRepository;
    @Autowired
    CryptDecrypt cryptDecrypt;
    @Autowired
    Suivi1Post_immediatRrepository suivi1Post_immediatRrepository;

    public ResponseEntity<Consultations1Post_Immediat> registerSuivi1Post_Immediat(Consultations1Post_Immediat p1, Long patientId) throws Exception {
        // Retrieve existing entity by patient ID or create a new instance
        Consultations1Post_Immediat suivi1Post_immediat = suivi1Post_immediatRrepository.findByFichePatientId(patientId)
                .orElse(new Consultations1Post_Immediat());

        suivi1Post_immediat.setFichePatient(fichePatientRepository.findById(patientId).get());

        // Encrypt sensitive information and set it in the entity
        suivi1Post_immediat.setDate_chirurgie(cryptDecrypt.encryptSensitiveInformation(p1.getDate_chirurgie()));
        suivi1Post_immediat.setDate_suivi(cryptDecrypt.encryptSensitiveInformation(p1.getDate_suivi()));
        suivi1Post_immediat.setDissectomie_etage(cryptDecrypt.encryptSensitiveInformation(p1.getDissectomie_etage()));
        suivi1Post_immediat.setLiberation_post_etage(cryptDecrypt.encryptSensitiveInformation(p1.getLiberation_post_etage()));
        suivi1Post_immediat.setArthrodese_etage(cryptDecrypt.encryptListeSensitiveInformation(p1.getArthrodese_etage()));
        suivi1Post_immediat.setComplications_per_operatoire(cryptDecrypt.encryptSensitiveInformation(p1.getComplications_per_operatoire()));
        suivi1Post_immediat.setComplications_per_operatoire_auter(cryptDecrypt.encryptSensitiveInformation(p1.getComplications_per_operatoire_auter()));
        suivi1Post_immediat.setLombalgie(cryptDecrypt.encryptSensitiveInformation(p1.getLombalgie()));
        suivi1Post_immediat.setSciatique(cryptDecrypt.encryptSensitiveInformation(p1.getSciatique()));
        suivi1Post_immediat.setCruralgie(cryptDecrypt.encryptSensitiveInformation(p1.getCruralgie()));
        suivi1Post_immediat.setTrouble_vesico_sphincteriens(cryptDecrypt.encryptListeSensitiveInformation(p1.getTrouble_vesico_sphincteriens()));
        suivi1Post_immediat.setTrouble_vesico_sphincteriens_Incontinence_urinaire(cryptDecrypt.encryptSensitiveInformation(p1.getTrouble_vesico_sphincteriens_Incontinence_urinaire()));
        suivi1Post_immediat.setTesting_musculaire_l2(cryptDecrypt.encryptSensitiveInformation(p1.getTesting_musculaire_l2()));
        suivi1Post_immediat.setTesting_musculaire_l3(cryptDecrypt.encryptSensitiveInformation(p1.getTesting_musculaire_l3()));
        suivi1Post_immediat.setTesting_musculaire_l4(cryptDecrypt.encryptSensitiveInformation(p1.getTesting_musculaire_l4()));
        suivi1Post_immediat.setTesting_musculaire_l5(cryptDecrypt.encryptSensitiveInformation(p1.getTesting_musculaire_l5()));
        suivi1Post_immediat.setTesting_musculaire_s1(cryptDecrypt.encryptSensitiveInformation(p1.getTesting_musculaire_s1()));
        suivi1Post_immediat.setSensibilte_musculaire_l2(cryptDecrypt.encryptSensitiveInformation(p1.getSensibilte_musculaire_l2()));
        suivi1Post_immediat.setSensibilte_musculaire_l3(cryptDecrypt.encryptSensitiveInformation(p1.getSensibilte_musculaire_l3()));
        suivi1Post_immediat.setSensibilte_musculaire_l4(cryptDecrypt.encryptSensitiveInformation(p1.getSensibilte_musculaire_l4()));
        suivi1Post_immediat.setSensibilte_musculaire_l5(cryptDecrypt.encryptSensitiveInformation(p1.getSensibilte_musculaire_l5()));
        suivi1Post_immediat.setSensibilte_musculaire_s1(cryptDecrypt.encryptSensitiveInformation(p1.getSensibilte_musculaire_s1()));
        suivi1Post_immediat.setExamen_perinee_sensibilite(cryptDecrypt.encryptSensitiveInformation(p1.getExamen_perinee_sensibilite()));
        suivi1Post_immediat.setExamen_perinee_Tonus_anal(cryptDecrypt.encryptSensitiveInformation(p1.getExamen_perinee_Tonus_anal()));
        suivi1Post_immediat.setExamen_perinee_Reflexe_anal(cryptDecrypt.encryptSensitiveInformation(p1.getExamen_perinee_Reflexe_anal()));

        // Save the updated or new entity
        Consultations1Post_Immediat savedSuivi1Post = suivi1Post_immediatRrepository.save(suivi1Post_immediat);

        // Return appropriate response
        if (savedSuivi1Post != null) {
            return new ResponseEntity<>(savedSuivi1Post, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }}
