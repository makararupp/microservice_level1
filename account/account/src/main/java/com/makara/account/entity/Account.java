package com.makara.account.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNumber;
    @ManyToOne
    @JoinColumn(name = "customerId",nullable = false)
    private Customer customer;
    private String accountType;
    private String branchAddress;
    private LocalDate createDate;

}
