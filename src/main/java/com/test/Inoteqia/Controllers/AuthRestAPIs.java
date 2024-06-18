package com.test.Inoteqia.Controllers;


import com.test.Inoteqia.DTO.SignIn;
import com.test.Inoteqia.Entity.Utilisateur;
import com.test.Inoteqia.JWT.JwtAuthTokenFilter;
import com.test.Inoteqia.JWT.JwtProvider;
import com.test.Inoteqia.JWT.JwtResponse;
import com.test.Inoteqia.Reposotories.RoleRepository;
import com.test.Inoteqia.Reposotories.UtilisateurRepository;
import com.test.Inoteqia.ServiceIMP.UserServiceIMP;
import com.test.Inoteqia.Services.MailSenderService;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UtilisateurRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserServiceIMP userServiceIMP;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    MailSenderService mailSending;
    @Autowired
    JwtAuthTokenFilter jwtAuthTokenFilter;

    @PostMapping("/signIn")
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody SignIn login) {
        Optional<Utilisateur> userByEmail = userRepository.findByEmail(login.getEmail());
        Optional<Utilisateur> userByUsername = userRepository.findByUsername(login.getEmail());
        Optional<Utilisateur> user = userByEmail.isPresent() ? userByEmail : userByUsername;

        if(user.get().isBlocked()&& user.get().isValid()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);


        List<String> jwt = jwtProvider.generateJwtTokens(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(jwt.get(0),jwt.get(1), userDetails.getUsername(),user.get().getId(), userDetails.getAuthorities()));
    }



    /* @PostMapping("/signIn")
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody SignIn login) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateJwtToken(authentication)
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
    }*/
    // Create a new controller method for token refresh

    @PostMapping("/refreshToken")
    public ResponseEntity<?> refreshToken( HttpServletRequest request) {
        String refreshToken = extractRefreshToken(request);
        if (refreshToken != null && jwtAuthTokenFilter.isValidRefreshToken(refreshToken)) {
            String newAccessToken = jwtAuthTokenFilter.issueNewAccessToken(refreshToken);
            return ResponseEntity.ok(new JwtResponse(newAccessToken, refreshToken));
        } else {
            return ResponseEntity.badRequest().body("Invalid or expired refresh token");
        }
    }
    private String extractRefreshToken(HttpServletRequest request) {
        // Retrieve the refresh token from the request attributes or parameters
        String refreshToken = request.getParameter("refreshToken");
        if (refreshToken != null && !refreshToken.isEmpty()) {
            return refreshToken;
        } else {
            // If the refresh token is not found in parameters, try retrieving it from headers
            refreshToken = request.getHeader("Authorization");
            if (refreshToken != null && refreshToken.startsWith("access ")) {
                // Extract the token from the Authorization header
                refreshToken = refreshToken.substring(7);
                return refreshToken;
            }
        }
        return null; // Return null if refresh token is not found in both parameters and headers
    }



}
















