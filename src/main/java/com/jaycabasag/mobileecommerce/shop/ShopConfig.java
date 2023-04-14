package com.jaycabasag.mobileecommerce.shop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Configuration
public class ShopConfig {
    @Bean
    CommandLineRunner commandLineRunner(ShopRepository shopRepository){
        return args -> {};
    }
}
