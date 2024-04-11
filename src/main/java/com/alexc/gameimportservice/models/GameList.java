package com.alexc.gameimportservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class GameList {
    @JsonProperty("results")
    private List<Game> gameList;

    public GameList() {
        gameList = new ArrayList<>();
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }
}
