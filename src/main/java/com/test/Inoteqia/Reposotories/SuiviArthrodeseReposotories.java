package com.test.Inoteqia.Reposotories;


import com.test.Inoteqia.Entity.ConsultationsArthrodese;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SuiviArthrodeseReposotories extends JpaRepository<ConsultationsArthrodese,Long> {
    Optional<ConsultationsArthrodese> findByFichePatientId(Long id);
}
