package com.test.Inoteqia.Security;

import com.test.Inoteqia.JWT.JwtAuthEntryPoint;
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
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.servlet.Filter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public JwtAuthTokenFilter authenticationJwtTokenFilter() {
        return new JwtAuthTokenFilter();
    }
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return jwtAuthEntryPoint;


    }
    @Autowired
    private JwtAuthEntryPoint jwtAuthEntryPoint;
    @Autowired
    private CorsConfigurationSource corsConfigurationSource;




    @Override

    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().configurationSource(corsConfigurationSource).and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/api/auth/refreshToken").permitAll() // Permit access to refreshToken endpoint
                .antMatchers("/**").permitAll()
                // .anyRequest().authenticated() // Require authentication for any other endpoint

                .and()
                .httpBasic();

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint());
    }

  /* @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

*/

   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
   http
           .cors().configurationSource(corsConfigurationSource).and()
           .csrf().disable()
           .sessionManagement()
           .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
           .and()
           .authorizeRequests()
           .antMatchers("/**").permitAll()
           .anyRequest().authenticated()
           .and()
           .httpBasic();

    }*/
    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors().and()
            .csrf().disable()
            .authorizeRequests()
                // Public endpoints accessible by anyone
                .antMatchers(HttpMethod.POST, "/api/auth/signup/employee").permitAll()
                .antMatchers(HttpMethod.POST, "/api/auth/signIn").permitAll()
                .antMatchers(HttpMethod.GET, "/api/works/sum_carbo_works").permitAll()
                // Endpoints accessible only to specific roles
                .antMatchers("/api/Bilan/**").hasAnyAuthority("ROLE_USER", "ADMIN", "Entreprise", "Employee", "Manager", "HR", "CRM", "Consult", "PM")
                .antMatchers("/api/message/**").hasAnyAuthority("ROLE_USER", "ADMIN", "Entreprise", "Employee", "Manager", "HR", "CRM", "Consult", "PM")
                .antMatchers("/api/Solution/**").hasAnyAuthority("ROLE_USER", "ADMIN", "Entreprise", "Employee", "Manager", "HR", "CRM", "Consult", "PM")
                .antMatchers("/api/user/**").hasAnyAuthority("ADMIN", "Entreprise", "Manager", "HR", "CRM", "Consult", "PM")
                // Add more endpoints and roles as needed
                .anyRequest().authenticated()
            .and()
            .httpBasic();
    }*/

    /*
    @Bean
    public HttpFirewall httpFirewall() {
        DefaultHttpFirewall firewall = new DefaultHttpFirewall();
        // Allowing double slashes in URLs
        firewall.setAllowUrlEncodedSlash(true);
        return firewall;
    }*/

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