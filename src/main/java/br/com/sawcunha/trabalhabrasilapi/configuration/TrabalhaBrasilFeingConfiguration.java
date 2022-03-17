package br.com.sawcunha.trabalhabrasilapi.configuration;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class TrabalhaBrasilFeingConfiguration {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new TrabalhaBrasilErrorDecoder();
    }

}
