# Installationsanleitung für das Projekt

Diese Anleitung führt Sie durch die Installation und Einrichtung der notwendigen Tools und Frameworks für das Projekt, das Java (mit Spring Boot), MySQL, React (mit Vite) und Node.js verwendet.

## Voraussetzungen

- Installieren von [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) 
- Installieren von [MySQL](https://dev.mysql.com/downloads/mysql/).
- Installieren von [Node.js](https://nodejs.org/en/download/) 
- Installieren von [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) 
- Installieren von [Visual Studio Code](https://code.visualstudio.com/download).

## Backend-Setup (Java mit Spring Boot)

### IntelliJ IDEA öffnen

- Starten Sie IntelliJ IDEA.
- Wählen Sie "Open" und navigieren Sie zu Ihrem Projektverzeichnis, um das Backend-Projekt zu öffnen.

### Abhängigkeiten installieren

- IntelliJ sollte automatisch die Maven-Abhängigkeiten erkennen und installieren.
- Warten Sie, bis der Vorgang abgeschlossen ist.

### MySQL-Datenbank einrichten

- Starten Sie MySQL und erstellen Sie eine neue Datenbank für das Projekt.
- Aktualisieren Sie ggf. die `application.properties`-Datei im Backend-Projekt mit Ihren MySQL-Anmeldeinformationen und dem Datenbanknamen.

### Backend-Server starten

- Führen Sie die Hauptanwendungsklasse (`M223Application.java` oder ähnlich) aus, um den Backend-Server zu starten.

## Frontend-Setup (React mit Vite)

### Visual Studio Code öffnen

- Starten Sie Visual Studio Code.
- Wählen Sie "File > Open Folder" und navigieren Sie zu Ihrem Frontend-Projektverzeichnis.

### Node.js-Abhängigkeiten installieren

- Öffnen Sie ein Terminal in Visual Studio Code.
- Führen Sie den Befehl `npm install` im Frontend-Verzeichnis aus, um alle notwendigen Node.js-Abhängigkeiten zu installieren.

### Frontend-Server starten

- Führen Sie im Terminal `npm run dev` aus, um den React-Entwicklungsserver mit Vite zu starten.
- Navigieren Sie in Ihrem Browser zu `http://localhost:3000` (oder dem von Vite angegebenen Port), um das Frontend zu betrachten.

## Fertigstellung

Nachdem Sie sowohl das Backend als auch das Frontend gestartet haben, sollten Sie in der Lage sein, die volle Funktionalität Ihrer Anwendung zu nutzen.
