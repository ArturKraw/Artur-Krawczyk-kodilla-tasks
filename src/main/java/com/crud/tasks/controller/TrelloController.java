package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
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
/*
    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public Optional<TrelloBoardDto> getTrelloBoards2(@RequstParam String id) throws TrelloBoardNotFoundException {

          System.out.println("Filtr 3: wszystkie tablice zawierające <KApplication> w nazwie z użyciem klasy Optional   ");

          return  trelloBoards.stream()
                .filter(trelloBoardDto -> (trelloBoardDto.getName().contains("Application")) )
                .forEach(trelloBoardDto -> System.out.println("id: " + trelloBoardDto.getId()
                        + " " + "name: " + trelloBoardDto.getName() + "lists: " + trelloBoardDto.getLists() ).orElseThrow(TrelloBoardNotFoundException::new}));
*/
/*
        https://api.trello.com/1/boards/
        5a54c5fdca8c1587176424c9?
        fields=id,name,desc&lists=open&list_fields=id,name,idBoard,pos,subscrribed,url&key=68bf5d07c76ab49a81114995116fd219&token=c718d58a25854b12f55adf4f203ba6b9a49616726d4eea937226f13336adbe30


        System.out.println(" " + "\n");
    }
*/
}




