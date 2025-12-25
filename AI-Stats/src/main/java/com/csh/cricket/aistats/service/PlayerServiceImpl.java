package com.csh.cricket.aistats.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {


    private final WebClient playerServiceWebClient;

    @Override
    public String getPlayerName(int id) {
        return playerServiceWebClient.get()
                .uri("/api/players/{id}", id)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

}
