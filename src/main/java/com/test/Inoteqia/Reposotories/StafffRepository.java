package com.test.Inoteqia.Reposotories;

import com.test.Inoteqia.Entity.Staff;
import com.test.Inoteqia.Entity.Suivi1Post_Immediat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StafffRepository extends JpaRepository<Staff,Long> {

}
