package com.test.Inoteqia.ServiceIMP;



import com.test.Inoteqia.Entity.Utilisateur;
import com.test.Inoteqia.Entity.UserPrinciple;
import com.test.Inoteqia.Reposotories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        Utilisateur user = utilisateurRepository.findByUsername(username)
                .orElseGet(() -> utilisateurRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("Utilisateur Not Found with -> username or email : " + username)));

        return UserPrinciple.build(user);
    }






}

