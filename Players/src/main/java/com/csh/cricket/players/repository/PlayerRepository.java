package com.csh.cricket.players.repository;

import com.csh.cricket.players.PlayerNameProjection;
import com.csh.cricket.players.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> getPlayersByCountryId(int countryId);
    PlayerNameProjection findNameById(int id);
}
