package com.example.bankmanagement.controller;

import com.example.bankmanagement.dto.CardRequest;
import com.example.bankmanagement.dto.CardResponse;
import com.example.bankmanagement.service.CardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    // 1. Create Card
    @PostMapping("/add")
    public ResponseEntity<CardResponse> createCard(@Valid @RequestBody CardRequest cardRequest) {
        CardResponse response = cardService.createCard(cardRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // 2. Update Card
    @PutMapping("/{cardId}")
    public ResponseEntity<CardResponse> updateCard(
            @PathVariable Long cardId,
            @Valid @RequestBody CardRequest cardRequest) throws Exception {
        CardResponse response = cardService.updateCard(cardId, cardRequest);
        return ResponseEntity.ok(response);
    }

    // 3. Delete Card
    @DeleteMapping("/{cardId}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long cardId) throws Exception {
        cardService.deleteCard(cardId);
        return ResponseEntity.ok().build();
    }

    // 4. Get Card by ID
    @GetMapping("/{cardId}")
    public ResponseEntity<CardResponse> getCardById(@PathVariable Long cardId) {
        CardResponse response = cardService.getCardById(cardId);
        return ResponseEntity.ok(response);
    }

    // 5. Get All Cards
    @GetMapping
    public ResponseEntity<List<CardResponse>> getAllCards() {
        List<CardResponse> responseList = cardService.getAllCards();
        return ResponseEntity.ok(responseList);
    }
}
