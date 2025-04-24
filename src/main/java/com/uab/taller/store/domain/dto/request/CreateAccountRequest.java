package com.uab.taller.store.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAccountRequest {
    public String currencyType;
    public float balance;
    public Long userId;
}

