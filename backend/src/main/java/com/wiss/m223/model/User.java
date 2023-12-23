package com.wiss.m223.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

/**
 * Diese Klassen enthalten die grundlegenden Entitätsdefinitionen für Benutzer,
 * Notizbuch, Kategorien und Notizen, jeweils mit den entsprechenden Annotationen für JPA-Entitäten und der
 * Zuordnung zwischen den Entitäten
 * mithilfe von @ManyToOne- und @JoinColumn-Annotationen
 */
// Diese Entity-Klasse repräsentiert einen Benutzer in der Datenbank.
@Entity
@Table(name = "User")
public class User {
    // Hier definiere ich die ID, den Benutzernamen, das Passwort und die E-Mail des Benutzers als Felder.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Die ID wird automatisch generiert.
    private Long userId;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String email;

    // Eine Set-Kollektion, um die Rollen des Benutzers zu speichern. Jeder Benutzer kann mehrere Rollen haben.
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    public User(Long userId, String username, String password, String email, String role) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {
    }
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public Set<Role> getRoles() {
        return roles;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    public <Permissions> void setPermissions(Permissions permissionsDTO) {
        
    }
}