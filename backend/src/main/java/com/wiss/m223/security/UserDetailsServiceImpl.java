// Diese Klasse implementiert UserDetailsService und wird verwendet, um Benutzerdetails zu laden.
package com.wiss.m223.security;


import com.wiss.m223.model.User;
import com.wiss.m223.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// Ich markiere es als Service, damit es im Spring-Kontext verwaltet wird.
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    // Überschreiben der Methode loadUserByUsername, um Benutzerdetails zu laden.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return UserDetailsImpl.build(user);
    }
}
