package com.makara.account.dto;

import lombok.Data;

import java.util.List;

@Data
public class CustomerDetailDTO {
    // Customer information while be returned.
    private CustomerDTO customer;
    private List<CardResponseDTO> cards;
    private List<LoanResponseDTO> loans;
}
