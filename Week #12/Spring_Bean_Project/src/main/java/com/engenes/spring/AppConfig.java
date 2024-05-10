package com.engenes.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // Proje her derlendiğinde Currency service nesnesi oluşuyor bir tane
@Bean
    public CurrencyService currencyService() {
        return new CurrencyService();
    }
}
