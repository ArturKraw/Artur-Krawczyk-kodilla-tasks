package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloClient trelloClient;



    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public void getTrelloBoards() {

        System.out.println("Filtr 1: wszystkie tablice (id, name) ");

        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

            trelloBoards.forEach(trelloBoardDto -> System.out.println("id: " + trelloBoardDto.getId()
                        + " " + "name: " + trelloBoardDto.getName()));

        System.out.println("Filtr 2: wszystkie tablice zawierające <Kodilla> w nazwie (id, name)  ");

            trelloBoards.stream()
                .filter(trelloBoardDto -> (trelloBoardDto.getName().contains("Kodilla")) )
                .forEach(trelloBoardDto -> System.out.println("id: " + trelloBoardDto.getId()
                + " " + "name: " + trelloBoardDto.getName()));

        System.out.println(" " + "\n");
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public Optional< List<TrelloBoardDto>> getTrelloBoards2() {

        System.out.println("Filtr 3: wszystkie tablice zawierające <Application> w nazwie z użyciem klasy Optional   ");

        List <TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

        List <TrelloBoardDto> filteredTrelloBoards = trelloBoards.stream()
                .filter(trelloBoardDto -> (trelloBoardDto.getName().contains("Application")))
                .collect(Collectors.toList());

        if (filteredTrelloBoards.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(filteredTrelloBoards);

    }
}




