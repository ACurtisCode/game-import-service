package com.alexc.gameimportservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tag  {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("language")
    private String language;
    @JsonProperty("name")
    private String name;

    public Tag() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
