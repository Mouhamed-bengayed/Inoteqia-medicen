package com.test.Inoteqia.Reposotories;

import com.test.Inoteqia.Entity.Consultations_ttt_Dissect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Suivi_ttt_Dissect_Repository extends JpaRepository<Consultations_ttt_Dissect,Long> {
    Optional <Consultations_ttt_Dissect> findByFichePatientId(Long id);
}
