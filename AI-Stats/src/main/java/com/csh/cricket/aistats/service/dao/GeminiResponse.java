package com.csh.cricket.aistats.service.dao;

import java.util.List;

public record GeminiResponse(
        List<Candidate> candidates
) {
    public record Candidate(Content content) {}
    public record Content(List<Part> parts) {}
    public record Part(String text) {}
}

