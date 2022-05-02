package com.frostbear.jpademo;

import com.frostbear.jpademo.domain.AccountTypeLoT;
import javax.persistence.Converter;

@Converter
public class LotConverter extends AbstractLotConverter<AccountTypeLoT> {

    @Override
    protected Class<AccountTypeLoT> getEnumClass() {
        return AccountTypeLoT.class;
    }
}