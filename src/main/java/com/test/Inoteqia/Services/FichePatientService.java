package com.test.Inoteqia.Services;

import com.test.Inoteqia.Entity.Administrateur;
import com.test.Inoteqia.Entity.Consultations_ttt_Dissect;
import com.test.Inoteqia.Entity.FichePatient;
import com.test.Inoteqia.Entity.Medecin;
import com.test.Inoteqia.Reposotories.AdministrateurRepository;
import com.test.Inoteqia.Reposotories.FichePatientRepository;
import com.test.Inoteqia.Reposotories.MedecinRepository;
import com.test.Inoteqia.Reposotories.Suivi_ttt_Dissect_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FichePatientService {
@Autowired
private Suivi_ttt_Dissect_Repository consultations_ttt_dissectRepository;
    @Autowired
    private FichePatientRepository fichePatientRepository;
@Autowired
private MedecinRepository medecinRepository;
@Autowired
private AdministrateurRepository administrateurRepository;
    public ResponseEntity<FichePatient> registerPatient(FichePatient p1, Long id, Boolean isSpecialTreatmentSelected) {
        // Find the Medecin and Administrateur by their IDs
        Administrateur administrateur = administrateurRepository.findById(id).orElse(null);
        Medecin medecin = medecinRepository.findById(id).orElse(null);

        // Set the Medecin and Administrateur to the FichePatient
        p1.setMedecin(medecin);
        p1.setAdministrateur(administrateur);

        // Save the FichePatient instance first
        FichePatient savedPatient = fichePatientRepository.save(p1);

        // If special treatment is selected, create and save the Consultations_ttt_Dissect instance
        if (isSpecialTreatmentSelected) {
            Consultations_ttt_Dissect consultations_ttt_dissect = new Consultations_ttt_Dissect();
            consultations_ttt_dissect.setFichePatient(savedPatient);
            savedPatient.getConsultationsTttDissects().add(consultations_ttt_dissect);
            consultations_ttt_dissectRepository.save(consultations_ttt_dissect);
        }

        // Return the saved FichePatient instance
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
