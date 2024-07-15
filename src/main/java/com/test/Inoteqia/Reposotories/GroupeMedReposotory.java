package com.test.Inoteqia.Reposotories;

import com.test.Inoteqia.Entity.GroupeMed;
import com.test.Inoteqia.Entity.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupeMedReposotory extends JpaRepository<GroupeMed, Long> {
}
