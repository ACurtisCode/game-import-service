package com.alexc.gameimportservice.resources;

import com.alexc.gameimportservice.models.Game;
import com.alexc.gameimportservice.models.GameList;
import com.alexc.gameimportservice.models.Genre;
import com.alexc.gameimportservice.models.Tag;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameResource {
    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping("/{id}")
    public Game getGame(@PathVariable("id") String id) {
        Game returnedGame = restTemplate.getForObject("https://api.rawg.io/api/games/" + id + "?key=" + apiKey, Game.class);
        return returnedGame;
    }
    @RequestMapping("/{searchParam}")
    public List<Game> searchGames(@RequestParam("searchParam") String searchParam) {
        GameList returnedGames = restTemplate.getForObject("https://api.rawg.io/api/games?key=" + apiKey + "&search=" + searchParam, GameList.class);
        List<Game> games = returnedGames.getGameList();
        return games;
    }

    @RequestMapping("/{id}/tags")
    public List<Tag> getGameTags(@PathVariable("id") String id) {
        Game returnedGame = restTemplate.getForObject("https://api.rawg.io/api/games/" + id + "?key=" + apiKey, Game.class);
        return returnedGame.getTagList();
    }

    @RequestMapping("/{id}/genres")
    public List<Genre> getGameGenres(@PathVariable String id) {
        Game returnedGame = restTemplate.getForObject("https://api.rawg.io/api/games/" + id + "?key=" + apiKey, Game.class);
        return returnedGame.getGenreList();
    }
}
