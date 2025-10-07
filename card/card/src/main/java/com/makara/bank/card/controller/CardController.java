package com.makara.bank.card.controller;

import com.makara.bank.card.dto.CardDTO;
import com.makara.bank.card.entity.Card;
import com.makara.bank.card.mapper.CardMapper;
import com.makara.bank.card.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private CardService cardService;
    @Autowired
    private CardMapper cardMapper;

    @PostMapping
    public ResponseEntity<?> createCard(@RequestBody CardDTO dto){
        Card card = cardService.save(cardMapper.toCard(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(card);
    }

    @GetMapping
    public ResponseEntity<?> getCards(){
        return ResponseEntity.ok(cardService.getList());
    }

    // Get card by customerId
    @GetMapping("/{customerId}")
    public ResponseEntity<?> getCardByCustomerId(@PathVariable Long customerId){
        List<Card> cards = cardService.getByCustomerId(customerId);
        return ResponseEntity.ok(cards);
    }

}
