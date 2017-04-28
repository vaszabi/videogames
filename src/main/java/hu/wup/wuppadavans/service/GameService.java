package hu.wup.wuppadavans.service;


import hu.wup.wuppadavans.dto.GameDto;

import java.util.List;

public interface GameService {

    GameDto register(GameDto gameDto);

    GameDto loadGameById(Long gameDtoId);

    List<GameDto> loadAllGames();

    void deleteGameById(Long gameDtoId);

    void deleteAllGames();

    void updateGame(GameDto gameDto, Long gameDtoId);

}
