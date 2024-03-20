package com.test.Inoteqia.Reposotories;
import com.test.Inoteqia.Entity.Role;
import com.test.Inoteqia.Entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    Optional<Utilisateur> findByEmail(String username);
    //Utilisateur findByUsername(String username);
    Optional<Utilisateur> findByUsername(String username);
    boolean existsByUsername(String username);

    static boolean existsByEmail(String email) {
        return false;
    }


    List<Utilisateur> findByRolesContains(Role role);



}
