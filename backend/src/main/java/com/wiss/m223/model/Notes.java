package com.wiss.m223.model;

import jakarta.persistence.*;

import java.util.Date;

// Diese Entity-Klasse repräsentiert eine Notiz in der Datenbank.
@Entity
@Table(name = "Notes")
public class Notes {
    //Ich definiere die Attribute einer Notiz wie ID, Titel, Inhalt und Erstellungsdatum.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noteId;
    private String title;
    private String content;
    private Date creationDate;
    private Date lastUpdate;

    // 3 Beziehungen, die angeben, welcher Benutzer und welches Notizbuch die Notiz besitzt.
    @ManyToOne
    @JoinColumn(name = "creatorId")
    private User creator;

    @ManyToOne
    @JoinColumn(name = "notebookId")
    private Notebook notebook;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Categories category;

    public Notes(Long noteId, String title, String content, Date creationDate, Date lastUpdate, User creator, Notebook notebook, Categories category) {
        this.noteId = noteId;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.lastUpdate = lastUpdate;
        this.creator = creator;
        this.notebook = notebook;
        this.category = category;
    }

    public Notes() {
    }

    public Long getNoteId() {
        return noteId;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }
}
