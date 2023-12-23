// Diese Klasse ist mein Filter, der bei jeder Anfrage überprüft, ob ein gültiger JWT-Token vorhanden ist.
package com.wiss.m223.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// *
//  * a filter that executes once per request. AuthTokenFilter class that extends
//  * OncePerRequestFilter and overrides doFilterInternal() method.

// Erweitere OncePerRequestFilter, um die Filtermethode doFilterInternal zu überschreiben.
public class AuthTokenFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

    // Die Methode doFilterInternal wird bei jeder Anfrage aufgerufen.
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Versuche, den JWT-Token aus der Anfrage zu extrahieren und zu validieren.
        try {
            String jwt = parseJwt(request);
            if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
                String username = jwtUtils.getUserNameFromJwtToken(jwt);// Holen der Benutzerdetails anhand des Tokens.
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                // Setzen der Benutzerdetails im SecurityContext.
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            logger.error("Cannot set user authentication: {}", e);// Loggen von Fehlern bei der Tokenvalidierung.
        }
        try {
            filterChain.doFilter(request, response);// Fortsetzen der Filterkette.
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    // Eine private Methode, um den JWT-Token aus dem Authorization-Header zu extrahieren.
    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7, headerAuth.length());
        }
        return null;
    }
}
