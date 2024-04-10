package com.alexc.gameimportservice.models;

import java.util.ArrayList;
import java.util.List;

public class GameList {
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
