package com.test.Inoteqia.Services;

import com.test.Inoteqia.DTO.RoleName;
import com.test.Inoteqia.Entity.Medecin;
import com.test.Inoteqia.Entity.Patient;
import com.test.Inoteqia.Entity.Role;
import com.test.Inoteqia.Exception.ResourceNotFoundException;
import com.test.Inoteqia.Reposotories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${secret.key")
    private String secretKey;



    public List<Patient> getAllPatient(){
        return  patientRepository.findAll();
    }

    // Méthode pour crypter les informations sensibles de l'utilisateur
    public String encryptSensitiveInformation(String data) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    // Méthode pour décrypter les informations sensibles de l'utilisateur
    public String decryptSensitiveInformation(String encryptedData) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedData);
    }
    public ResponseEntity<Patient> registerPatient(Patient p1) throws Exception {

        Patient patient = new Patient(encryptSensitiveInformation(p1.getName()), encryptSensitiveInformation(p1.getUsername()), encryptSensitiveInformation(p1.getEmail()), passwordEncoder.encode(p1.getPassword()), false,encryptSensitiveInformation( p1.getAddress()), false);

        Patient patient1 = patientRepository.save(patient);
        return new ResponseEntity<Patient>(patient1, HttpStatus.OK);
    }

    public List<Patient> getAllPatients() throws Exception {
        List<Patient> patients = patientRepository.findAll();
        for (Patient patient : patients) {
            // Décryptez les données sensibles pour chaque patient
            patient.setName(decryptSensitiveInformation(patient.getName()));
            patient.setUsername(decryptSensitiveInformation(patient.getUsername()));
            patient.setEmail(decryptSensitiveInformation(patient.getEmail()));
            patient.setAddress(decryptSensitiveInformation(patient.getAddress()));
        }
        return patients;
    }

    // Méthode pour obtenir un patient par son ID
    public Optional<Patient> getPatientById(Long patientId) throws Exception {
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if (patientOptional.isPresent()) {
            Patient patient = patientOptional.get();
            // Décryptez les données sensibles du patient si nécessaire
            patient.setName(decryptSensitiveInformation(patient.getName()));
            patient.setUsername(decryptSensitiveInformation(patient.getUsername()));
            patient.setEmail(decryptSensitiveInformation(patient.getEmail()));
            patient.setAddress(decryptSensitiveInformation(patient.getAddress()));
            return Optional.of(patient);
        } else {
            return Optional.empty();
        }
    }

    /*
    // Update Patient
    public Patient updatePatient(Long id, Patient PatientRequest){
       Patient Patient=patientRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("id Patient " + id + " not found"));
        Patient.setEmail(patientRepository.getEmail());
        Patient.setPrenom(patientRepository.getPrenom());
        Patient.setNom(patientRepository.getNom());
        Patient.setAdresse(patientRepository.getAdresse());
        Patient.setConact(patientRepository.getConact());
        Patient.setSpecialite(patientRepository.getSpecialite());
        Patient updateMedecin=patientRepository.save(medecin);
        return updatePatient;
    }*/

    // Delete Patient
    public ResponseEntity<?> deletePatient(Long id){
        Patient patient=getPatientByIdT(id);
        patientRepository.delete(patient);
        return ResponseEntity.ok().build();
    }


    // Get  Patient By Id
    public Patient getPatientByIdT(Long idPatient){
        return patientRepository.findById(idPatient).
                orElseThrow(() -> new ResourceNotFoundException("id Patient " + idPatient + " not found"));
    }





}
