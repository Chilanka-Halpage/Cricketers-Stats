package com.csh.cricket.aistats.service;

import com.csh.cricket.aistats.service.dao.GeminiRequest;
import com.csh.cricket.aistats.service.dao.GeminiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class GeminiServiceImpl implements GeminiService {

    private final WebClient geminiServiceWebClient;
    private final PlayerService playerService;

    @Override
    public String getPlayerStats(int playerId) {
        try {
            String playerName = getPlayerName(playerId);
            GeminiRequest requestBody = getRequestBody(playerName);
            GeminiResponse response = geminiServiceWebClient.post()
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(GeminiResponse.class)
                    .block();

            return response.candidates().getFirst().content().parts().getFirst().text();
        } catch (Exception e) {
            log.error(e.getMessage(), e.getMessage());
            throw e;
        }
    }

    private String getPlayerName(int playerId) {
        String playerName = playerService.getPlayerName(playerId);
        if (playerName == null) {
            throw new RuntimeException("Player " + playerId + " not found");
        }

        return playerName;
    }

    private GeminiRequest getRequestBody(String playerName) {
        String prompt = String.format("""
                Give Test, ODI and T20I stats of [%s] referring to https://www.espncricinfo.com/cricketers - ESPN Cric Info in following json format.
                {
                	test: {
                	    ranking:
                		matches:
                		innings:
                		runs:
                		average:
                		highestScore:
                		hundreds:
                		fifties:
                		strikeRate:
                	},
                	odi : {
                	    ranking:
                		matches:
                		innings:
                		runs:
                		average:
                		highestScore:
                		hundreds:
                		fifties:
                		strikeRate:
                	},
                	t20i : {
                		ranking:
                		matches:
                		innings:
                		runs:
                		average:
                		highestScore:
                		hundreds:
                		fifties:
                		strikeRate:
                	}
                Please give the response using EXACT above format and dont include ```json``` in response
                }""", playerName);

        return new GeminiRequest(
                List.of(new GeminiRequest.Content(
                                List.of(new GeminiRequest.Part(prompt))
                        )
                ));
    }
}
