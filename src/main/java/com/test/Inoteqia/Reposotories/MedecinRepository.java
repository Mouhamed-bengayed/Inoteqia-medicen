package com.test.Inoteqia.Reposotories;

import com.test.Inoteqia.Entity.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {


    /*  Medecin findByUtilisateur(Utilisateur utilisateur);*/
}
