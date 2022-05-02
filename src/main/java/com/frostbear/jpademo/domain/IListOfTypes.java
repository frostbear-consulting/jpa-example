package com.frostbear.jpademo.domain;

public interface IListOfTypes {

    String getCode();

    <T extends IListOfTypes> T[] getValues();
}