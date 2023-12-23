package com.wiss.m223.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "creatorId")
    private User creator;

    public Categories(Long categoryId, String name, String description, User creator) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.creator = creator;
    }

    public Categories() {
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
}
