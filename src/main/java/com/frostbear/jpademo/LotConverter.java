package com.frostbear.jpademo;

import com.frostbear.jpademo.domain.AccountTypeLoT;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class LotConverter implements AttributeConverter<AccountTypeLoT, String> {

    @Override
    public String convertToDatabaseColumn(AccountTypeLoT attribute) {
        return attribute.getCode();
    }

    @Override
    public AccountTypeLoT convertToEntityAttribute(String dbData) {
        for(var value : AccountTypeLoT.values()) {
            if(value.getCode().equals(dbData)) {
                return value;
            }
        }

        throw new IllegalArgumentException("Unknown LoT code: %s".formatted(dbData));
    }
}