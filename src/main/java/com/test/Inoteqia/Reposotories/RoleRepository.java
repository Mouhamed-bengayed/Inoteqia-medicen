package com.test.Inoteqia.Reposotories;
import com.test.Inoteqia.DTO.RoleName;
import com.test.Inoteqia.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(RoleName roleName );

}
