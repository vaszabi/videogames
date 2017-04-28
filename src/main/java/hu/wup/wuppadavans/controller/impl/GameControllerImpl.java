package hu.wup.wuppadavans.controller.impl;

import hu.wup.wuppadavans.controller.GameController;
import hu.wup.wuppadavans.dto.GameDto;
import hu.wup.wuppadavans.model.Game;
import hu.wup.wuppadavans.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GameControllerImpl implements GameController {

    @Autowired
    private GameService gameService;

    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }

    public ResponseEntity<Game> register(@RequestBody Game game) {
        GameDto gameDto = new GameDto();
        gameDto.setId(game.getId());
        gameDto.setName(game.getName());
        gameDto.setProducer(game.getProducer());
        gameDto.setGenre(game.getGenre());
        gameDto.setPlatform(game.getPlatform());
        gameDto.setRelease(game.getRelease());
        gameDto.setPrice(game.getPrice());
        gameDto.setAvailablity(game.isAvailablity());

        gameService.register(gameDto);

        return ResponseEntity.ok(game);

    }

    @Override
    public ResponseEntity<Game> loadGameById(@PathVariable Long gameId) {
        GameDto gameDto = gameService.loadGameById(gameId);

        Game game = new Game();
        game.setId(gameDto.getId());
        game.setName(gameDto.getName());
        game.setProducer(gameDto.getProducer());
        game.setGenre(gameDto.getGenre());
        game.setPlatform(gameDto.getPlatform());
        game.setRelease(gameDto.getRelease());
        game.setPrice(gameDto.getPrice());
        game.setAvailablity(gameDto.isAvailablity());

        return ResponseEntity.ok(game);
    }

    @Override
    public ResponseEntity<List<Game>> loadAllGames() {

        List<GameDto> gameDtoList = gameService.loadAllGames();
        List<Game> gameList = new ArrayList<>();

        for (GameDto gameDto : gameDtoList) {
            Game game = new Game();
            game.setId(gameDto.getId());
            game.setName(gameDto.getName());
            game.setProducer(gameDto.getProducer());
            game.setGenre(gameDto.getGenre());
            game.setPlatform(gameDto.getPlatform());
            game.setRelease(gameDto.getRelease());
            game.setPrice(gameDto.getPrice());
            game.setAvailablity(gameDto.isAvailablity());

            gameList.add(game);
        }
        return ResponseEntity.ok(gameList);
    }

    @Override
    public ResponseEntity<Void> deleteGameById(@PathVariable Long gameId) {
        gameService.deleteGameById(gameId);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteAllGames() {
        gameService.deleteAllGames();
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> updateGame(@RequestBody Game game,@PathVariable Long gameId) {
        GameDto gameDto = gameService.loadGameById(gameId);
        gameDto.setName(game.getName());
        gameDto.setProducer(game.getProducer());
        gameDto.setGenre(game.getGenre());
        gameDto.setPlatform(game.getPlatform());
        gameDto.setRelease(game.getRelease());
        gameDto.setPrice(game.getPrice());
        gameDto.setAvailablity(game.isAvailablity());

        gameService.updateGame(gameDto, gameDto.getId());


        return ResponseEntity.ok().build();
    }


}
