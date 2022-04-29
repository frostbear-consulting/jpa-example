package com.frostbear.jpademo;

import com.frostbear.jpademo.service.ICreateStuff;
import com.frostbear.jpademo.service.IUpdateStuff;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpademoApplication {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(JpademoApplication.class, args);

        var created = ctx.getBean(ICreateStuff.class).createStuff();
        ctx.getBean(IUpdateStuff.class).update(created);
    }

}