package com.alexc.gameimportservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Game {
    @JsonProperty("id")
    private Long rawgId;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("name")
    private String title;
    @JsonProperty("description_raw")
    private String description;
    @JsonProperty("tags")
    private List<Tag> tagList;

    public Game() {
    }

    public Long getRawgId() {
        return rawgId;
    }

    public void setRawgId(Long rawgId) {
        this.rawgId = rawgId;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
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

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }
}
