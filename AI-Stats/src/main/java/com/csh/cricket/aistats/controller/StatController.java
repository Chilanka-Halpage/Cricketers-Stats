package com.csh.cricket.aistats.controller;

import com.csh.cricket.aistats.service.GeminiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/stats")
public class StatController {

    private final GeminiService geminiService;

    @GetMapping("/{playerId}")
    public ResponseEntity<String> getPlayerStats(@PathVariable int playerId) {
        return ResponseEntity.ok(geminiService.getPlayerStats(playerId));
    }
}
