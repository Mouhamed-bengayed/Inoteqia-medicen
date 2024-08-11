package com.test.Inoteqia.Reposotories;

import com.test.Inoteqia.Entity.Consultations1Post_Immediat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Suivi1Post_immediatRrepository extends JpaRepository<Consultations1Post_Immediat,Long> {
    Optional<Consultations1Post_Immediat> findByFichePatientId(Long id);
}
