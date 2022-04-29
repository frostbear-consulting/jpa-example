package com.frostbear.jpademo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.Random;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Xref {

    private String xref;

    public static Xref create() {
        var value = String.format("%04x%04x", new Random().nextInt(0x10000), new Random().nextInt(0x10000));

        return new Xref(value);
    }
}