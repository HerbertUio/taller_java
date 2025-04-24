package com.uab.taller.store.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    int number = generateAccountNumber();
    String currencyType;
    float balance;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    @JsonBackReference
    User user;

    public int generateAccountNumber() {
        int accountNumber = 10001;
        int randomNumber = (int) (Math.random() * 90000) + 10000;
        accountNumber = Integer.parseInt(String.valueOf(accountNumber) + String.valueOf(randomNumber));
        return accountNumber;
    }
}
