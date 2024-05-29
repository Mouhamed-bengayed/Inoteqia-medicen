package com.test.Inoteqia.Reposotories;

import com.test.Inoteqia.Entity.Suivi1Post_Immediat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Suivi1Post_immediatRrepository extends JpaRepository<Suivi1Post_Immediat,Long> {

}
