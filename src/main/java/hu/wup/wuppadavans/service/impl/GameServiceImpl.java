package hu.wup.wuppadavans.service.impl;

import hu.wup.wuppadavans.dto.GameDto;
import hu.wup.wuppadavans.entity.GameEntity;
import hu.wup.wuppadavans.repository.GameRepository;
import hu.wup.wuppadavans.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("gameService")
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;


    @Override
    public GameDto register(GameDto gameDto) {
        GameEntity gameEntity = new GameEntity();
        gameEntity.setId(gameDto.getId());
        gameEntity.setName(gameDto.getName());
        gameEntity.setProducer(gameDto.getProducer());
        gameEntity.setGenre(gameDto.getGenre());
        gameEntity.setPlatform(gameDto.getPlatform());
        gameEntity.setRelease(gameDto.getRelease());
        gameEntity.setPrice(gameDto.getPrice());
        gameEntity.setAvailablity(gameDto.isAvailablity());

        GameEntity savedData = gameRepository.save(gameEntity);
        GameDto savedGameDto = new GameDto();
        savedGameDto.setId(savedData.getId());
        savedGameDto.setName(savedData.getName());
        savedGameDto.setProducer(savedData.getProducer());
        savedGameDto.setGenre(savedData.getGenre());
        savedGameDto.setPlatform(savedData.getPlatform());
        savedGameDto.setRelease(savedData.getRelease());
        savedGameDto.setPrice(savedData.getPrice());
        savedGameDto.setAvailablity(savedData.isAvailablity());

        return savedGameDto;
    }

    @Override
    public GameDto loadGameById(Long gameDtoId) {
        GameEntity gameEntity = gameRepository.findOne(gameDtoId);

        GameDto gameDto = new GameDto();
        gameDto.setId(gameEntity.getId());
        gameDto.setName(gameEntity.getName());
        gameDto.setProducer(gameEntity.getProducer());
        gameDto.setGenre(gameEntity.getGenre());
        gameDto.setPlatform(gameEntity.getPlatform());
        gameDto.setRelease(gameEntity.getRelease());
        gameDto.setPrice(gameEntity.getPrice());
        gameDto.setAvailablity(gameEntity.isAvailablity());

        return gameDto;
    }

    @Override
    public List<GameDto> loadAllGames() {
        List<GameDto> gameDtos = new ArrayList<>();
        List<GameEntity> gameEntities = gameRepository.findAll();
        for (GameEntity gameEntity : gameEntities) {
            GameDto gameDto = new GameDto();
            gameDto.setId(gameEntity.getId());
            gameDto.setName(gameEntity.getName());
            gameDto.setProducer(gameEntity.getProducer());
            gameDto.setGenre(gameEntity.getGenre());
            gameDto.setPlatform(gameEntity.getPlatform());
            gameDto.setRelease(gameEntity.getRelease());
            gameDto.setPrice(gameEntity.getPrice());
            gameDto.setAvailablity(gameEntity.isAvailablity());


            gameDtos.add(gameDto);
        }
        return gameDtos;
    }

    @Override
    public void deleteGameById(Long gameDtoId) {
        gameRepository.delete(gameDtoId);
    }

    @Override
    public void deleteAllGames() {
        gameRepository.deleteAll();
    }

    @Override
    public void updateGame(GameDto gameDto, Long gameDtoId) {
        GameEntity gameEntity = gameRepository.findOne(gameDtoId);

        gameEntity.setName(gameDto.getName());
        gameEntity.setProducer(gameDto.getProducer());
        gameEntity.setGenre(gameDto.getGenre());
        gameEntity.setPlatform(gameDto.getPlatform());
        gameEntity.setRelease(gameDto.getRelease());
        gameEntity.setPrice(gameDto.getPrice());
        gameEntity.setAvailablity(gameDto.isAvailablity());

        gameRepository.save(gameEntity);
    }
}
