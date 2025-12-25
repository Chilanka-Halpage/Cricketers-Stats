package com.csh.cricket.players.controller;

import com.csh.cricket.players.entity.Player;
import com.csh.cricket.players.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        return ResponseEntity.status(HttpStatus.CREATED).body(playerService.createPlayer(player));
    }

    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
        return ResponseEntity.ok(playerService.updatePlayer(player));
    }

    @GetMapping("/country/{countryId}")
    public ResponseEntity<List<Player>> getPlayersByCountryId(@PathVariable int countryId) {
        return ResponseEntity.ok(playerService.getPlayersByCountry(countryId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getPlayerNameById(@PathVariable int id) {
        return ResponseEntity.ok(playerService.getPlayerNameById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlayerById(@PathVariable int id) {
        playerService.deletePlayer(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
