package com.test.Inoteqia.Services;
import com.test.Inoteqia.Entity.*;
import com.test.Inoteqia.Reposotories.*;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class PatientService {

    @Autowired
    UtilisateurRepository utilisateurRepository;
//    @Autowired
//    PatientRepository patientRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    CryptDecrypt cryptDecrypt;
    @Autowired
    MedecinRepository medecinRepository;
   ;


//    public Patient deletePatient(Long id){
//        Optional<Patient> patient = patientRepository.findById(id);
//        if (patient.isPresent()) {
//            patientRepository.deleteById(id);
//            return patient.get();
//        } else {
//            return null;
//        }
//    }



   /* public ResponseEntity<Patient> registerPatient(Patient p1) throws Exception {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        cryptDecrypt.encryptSensitiveInformation(p1.getusername;
        if (principal instanceof UserPrinciple) {
             username = ((UserPrinciple)principal).getUsername();
        } else {
             username = principal.toString();
        }
        Utilisateur utilisateur = utilisateurRepository.findUtilisateurByUsername(username);
        if (utilisateur!=null) {
            Medecin medecin=medecinRepository.findByUtilisateur(utilisateur);
        Patient patient1 = new Patient(cryptDecrypt.encryptSensitiveInformation(p1.getDate_de_consultation()), cryptDecrypt.encryptSensitiveInformation(p1.getDossierMedical()), cryptDecrypt.encryptSensitiveInformation(p1.getN_Dossier_medical()), cryptDecrypt.encryptSensitiveInformation(p1.getDossier_medical_num()), cryptDecrypt.encryptSensitiveInformation(p1.getName()), cryptDecrypt.encryptSensitiveInformation(p1.getUsername()), cryptDecrypt.encryptSensitiveInformation(p1.getSexe()), cryptDecrypt.encryptSensitiveInformation(p1.getAnnee_de_naissance()), cryptDecrypt.encryptSensitiveInformation(p1.getOrigine()), cryptDecrypt.encryptSensitiveInformation(p1.getIdPatient()), cryptDecrypt.encryptSensitiveInformation(p1.getAddresse()), cryptDecrypt.encryptSensitiveInformation(p1.getTelephone()), cryptDecrypt.encryptSensitiveInformation(p1.getProfession()), cryptDecrypt.encryptSensitiveInformation(p1.getAdresse_par()), cryptDecrypt.encryptSensitiveInformation(p1.getStatut_social()), cryptDecrypt.encryptSensitiveInformation(p1.getEntourage_actuel()), cryptDecrypt.encryptSensitiveInformation(p1.getAtcd()), cryptDecrypt.encryptSensitiveInformation(p1.getTabac()), cryptDecrypt.encryptSensitiveInformation(p1.getMotif_de_consultation()), cryptDecrypt.encryptSensitiveInformation(p1.getMotif_de_consultation_l())) ;
            patient1.setMedecin(medecin);
            Patient pat1 = patientRepository.save(patient1);
            return new ResponseEntity<Patient>(pat1,HttpStatus.OK);
             }
            else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }*/
   public Optional<Utilisateur> getCurrentUser() {
       Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       String username;
       if (principal instanceof UserDetails) {
           username = ((UserDetails) principal).getUsername();
       } else {
           username = principal.toString();
       }
       return utilisateurRepository.findByUsername(username);
   }
//    public ResponseEntity<Patient> registerPatient(Patient p1) throws Exception {
//        Patient patient1 = new Patient(cryptDecrypt.encryptSensitiveInformation(p1.getDate_de_consultation()), cryptDecrypt.encryptSensitiveInformation(p1.getDossierMedical()), cryptDecrypt.encryptSensitiveInformation(p1.getN_Dossier_medical()), cryptDecrypt.encryptSensitiveInformation(p1.getDossier_medical_num()), cryptDecrypt.encryptSensitiveInformation(p1.getName()), cryptDecrypt.encryptSensitiveInformation(p1.getUsername()), cryptDecrypt.encryptSensitiveInformation(p1.getSexe()), cryptDecrypt.encryptSensitiveInformation(p1.getAnnee_de_naissance()), cryptDecrypt.encryptSensitiveInformation(p1.getOrigine()), cryptDecrypt.encryptSensitiveInformation(p1.getIdPatient()), cryptDecrypt.encryptSensitiveInformation(p1.getAddresse()), cryptDecrypt.encryptSensitiveInformation(p1.getTelephone()), cryptDecrypt.encryptSensitiveInformation(p1.getProfession()), cryptDecrypt.encryptSensitiveInformation(p1.getAdresse_par()), cryptDecrypt.encryptSensitiveInformation(p1.getStatut_social()), cryptDecrypt.encryptSensitiveInformation(p1.getEntourage_actuel()), cryptDecrypt.encryptSensitiveInformation(p1.getAtcd()), cryptDecrypt.encryptSensitiveInformation(p1.getTabac()), cryptDecrypt.encryptSensitiveInformation(p1.getMotif_de_consultation()), cryptDecrypt.encryptSensitiveInformation(p1.getMotif_de_consultation_l())) ;
//       patientRepository.save(patient1);
//        return new ResponseEntity<Patient>(patient1, HttpStatus.OK);
//
//        }
        /*
    public ResponseEntity<Patient> updatePatient(Long id, Patient updatedPatient) throws Exception {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserPrinciple) {
            username = ((UserPrinciple) principal).getUsername();
        } else {
            username = principal.toString();
        }
        Utilisateur utilisateur = utilisateurRepository.findUtilisateurByUsername(username);
        if (utilisateur != null) {
            Medecin medecin = medecinRepository.findByUtilisateur(utilisateur);
            Optional<Patient> patientOptional = patientRepository.findById(id);
            if (patientOptional.isPresent()) {
                Patient patientToUpdate = patientOptional.get();
                patientToUpdate.setDate_de_consultation(cryptDecrypt.encryptSensitiveInformation(updatedPatient.getDate_de_consultation()));
                patientToUpdate.setDossierMedical(cryptDecrypt.encryptSensitiveInformation(updatedPatient.getDossierMedical()));
                patientToUpdate.setN_Dossier_medical(cryptDecrypt.encryptSensitiveInformation(updatedPatient.getN_Dossier_medical()));
                patientToUpdate.setDossier_medical_num(cryptDecrypt.encryptSensitiveInformation(updatedPatient.getDossier_medical_num()));
                patientToUpdate.setName(cryptDecrypt.encryptSensitiveInformation(updatedPatient.getName()));
                patientToUpdate.setUsername(cryptDecrypt.encryptSensitiveInformation(updatedPatient.getUsername()));
                patientToUpdate.setSexe(cryptDecrypt.encryptSensitiveInformation(updatedPatient.getSexe()));
                patientToUpdate.setAnnee_de_naissance(cryptDecrypt.encryptSensitiveInformation(updatedPatient.getAnnee_de_naissance()));
                patientToUpdate.setOrigine(cryptDecrypt.encryptSensitiveInformation(updatedPatient.getOrigine()));
                patientToUpdate.setIdPatient(cryptDecrypt.encryptSensitiveInformation(updatedPatient.getIdPatient()));
                patientToUpdate.setAddresse(cryptDecrypt.encryptSensitiveInformation(updatedPatient.getAddresse()));
                patientToUpdate.setTelephone(cryptDecrypt.encryptSensitiveInformation(updatedPatient.getTelephone()));
                patientToUpdate.setProfession(cryptDecrypt.encryptSensitiveInformation(updatedPatient.getProfession()));
                patientToUpdate.setAdresse_par(cryptDecrypt.encryptSensitiveInformation(updatedPatient.getAdresse_par()));
                patientToUpdate.setStatut_social(cryptDecrypt.encryptSensitiveInformation(updatedPatient.getStatut_social()));
                patientToUpdate.setEntourage_actuel(cryptDecrypt.encryptSensitiveInformation(updatedPatient.getEntourage_actuel()));
                patientToUpdate.setAtcd(cryptDecrypt.encryptSensitiveInformation(updatedPatient.getAtcd()));
                patientToUpdate.setTabac(cryptDecrypt.encryptSensitiveInformation(updatedPatient.getTabac()));
                patientToUpdate.setMotif_de_consultation(cryptDecrypt.encryptSensitiveInformation(updatedPatient.getMotif_de_consultation()));
                patientToUpdate.setMotif_de_consultation_l(cryptDecrypt.encryptSensitiveInformation(updatedPatient.getMotif_de_consultation_l()));
                patientToUpdate.setMedecin(medecin);
                Patient updatedPatientEntity = patientRepository.save(patientToUpdate);
                return new ResponseEntity<>(updatedPatientEntity, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
*/


//    public List<Patient> getAllPatient() throws Exception {
//        List<Patient> patients = patientRepository.findAll();
//        List<Patient> decryptedPatient = new ArrayList<>();
//        for (Patient patient : patients) {
//            // Décryptez les données sensibles pour chaque medecin
//            patient.setName(cryptDecrypt.decryptSensitiveInformation(patient.getName()));
//            patient.setUsername(cryptDecrypt.decryptSensitiveInformation(patient.getUsername()));
//            patient.setAddresse(cryptDecrypt.decryptSensitiveInformation(patient.getAddresse()));
//            decryptedPatient.add(patient);
//        }
//        return decryptedPatient;
//    }
}




















