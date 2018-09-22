package com.site.kido.kidding.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.site.kido.kidding" })
public class KidoKiddingApplication {

    public static void main(String[] args) {
        SpringApplication.run(KidoKiddingApplication.class, args);
    }
}
