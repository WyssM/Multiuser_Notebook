/*
Dieser Controller verwaltet die Authentifizierungsfunktionen der Anwendung.
Er beinhaltet die Logik für die Anmeldung (Login) und Registrierung (Signup) der Benutzer.
 */
package com.wiss.m223.controller;

import com.wiss.m223.helper.JwtResponse;
import com.wiss.m223.model.ERole;
import com.wiss.m223.model.Role;
import com.wiss.m223.model.User;
import com.wiss.m223.repository.RoleRepository;
import com.wiss.m223.repository.UserRepository;
import com.wiss.m223.security.JwtUtils;
import com.wiss.m223.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

// Ich markiere diese Klasse als REST-Controller mit einem spezifischen Pfad für Authentifizierung.
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    // Dependency-Injection für verschiedene Services und Repositories.
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    // Ein POST-Endpunkt für die Benutzeranmeldung. Nimmt Login-Daten entgegen und authentifiziert den Benutzer.
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getAuthorities().stream()
                        .map(item -> item.getAuthority())
                        .collect(Collectors.toList())));
    }


    // Ein POST-Endpunkt für die Benutzerregistrierung. Nimmt Registrierungsdaten entgegen und erstellt einen neuen Benutzer.
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {// Überprüfung, ob der Benutzername bereits vergeben ist
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }


        User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));// Erstellung eines neuen Benutzerobjekts mit verschlüsseltem Passwort.


        Set<Role> userRoles = new HashSet<>(); // Set für die Benutzerrollen.

        // Zuweisung der Standardrolle zum Benutzer.
        Role userRole = roleRepository.findByName(ERole.valueOf(String.valueOf(ERole.ROLE_USER)))
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        user.setRoles(Collections.singleton(userRole));

        user.setRoles(userRoles);

        userRepository.save(user);// Speichern des neuen Benutzers in der Datenbank.

        return ResponseEntity.ok(new MessageResponse("User registered successfully!")); // Rückgabe einer Erfolgsmeldung, dass der Benutzer erfolgreich registriert wurde.
    }
}