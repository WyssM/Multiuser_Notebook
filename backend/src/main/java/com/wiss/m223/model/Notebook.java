package com.wiss.m223.model;

import java.util.Date;
import jakarta.persistence.*;
@Entity
@Table(name = "Notebook")
public class Notebook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notebookId;
    private String title;
    private String description;
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "creatorId")
    private User creator;

    public Notebook(Long notebookId, String title, String description, Date creationDate, User creator) {
        this.notebookId = notebookId;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.creator = creator;
    }

    public Notebook() {
    }

    public Long getNotebookId() {
        return notebookId;
    }

    public void setNotebookId(Long notebookId) {
        this.notebookId = notebookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
}


