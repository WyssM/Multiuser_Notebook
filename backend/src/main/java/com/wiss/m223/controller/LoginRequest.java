/*
Diese Klasse repräsentiert die Anforderungsstruktur für Login-Anfragen.
Sie enthält die notwendigen Felder wie Benutzername und Passwort.
 */
package com.wiss.m223.controller;
public class LoginRequest {
    // Zwei private Felder: Benutzername und Passwort. Sie sind privat, um die Daten zu schützen.
    private String username;
    private String password;

    // Standard-Getter für den Benutzernamen. Ermöglicht es anderen Klassen, den Benutzernamen zu lesen.
    public String getUsername() {
        return username;
    }
    // Standard-Setter für den Benutzernamen. Ermöglicht es anderen Klassen, den Benutzernamen zu setzen.
    public void setUsername(String username) {
        this.username = username;
    }
    // Standard-Getter für das Passwort. Gibt das Passwort zurück.
    public String getPassword() {
        return password;
    }
    // Standard-Setter für das Passwort. Ermöglicht das Setzen eines neuen Passworts.
    public void setPassword(String password) {
        this.password = password;
    }
    // Ein leerer Konstruktor. Nützlich für die Frameworks und Bibliotheken, die Reflexion verwenden.
    public LoginRequest() {
    }
    // Ein Konstruktor, der Benutzername und Passwort als Parameter nimmt. Erleichtert das Erstellen eines LoginRequest-Objekts.
    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
