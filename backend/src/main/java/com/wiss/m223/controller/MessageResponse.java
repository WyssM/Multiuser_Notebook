/*
Einfache Klasse zur Darstellung einer Nachricht als Antwort.
Nützlich für die Rückgabe von Feedback-Nachrichten an den Client.
package com.wiss.m223.controller;
*/
package com.wiss.m223.controller;
public class MessageResponse {

    // Ein privates Feld für die Nachricht. Ich halte es privat, um die Datenkapselung zu gewährleisten.
    private String message;
    // Dies ist der Konstruktor der Klasse. Er nimmt eine Nachricht entgegen und setzt sie für das Objekt.
    public MessageResponse(String messsage) {
        this.message = messsage;
    }
    // Eine Getter-Methode, um den Wert der Nachricht abzurufen. Standard Getter-Methodik.
    public String getMessage() {
        return message;
    }
    // Eine Setter-Methode, um den Wert der Nachricht zu ändern. Auch das ist ganz typisch.
    public void setMessage(String message) {
        this.message = message;
    }

}
