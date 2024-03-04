package com.test.Inoteqia.Services;


import com.test.Inoteqia.Entity.SuperAdministrateur;
import com.test.Inoteqia.Reposotories.SuperAdministateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SuperAdminService {

    @Autowired
    SuperAdministateurRepository superAdministateurRepository;

    public SuperAdministrateur addSuperAdministrateur(SuperAdministrateur a1){
        SuperAdministrateur addSuperAdministrateur = superAdministateurRepository.save(a1);
        return addSuperAdministrateur;
    }

    public SuperAdministrateur deleteSuperAdministrateur(Long id){
        Optional<SuperAdministrateur> superAdministrateur = superAdministateurRepository.findById(id);
        if(superAdministrateur.isPresent()){
            return superAdministrateur.get();
        }else
        {
            return null;
        }
    }
    public List<SuperAdministrateur> gettAllSuperAdministrateur(){
        return   superAdministateurRepository.findAll();
    }
}
