package com.test.Inoteqia.Security;

import com.test.Inoteqia.JWT.JwtAuthTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.servlet.Filter;


@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
   private CorsConfigurationSource corsConfigurationSource;

    @Bean
    public JwtAuthTokenFilter authenticationJwtTokenFilter() {
        return new JwtAuthTokenFilter();
    }

    private final String[] PUBLIC_ENDPOINTS={

            "/api/auth/signup/employee",
            "/api/auth/signIn",
            "/api/patient/signup/patient/{roleName}",
            "/api/medecin/signup/medecin",
            "/api/medecin/validate-medecin/{idMedecin}",
            "/api/patient/list-patient",
            "/api/patient/register/patient/{idMedecin}",

            "/api/medecin/list-medecin",
            "/api/user/ist-userByRolesName/{RolesName}",
            "/api/user/validate-user/{idUser}",
            "/api/user/bloque-user/{idUser}",


            "/v2/api-docs",
            "/configuration/ui",
            "/-resources/**",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            "/swagger-ui/index.html",
            "/swagger-resources",
            "/configuration/security",
            "/v3/api-docs/**",
            "/swagger-ui/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().configurationSource(corsConfigurationSource).and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/refreshToken").permitAll() // Permit access to refreshToken endpoint
                .antMatchers("/**").permitAll() // Require authentication for other endpoints
                .and()
                .httpBasic();

        // Add JWT token filter before the default authentication filter
        http.addFilterBefore((Filter) authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
