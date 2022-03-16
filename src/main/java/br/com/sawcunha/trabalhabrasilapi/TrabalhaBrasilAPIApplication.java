package br.com.sawcunha.trabalhabrasilapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"br.com.sawcunha.trabalhabrasilapi"})
@AutoConfigurationPackage
@EnableFeignClients
public class TrabalhaBrasilAPIApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrabalhaBrasilAPIApplication.class, args);
    }

}
