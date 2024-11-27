package com.example.bankmanagement.service;

import com.example.bankmanagement.dto.AccountResponse;
import com.example.bankmanagement.dto.CardRequest;
import com.example.bankmanagement.dto.CardResponse;

import java.util.List;

public interface CardService {
    CardResponse createCard(CardRequest cardRequest);
    CardResponse updateCard(Long cardId, CardRequest cardRequest) throws Exception;
    CardResponse getCardById(Long cardId);
    void deleteCard(Long cardId) throws Exception;
    List<CardResponse> getAllCards();
}
