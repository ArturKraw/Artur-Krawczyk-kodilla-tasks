package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;


@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloClient trelloClient;


    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards(){
        return trelloClient.getTrelloBoards();
    }


    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public void getTrelloBoards1() {

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
/*
    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public List<Optional <TrelloBoardDto>> getTrelloBoards4() {

        System.out.println("Filtr 4: wszystkie tablice z użyciem klasy Optional   ");

        List <TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

        List <TrelloBoardDto> filteredTrelloBoards = trelloBoards.stream()
                .filter(trelloBoardDto -> (trelloBoardDto.getName().contains("Application")))
                .collect(Collectors.toList());

        return Arrays.asList(ofNullable(filteredTrelloBoards));
        //   return Arrays.asList(ofNullable(boardsResponse).orElse(new TrelloBoardDto[0]));
    }
*/
    @RequestMapping(method = RequestMethod.POST, value = "createTrelloCard")
    public CreatedTrelloCard createTrelloCard (@RequestBody TrelloCardDto trelloCardDto) {
        return trelloClient.createNewCard(trelloCardDto);
    }

}




