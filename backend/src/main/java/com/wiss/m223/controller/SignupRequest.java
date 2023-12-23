/*
Ähnlich wie LoginRequest, aber für Registrierungsanfragen.
Enthält zusätzliche Informationen wie E-Mail und Rollen.
 */
package com.wiss.m223.controller;
import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// Die Klasse ist öffentlich und definiert die Daten, die für eine Anmeldeanfrage benötigt werden.
public class SignupRequest {

    // Hier deklariere ich die Benutzername-Variable mit Validierungsanforderungen.
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
    // Das gleiche für die E-Mail-Adresse, zusätzlich mit einer E-Mail-Validierung.
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    // Ein Set für die Rollen, die einem Benutzer zugewiesen werden können.
    private Set<String> role;
    // Und schliesslich das Passwort mit den Mindest- und Höchstanforderungen an die Länge.
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    // Standard-Getter für den Benutzernamen.
    public String getUsername() {
        return username;
    }
    // Standard-Setter für den Benutzernamen.
    public void setUsername(String username) {
        this.username = username;
    }
    // Standard-Getter für die E-Mail.
    public String getEmail() {
        return email;
    }

    // Standard-Setter für die E-Mail.
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter für die Rolle(n). Gibt das Set der Rollen zurück.
    public Set<String> getRole() {
        return role;
    }

    // Setter für die Rolle(n). Ermöglicht es, die Rollen eines Benutzers zu setzen oder zu ändern.
    public void setRole(Set<String> role) {
        this.role = role;
    }

    // Standard-Getter für das Passwort.
    public String getPassword() {
        return password;
    }

    // Standard-Setter für das Passwort.
    public void setPassword(String password) {
        this.password = password;
    }
}
