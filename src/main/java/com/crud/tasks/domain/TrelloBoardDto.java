package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@AllArgsConstructor
@Getter
public class TrelloBoardDto {
    private String name;
    private String id;

    @Value("${trello.api.endpoint.prod)")
    private String trelloApiEndpoint;

    @Value("${trello.app.key)")
    private String trelloAppKey;

    @Value("${trello.app.token)")
    private String trelloToken;


    @Autowired
    private RestTemplate restTemplate;

    public List<TrelloBoardDto> getTrelloBoards () {

        URI url = UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/members/arturkrawczyk7/boards")
                .queryParam("key", trelloAppKey)
                .queryParam("token", trelloToken)
                .queryParam("fields", "name,id")
                .build().encode().toUri();

        TrelloBoardDto[] boardsResponse = restTemplate.getForObject(url, TrelloBoardDto[].class);
                //"https://api.trello.com/1/memebers/arturkrawczyk7/boards", TrelloBoardDto[].class);
                //trelloApiEndpoint + "/members/arturkrawczyk7/boards" + "?key=" + trelloAppKey + "?token=" +trelloToken,
                //TrelloBoardDto[].class);

        if (boardsResponse != null) {
            return Arrays.asList(boardsResponse);
        }
        return new ArrayList<>();

    }

}
