package com.csh.cricket.players.service;

import com.csh.cricket.players.entity.Player;
import com.csh.cricket.players.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;

    @Override
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player updatePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public void deletePlayer(int id) {
        playerRepository.deleteById(id);
    }

    @Override
    public List<Player> getPlayersByCountry(int countryId) {
        return  playerRepository.getPlayersByCountryId(countryId);
    }

    @Override
    public String getPlayerNameById(int id) {
        return playerRepository.findNameById(id).getName();
    }
}
