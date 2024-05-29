package com.test.Inoteqia.Services;

import com.test.Inoteqia.Entity.Staff;
import com.test.Inoteqia.Entity.Suivi1Post_Immediat;
import com.test.Inoteqia.Reposotories.StafffRepository;
import com.test.Inoteqia.Reposotories.Suivi1Post_immediatRrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StafffServices {


    @Autowired
    CryptDecrypt cryptDecrypt;
    @Autowired
    StafffRepository stafffRepository;

    public ResponseEntity<Staff> registerStaff(Staff p1) throws Exception {
        Staff savestaff = new Staff(
                cryptDecrypt.encryptSensitiveInformation(p1.getDate()),
                cryptDecrypt.encryptSensitiveInformation(p1.getDiagnostic_preop()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIndication_Antalgique()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIndication_Infiltrations_Nbreinfiltrations()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIndication_Reeducation_Nbreseances()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIndication_Dissectomie_etage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIndication_Liberation_etage()),
                cryptDecrypt.encryptSensitiveInformation(p1.getIndication_Arthrodese()),
                cryptDecrypt.encryptSensitiveInformation(p1.getConclusion())
        );


        if(savestaff!=null){
            Staff savestafft = stafffRepository.save(savestaff);
            return new ResponseEntity<Staff>(savestafft, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
