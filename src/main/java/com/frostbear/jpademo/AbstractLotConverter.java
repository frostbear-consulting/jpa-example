package com.frostbear.jpademo;

import com.frostbear.jpademo.domain.AccountTypeLoT;
import com.frostbear.jpademo.domain.IListOfTypes;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public abstract class AbstractLotConverter<E extends IListOfTypes> implements AttributeConverter<E, String> {

    @Override
    public String convertToDatabaseColumn(IListOfTypes attribute) {
        return attribute.getCode();
    }

    @Override
    public E convertToEntityAttribute(String dbData) {
        var enumClass = this.getEnumClass();

        for(var value : enumClass.getEnumConstants()) {
            if(value.getCode().equals(dbData)) {
                return value;
            }
        }

        throw new IllegalArgumentException("Unknown LoT code: %s".formatted(dbData));
    }

    protected abstract Class<E> getEnumClass();
}