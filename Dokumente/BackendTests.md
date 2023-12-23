## Übersicht
Diese Dokumentation beschreibt die Unit-Tests für die `M223Application` in Java. Es gibt zwei Haupttestklassen: `AuthControllerTest` und `UserRepositoryTest`.

## AuthControllerTest
### Ziel
Testet die Authentifizierungsfunktionalität in der `AuthController`-Klasse.

### Testfälle

#### `testAuthenticateUser_Success`
- **Ziel**: Überprüft die erfolgreiche Authentifizierung eines Benutzers.
- **Methodik**:
  - Mocking von `AuthenticationManager` und `JwtUtils`.
  - Erstellen eines `LoginRequest` mit Benutzername und Passwort.
  - Überprüfen der Rückgabe eines `JwtResponse` bei erfolgreicher Authentifizierung.
- **Erwartetes Ergebnis**: 
  - Die Methode `authenticateUser` gibt einen `ResponseEntity` mit Status `HttpStatus.OK` zurück.
  - Der Körper der Antwort ist eine Instanz von `JwtResponse`.

## UserRepositoryTest
### Ziel
Testet die Benutzerabfragefunktionalität in der `UserRepository`-Klasse.

### Testfälle

#### `testFindByUsername_Found`
- **Ziel**: Stellt sicher, dass die Methode `findByUsername` den richtigen Benutzer findet.
- **Methodik**:
  - Mocking von `UserRepository`.
  - Erstellen und Zurückgeben eines gemockten `User`-Objekts bei Aufruf von `findByUsername`.
  - Überprüfen, ob das zurückgegebene `Optional<User>` das erwartete Benutzerobjekt enthält.
- **Erwartetes Ergebnis**: 
  - Die Methode `findByUsername` findet den Benutzer und gibt ein `Optional<User>` zurück, das den Benutzer enthält.
  - Der Benutzername des gefundenen Benutzers entspricht dem erwarteten Namen.
