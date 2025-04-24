package com.uab.taller.store.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
public class CreateUserRequest {
    String email;
    String password;
    String name;
    String lastName;
    char gender;
    Date birthday;
    public String currencyType;
    public float balance;

}
