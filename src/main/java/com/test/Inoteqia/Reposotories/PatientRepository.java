package com.test.Inoteqia.Reposotories;

import com.test.Inoteqia.Entity.Consultations;
import com.test.Inoteqia.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    boolean existsByEmail(String email);
}
