package com.alexc.gameimportservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Developer {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("name")
    private String name;

    public Developer() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
