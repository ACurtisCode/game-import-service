package com.alexc.gameimportservice.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GameService {
    @Value("${api.key}")
    private String apiKey;
    public String UrlBuilder(Map<String, String> searchTerms) {
        StringBuilder url = new StringBuilder();
        url.append("https://api.rawg.io/api/games?key=" + apiKey);
        for(Map.Entry<String, String> param : searchTerms.entrySet()) {
            //url.append("&" + param.getKey() + "=" + param.getValue());
            url.append("&");
            url.append(param.getKey());
            url.append("=");
            url.append(param.getValue());
        }
        url.append("&stores=1");
        System.out.println(url);
        return url.toString();
    }
}
