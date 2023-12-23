// Diese Klasse ist mein Authentication Entry Point für JWT-basierte Authentifizierung.
package com.wiss.m223.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
Handle Authentication Exception override the commence() method.
This method is triggered anytime an unauthenticated User requests a secured HTTP
resource and an AuthenticationException is thrown
 */

// Sie implementiert AuthenticationEntryPoint und überschreibt die commence-Methode.
@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {
    private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);// Logger für Logging-Zwecke.

    // Die Methode wird aufgerufen, wenn eine nicht authentifizierte Anfrage auf einen gesicherten Endpunkt trifft.
    @Override
    public void commence(HttpServletRequest request,
            HttpServletResponse response, AuthenticationException authException)
            throws IOException, jakarta.servlet.ServletException {
        logger.error("Unauthorized error: {}", authException.getMessage());// Logge, dass eine nicht autorisierte Anfrage abgefangen wurde.
        try {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized"); // Senden einer HttpServletResponse.SC_UNAUTHORIZED-Antwort.
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
