package com.wiss.m223.controller;
/**
 * In diesen Controllern können Endpunkte definiert werden,
 * um auf die entsprechenden Service-Klassen zuzugreifen und Daten abzurufen, zu erstellen,
 * zu aktualisieren oder zu löschen.
 */

import com.wiss.m223.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController<UserDTO, Permissions> {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/new")
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
        return ResponseEntity.ok("New user created!");
    }

    @PutMapping("/{userId}/permissions")
    public ResponseEntity<String> changePermissions(@PathVariable Long userId, @RequestBody Permissions permissionsDTO) {
        userService.changePermissions(userId, permissionsDTO);
        return ResponseEntity.ok("Permissions updated!");
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted!");
    }
}
