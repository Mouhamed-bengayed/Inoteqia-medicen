package com.test.Inoteqia.Reposotories;

import com.test.Inoteqia.Entity.Consultations_ttt_Dissect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Suivi_ttt_Dissect_Repository extends JpaRepository<Consultations_ttt_Dissect,Long> {
}
