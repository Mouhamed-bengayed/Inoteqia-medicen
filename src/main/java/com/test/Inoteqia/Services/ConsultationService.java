package com.test.Inoteqia.Services;

import com.test.Inoteqia.Entity.Consultations;
import com.test.Inoteqia.Reposotories.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultationService {

    @Autowired
    ConsultationRepository consultationRepository;

    public Consultations addConsultations(Consultations a1){
        Consultations savedConsultations = consultationRepository.save(a1);
        return savedConsultations;
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

}
