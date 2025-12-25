package com.csh.cricket.players.service;

import com.csh.cricket.players.entity.Player;

import java.util.List;

public interface PlayerService {
    Player createPlayer(Player player);
    Player updatePlayer(Player player);
    void deletePlayer(int id);
    List<Player> getPlayersByCountry(int countryId);
    String getPlayerNameById(int id);
}
