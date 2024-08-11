package com.test.Inoteqia.Reposotories;

import com.test.Inoteqia.Entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StafffRepository extends JpaRepository<Staff,Long> {
   Optional<Staff> findByFichePatientId(Long id);
}
