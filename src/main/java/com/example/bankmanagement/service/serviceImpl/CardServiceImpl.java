package com.example.bankmanagement.service.serviceImpl;

import com.example.bankmanagement.Util.Constants;
import com.example.bankmanagement.dto.CardRequest;
import com.example.bankmanagement.dto.CardResponse;
import com.example.bankmanagement.entity.Account;
import com.example.bankmanagement.entity.Card;
import com.example.bankmanagement.repositories.AccountRepository;
import com.example.bankmanagement.repositories.CardRepository;
import com.example.bankmanagement.service.CardService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final AccountRepository accountRepository;

    public CardServiceImpl(CardRepository cardRepository, AccountRepository accountRepository) {
        this.cardRepository = cardRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public CardResponse createCard(CardRequest cardRequest) {
        Account account = accountRepository.findById(cardRequest.getAccountId())
                .orElseThrow(() -> new RuntimeException("Account not found"));

        Card card = new Card();
        card.setAccountId(account);
        card.setCardType(cardRequest.getCardType());

        LocalDate now = LocalDate.now();
        LocalDate expiry = now.plusYears(2);
        Timestamp expiryDate = Timestamp.valueOf(expiry.atStartOfDay());
        card.setExpiryDate(expiryDate);

        card.setStatus(1);

        Card savedCard = cardRepository.save(card);
        return mapToResponse(savedCard);
    }

    @Override
    public CardResponse updateCard(Long cardId, CardRequest cardRequest) throws Exception {
        Optional<Card> oldCardOptional = cardRepository.findById(cardId);
        if (oldCardOptional.isPresent()) {
            Card oldCard = oldCardOptional.get();

            if (cardRequest.getCardType() != null) {
                oldCard.setCardType(cardRequest.getCardType());
            }

            Card updatedCard = cardRepository.save(oldCard);
            return mapToResponse(updatedCard);
        } else {
            throw new Exception("Card not found with id: " + cardId);
        }
    }

    @Override
    public void deleteCard(Long cardId) throws Exception {
        Optional<Card> cardOptional = cardRepository.findById(cardId);
        if (cardOptional.isPresent()) {
            Card card = cardOptional.get();
            card.setStatus(Constants.INACTIVE);
            cardRepository.save(card);

        } else {
            throw new Exception("Card not found with id: " + cardId);
        }
    }

    @Override
    public CardResponse getCardById(Long cardId) {
        // Lấy thẻ theo cardId
        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new RuntimeException("Card not found"));
        return mapToResponse(card);
    }

    @Override
    public List<CardResponse> getAllCards() {
        return cardRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private CardResponse mapToResponse(Card card) {
        CardResponse response = new CardResponse();
        response.setCardId(card.getCardId());
        response.setCardType(card.getCardType());
        response.setExpiryDate(card.getExpiryDate());
        response.setStatus(card.getStatus());
        response.setAccountId(card.getAccountId().getAccountId());
        return response;
    }
}
