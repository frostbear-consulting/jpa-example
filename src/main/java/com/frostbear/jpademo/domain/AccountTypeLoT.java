package com.frostbear.jpademo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountTypeLoT {

    CHECKING("CH"),
    SAVINGS("SV")

    ;

    private final String code;
}