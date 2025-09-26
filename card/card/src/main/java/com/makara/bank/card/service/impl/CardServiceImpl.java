package com.makara.bank.card.service.impl;

import com.makara.bank.card.entity.Card;
import com.makara.bank.card.repository.CardRepository;
import com.makara.bank.card.service.CardService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;

    @Override
    public Card save(Card card) {
         return cardRepository.save(card);
    }
    @Override
    public List<Card> getList() { 
        return cardRepository.findAll();
    }
    @Override
    public List<Card> getByCustomerId(Long customerId) {
            return cardRepository.findByCustomerId(customerId);
    }
}
