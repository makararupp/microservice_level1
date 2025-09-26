package com.makara.bank.card.mapper;

import com.makara.bank.card.dto.CardDTO;
import com.makara.bank.card.entity.Card;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper {
    Card toCard(CardDTO dto);
}
