package com.alexc.gameimportservice.resources;

import com.alexc.gameimportservice.models.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameResource {
    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    //return single game by id or slug
    @GetMapping("/{id}")
    public Game getGame(@PathVariable("id") String id) {
        Game returnedGame = restTemplate.getForObject("https://api.rawg.io/api/games/" + id + "?key=" + apiKey, Game.class);
        return returnedGame;
    }

    //return list of games based on partial title
    @GetMapping("/")
    public List<Game> searchGames(@RequestParam(required = true) String title) {
        GameList returnedGames = restTemplate.getForObject("https://api.rawg.io/api/games?key=" + apiKey + "&search=" + title + "&stores=1", GameList.class);
        List<Game> games = returnedGames.getGameList();
        return games;
    }

    //return list of games based on tags either 1,3 or MMO,Multiplayer
//    @GetMapping("/")
//    public List<Game> searchByTag(@RequestParam(required = true) String tag) {
//        GameList returnedGames = restTemplate.getForObject("https://api.rawg.io/api/games?key=" + apiKey + "&tag=" + tag + "&stores=1", GameList.class);
//        List<Game> games = returnedGames.getGameList();
//        return games;
//    }

    //return list of games based on genres either 1,3 or indie,action
//    @GetMapping("/")
//    public List<Game> searchByGenre(@RequestParam(required = true) String genre) {
//        GameList returnedGames = restTemplate.getForObject("https://api.rawg.io/api/games?key=" + apiKey + "&genre=" + genre + "&stores=1", GameList.class);
//        List<Game> games = returnedGames.getGameList();
//        return games;
//    }

    //return list of games based on developers either 1,3 or valve-software,ea-games
//    @GetMapping("/")
//    public List<Game> searchByDeveloper(@RequestParam(required = true) String developer) {
//        GameList returnedGames = restTemplate.getForObject("https://api.rawg.io/api/games?key=" + apiKey + "&developers=" + developer + "&stores=1", GameList.class);
//        List<Game> games = returnedGames.getGameList();
//        return games;
//    }

    //return list of games based on genres either 1,3 or indie,action and tags either 1,3 or MMO,Multiplayer
//    @GetMapping("/")
//    public List<Game> searchByGenreTag(@RequestParam(required = true) String genre, @RequestParam(required = true) String tag) {
//        GameList returnedGames = restTemplate.getForObject("https://api.rawg.io/api/games?key=" + apiKey + "&genre=" + genre + "&tag=" + tag +"&stores=1", GameList.class);
//        List<Game> games = returnedGames.getGameList();
//        return games;
//    }

    //return list of games based on genres either 1,3 or indie,action and tags either 1,3 or MMO,Multiplayer and developers either 1,3 or valve-software,ea-games
//    @GetMapping("/")
//    public List<Game> searchByGenreTagDeveloper(@RequestParam(required = true) String genre, @RequestParam(required = true) String tag, @RequestParam(required = true) String developer) {
//        GameList returnedGames = restTemplate.getForObject("https://api.rawg.io/api/games?key=" + apiKey + "&genre=" + genre + "&tag=" + tag + "&developers=" + developer + "&stores=1", GameList.class);
//        List<Game> games = returnedGames.getGameList();
//        return games;
//    }

    //return tags of game by id or slug
    @GetMapping("/{id}/tags")
    public List<Tag> getGameTags(@PathVariable("id") String id) {
        Game returnedGame = restTemplate.getForObject("https://api.rawg.io/api/games/" + id + "?key=" + apiKey, Game.class);
        return returnedGame.getTagList();
    }

    //return genres of game by tag or slug
    @GetMapping("/{id}/genres")
    public List<Genre> getGameGenres(@PathVariable String id) {
        Game returnedGame = restTemplate.getForObject("https://api.rawg.io/api/games/" + id + "?key=" + apiKey, Game.class);
        return returnedGame.getGenreList();
    }

    //return genres of game by tag or slug
    @GetMapping("/{id}/developers")
    public List<Developer> getGameDevelopers(@PathVariable String id) {
        Game returnedGame = restTemplate.getForObject("https://api.rawg.io/api/games/" + id + "?key=" + apiKey, Game.class);
        return returnedGame.getDeveloperList();
    }
}
