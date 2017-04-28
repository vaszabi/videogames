package hu.wup.wuppadavans.controller;

import hu.wup.wuppadavans.model.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface GameController {

    @RequestMapping(value = "/game",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<Game> register(@RequestBody Game game);

    @RequestMapping(value = "/game/{gameId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Game> loadGameById(@PathVariable("gameId") Long gameId);

    @RequestMapping(value = "/game",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<List<Game>> loadAllGames();

    @RequestMapping(value = "/game/{gameId}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    @ResponseBody
    ResponseEntity<Void> deleteGameById(@PathVariable("gameId") Long gameId);

    @RequestMapping(value = "/game",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    @ResponseBody
    ResponseEntity<Void> deleteAllGames();

    @RequestMapping(value = "/game/{gameId}",
            produces = {"application/json"},
            method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<Void> updateGame(@RequestBody Game game, @PathVariable("gameId") Long gameId);


}
