package com.test.Inoteqia.Services;

import com.test.Inoteqia.Entity.Administrateur;
import com.test.Inoteqia.Entity.FichePatient;
import com.test.Inoteqia.Entity.Medecin;
import com.test.Inoteqia.Reposotories.AdministrateurRepository;
import com.test.Inoteqia.Reposotories.FichePatientRepository;
import com.test.Inoteqia.Reposotories.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FichePatientService {

    @Autowired
    private FichePatientRepository fichePatientRepository;
@Autowired
private MedecinRepository medexinRepository;
@Autowired
private AdministrateurRepository administrateurRepository;
    public ResponseEntity<FichePatient> registerPatient(FichePatient p1,Long id) {
        Administrateur administrateur= administrateurRepository.findById(id).orElse(null);
        Medecin medecin=medexinRepository.findById(id).orElse(null);
        p1.setMedecin(medecin);
        p1.setAdministrateur(administrateur);

        FichePatient savedPatient = fichePatientRepository.save(p1);
        return ResponseEntity.ok(savedPatient);
    }

    public ResponseEntity<FichePatient> updatePatient(FichePatient p1) {
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
}
