package com.frostbear.jpademo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountTypeLoT implements IListOfTypes {

    CHECKING("CH"),
    SAVINGS("SV")

    ;

    private final String code;


    @Override
    public <T extends IListOfTypes> T[] getValues() {
        return (T[]) AccountTypeLoT.values();
    }
}