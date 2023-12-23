package com.wiss.m223.controller;
/**
 * In diesen Controllern können Endpunkte definiert werden,
 * um auf die entsprechenden Service-Klassen zuzugreifen und Daten abzurufen, zu erstellen,
 * zu aktualisieren oder zu löschen.
 */

import com.wiss.m223.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Annotation, um diese Klasse als REST-Controller zu kennzeichnen, mit einem Basispfad für alle Endpunkte.
@RestController
@RequestMapping("/user")
public class UserController<UserDTO, Permissions> {


    private final UserService userService;// Eine Instanz des UserService, um die logik auszuführen.
    public UserController(UserService userService) { // Konstruktor der Klasse, der eine Instanz von UserService entgegennimmt und initialisiert.
        this.userService = userService;
    }

    // Endpunkt zum Erstellen eines neuen Benutzers. Akzeptiert Benutzerdaten im Request-Body.
    @PostMapping("/new")
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO); // Ruft die Methode createUser des UserService auf, um den Benutzer zu erstellen.
        return ResponseEntity.ok("New user created!");// Gibt eine Erfolgsmeldung zurück, wenn der Benutzer erstellt wurde.
    }

    // Endpunkt zum Ändern der Berechtigungen eines Benutzers. Nimmt die Benutzer-ID und die neuen Berechtigungen entgegen.
    @PutMapping("/{userId}/permissions")
    public ResponseEntity<String> changePermissions(@PathVariable Long userId, @RequestBody Permissions permissionsDTO) {
        userService.changePermissions(userId, permissionsDTO);// Ruft die Methode changePermissions des UserService auf, um die Berechtigungen zu ändern.
        return ResponseEntity.ok("Permissions updated!");// Gibt eine Erfolgsmeldung zurück, wenn die Berechtigungen aktualisiert wurden.
    }
    // Endpunkt zum Löschen eines Benutzers. Nimmt die Benutzer-ID als Pfadvariable entgegen.
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId); // Ruft die Methode deleteUser des UserService auf, um den Benutzer zu löschen.
        return ResponseEntity.ok("User deleted!");// Gibt eine Erfolgsmeldung zurück, wenn der Benutzer gelöscht wurde.
    }
}
