package br.com.sawcunha.trabalhabrasilapi.configuration;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class SalarioBRFeingConfiguration {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new SalarioBRErrorDecoder();
    }

}
