package com.wiss.m223.helper;

import java.util.List;

// Ich definiere die Klasse als öffentlich, um sie in anderen Teilen der Anwendung verwenden zu können.
public class JwtResponse {
    // Private Felder für den Token und seine Eigenschaften.
    private String token;
    private String type = "Bearer";// Der Standard-Token-Typ ist "Bearer".
    private Long id;
    private String username;
    private String email;
    private List<String> roles;// Eine Liste der Rollen, die dem Benutzer zugewiesen sind.

    public JwtResponse(String accessToken, Long id, String username, String email, List<String> roles) {// Der Konstruktor der Klasse, der verschiedene Parameter für die JWT-Antwort entgegennimmt.
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    // Standard-Getter für den Token.
    public String getToken() {
        return token;
    }

    // Standard-Setter für den Token.
    public void setToken(String token) {
        this.token = token;
    }

    // Getter für den Token-Typ. Standardmäßig "Bearer".
    public String getTokenType() {
        return type;
    }

    // Setter für den Token-Typ.
    public void setTokenType(String type) {
        this.type = type;
    }

    // Getter für die Benutzer-ID.
    public Long getId() {
        return id;
    }

    // Setter für die Benutzer-ID.
    public void setId(Long id) {
        this.id = id;
    }

    // Getter für den Benutzernamen.
    public String getUsername() {
        return username;
    }

    // Setter für den Benutzernamen.
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter für die E-Mail-Adresse.
    public String getEmail() {
        return email;
    }

    // Setter für die E-Mail-Adresse.
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter für die Rollenliste.
    public List<String> getRoles() {
        return roles;
    }

    // Setter für die Rollenliste.
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}