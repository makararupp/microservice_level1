package com.makara.bank.card.service;


import com.makara.bank.card.entity.Card;

import java.util.List;

public interface CardService {
    Card save(Card loan);
    List<Card> getList();
    List<Card> getByCustomerId(Long customerId);
}
