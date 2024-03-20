package com.test.Inoteqia.Services;

import com.test.Inoteqia.Entity.Consultations;
import com.test.Inoteqia.Entity.Patient;
import com.test.Inoteqia.Entity.Utilisateur;
import com.test.Inoteqia.Exception.ResourceNotFoundException;
import com.test.Inoteqia.Reposotories.ConsultationRepository;
import com.test.Inoteqia.Reposotories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultationService {

    @Autowired
    ConsultationRepository consultationRepository;
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    CryptDecrypt cryptDecrypt;

    public Consultations addConsultations(Consultations a1 ,Long Idmedecin, Long Idpatient) throws Exception {
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(Idmedecin);
        if (utilisateurOptional.isPresent()) {
            a1.getMedecin().setId(Idmedecin);
            a1.setId(Idpatient);
            Consultations c1 = new Consultations(cryptDecrypt.encryptSensitiveInformation(a1.getNom()), cryptDecrypt.encryptSensitiveInformation(a1.getPrenom()),  cryptDecrypt.encryptSensitiveInformation(a1.getAddress()));

            Consultations savedConsultations = consultationRepository.save(a1);
            return savedConsultations;
        }else
        {
            return null;
        }

    }

    public Consultations deleteConsultations(Long id){
        Optional<Consultations> consultations = consultationRepository.findById(id);
        if(consultations.isPresent()){
            return consultations.get();
        }else
        {
            return null;
        }
    }
    public List<Consultations> gettAllConsultations(){
        return  consultationRepository.findAll();
    }

    public Consultations updateConsultation(Long id, Consultations consultationsrequ){
        Consultations consultations=consultationRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("id Consultations " + id + " not found"));
        consultations.setNom(consultationsrequ.getNom());
        consultations.setPrenom(consultationsrequ.getPrenom());
        consultations.setAddress(consultationsrequ.getAddress());
        Consultations updateConsultation=consultationRepository.save(consultations);
        return updateConsultation;
    }

}
