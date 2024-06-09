package com.test.Inoteqia.Services;

import com.test.Inoteqia.Entity.Consultations1Post_Immediat;
import com.test.Inoteqia.Reposotories.Suivi1Post_immediatRrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Suivi1PostServices {

    @Autowired
    CryptDecrypt cryptDecrypt;
    @Autowired
    Suivi1Post_immediatRrepository suivi1Post_immediatRrepository;

    public ResponseEntity<Consultations1Post_Immediat> registerSuivi1Post_Immediat(Consultations1Post_Immediat p1) throws Exception {
        Consultations1Post_Immediat suivi1Post_immediat = new Consultations1Post_Immediat(
                cryptDecrypt.encryptSensitiveInformation(p1.getDate_chirurgie()),
                cryptDecrypt.encryptSensitiveInformation(p1.getDate_suiui()),
                cryptDecrypt.encryptSensitiveInformation(p1.getDissectomie_etage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getLiberation_post_etage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getArthrodese_etage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getComplications_per_operatoire()),
                cryptDecrypt.encryptSensitiveInformation(p1.getComplications_per_operatoire_auter()),
                cryptDecrypt.encryptSensitiveInformation(p1.getSymptomatologie_Lombalgie()),
                cryptDecrypt.encryptSensitiveInformation(p1.getSymptomatologie_Sciatique()),
                cryptDecrypt.encryptSensitiveInformation(p1.getSymptomatologie_Cruralgie()),
                cryptDecrypt.encryptSensitiveInformation(p1.getSymptomatologie_sphinctériens()),
                cryptDecrypt.encryptSensitiveInformation(p1.getExamen_Post_Testing_musculaire_l2()),
                cryptDecrypt.encryptSensitiveInformation(p1.getExamen_Post_Testing_musculaire_l3()),
                cryptDecrypt.encryptSensitiveInformation(p1.getExamen_Post_Testing_musculaire_l4()),
                cryptDecrypt.encryptSensitiveInformation(p1.getExamen_Post_Testing_musculaire_l5()),
                cryptDecrypt.encryptSensitiveInformation(p1.getExamen_Post_Testing_musculaire_s1()),
                cryptDecrypt.encryptSensitiveInformation(p1.getExamen_Post_Sensibilte_musculaire_l2()),
                cryptDecrypt.encryptSensitiveInformation(p1.getExamen_Post_Sensibilte_musculaire_l3()),
                cryptDecrypt.encryptSensitiveInformation(p1.getExamen_Post_Sensibilte_musculaire_l4()),
                cryptDecrypt.encryptSensitiveInformation(p1.getExamen_Post_Sensibilte_musculaire_l5()),
                cryptDecrypt.encryptSensitiveInformation(p1.getExamen_Post_Sensibilte_musculaire_s1()),
                cryptDecrypt.encryptSensitiveInformation(p1.getExamen_Post_Examen_perinee_sensibilite()),
                cryptDecrypt.encryptSensitiveInformation(p1.getExamen_Post_Examen_perinee_Tonus_anal()),
                cryptDecrypt.encryptSensitiveInformation(p1.getExamen_Post_Examen_perinee_Reflexe_anal())) ;

        if(suivi1Post_immediat!=null){
            Consultations1Post_Immediat suivi1Post = suivi1Post_immediatRrepository.save(suivi1Post_immediat);
            return new ResponseEntity<Consultations1Post_Immediat>(suivi1Post, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
