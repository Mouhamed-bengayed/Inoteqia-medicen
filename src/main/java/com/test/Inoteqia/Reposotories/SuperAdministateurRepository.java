package com.test.Inoteqia.Reposotories;

import com.test.Inoteqia.Entity.SuperAdministrateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperAdministateurRepository extends JpaRepository<SuperAdministrateur,Long> {

}
