package com.test.Inoteqia.Services;

import com.test.Inoteqia.Entity.Administrateur;
import com.test.Inoteqia.Reposotories.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministrateurService {
    @Autowired
    AdministrateurRepository administrateurRepository;



    public Administrateur deleteAdministrateur(Long id){
        Optional<Administrateur> administrateur = administrateurRepository.findById(id);
        if(administrateur.isPresent()){
            return administrateur.get();
        }else
        {
            return null;
        }
    }
    public List<Administrateur> gettAllAdministrateur(){
        return  administrateurRepository.findAll();

    }
}
