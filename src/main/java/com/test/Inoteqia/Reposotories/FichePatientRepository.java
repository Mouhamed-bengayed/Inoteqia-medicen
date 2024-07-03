package com.test.Inoteqia.Reposotories;

import com.test.Inoteqia.Entity.FichePatient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FichePatientRepository extends JpaRepository<FichePatient, Long> {
    List <FichePatient> findAllByAdministrateurId(Long id);
    List <FichePatient> findAllByMedecinId(Long id);
}
