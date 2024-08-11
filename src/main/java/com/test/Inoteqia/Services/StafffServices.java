package com.test.Inoteqia.Services;

import com.test.Inoteqia.Entity.Staff;
import com.test.Inoteqia.Reposotories.FichePatientRepository;
import com.test.Inoteqia.Reposotories.StafffRepository;
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
    @Autowired
    FichePatientRepository fichePatientRepository;
    public ResponseEntity<Staff> registerStaff(Staff p1, Long patientId) throws Exception {
        // Retrieve existing staff or create a new instance
        Staff savestaff = stafffRepository.findByFichePatientId(patientId).orElse(new Staff());

        // Set the patient ID or link to a patient if applicable
        savestaff.setFichePatient(fichePatientRepository.findById(patientId).get());

        // Encrypt sensitive information and set it in the staff object
        savestaff.setDate(cryptDecrypt.encryptSensitiveInformation(p1.getDate()));
        savestaff.setDiagnostic_preop(cryptDecrypt.encryptSensitiveInformation(p1.getDiagnostic_preop()));
        savestaff.setIndication_Antalgique(cryptDecrypt.encryptSensitiveInformation(p1.getIndication_Antalgique()));
        savestaff.setIndication_Infiltrations_Nbreinfiltrations(cryptDecrypt.encryptSensitiveInformation(p1.getIndication_Infiltrations_Nbreinfiltrations()));
        savestaff.setIndication_Reeducation_Nbreseances(cryptDecrypt.encryptSensitiveInformation(p1.getIndication_Reeducation_Nbreseances()));
        savestaff.setIndication_Dissectomie_etage(cryptDecrypt.encryptSensitiveInformation(p1.getIndication_Dissectomie_etage()));
        savestaff.setIndication_Liberation_etage(cryptDecrypt.encryptSensitiveInformation(p1.getIndication_Liberation_etage()));
        savestaff.setIndication_Arthrodese(cryptDecrypt.encryptListeSensitiveInformation(p1.getIndication_Arthrodese()));
        savestaff.setAutreindication_Arthrodese(cryptDecrypt.encryptSensitiveInformation(p1.getAutreindication_Arthrodese()));
        savestaff.setConclusion(cryptDecrypt.encryptSensitiveInformation(p1.getConclusion()));

        // Save the staff entity
        Staff savedStaff = stafffRepository.save(savestaff);

        // Return appropriate response
        if (savedStaff != null) {
            return new ResponseEntity<>(savedStaff, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
