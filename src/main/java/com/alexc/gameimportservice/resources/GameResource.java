package com.alexc.gameimportservice.resources;

import com.alexc.gameimportservice.models.Game;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    public Game getGames(@PathVariable("id") String id) {
        Game returnedGame = restTemplate.getForObject("https://api.rawg.io/api/games/" + id + "?key=" + apiKey, Game.class);

        return returnedGame;
    }
}
