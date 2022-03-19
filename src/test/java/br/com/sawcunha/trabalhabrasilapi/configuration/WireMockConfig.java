package br.com.sawcunha.trabalhabrasilapi.configuration;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

@TestConfiguration
public class WireMockConfig {

    @Bean(initMethod = "start", destroyMethod = "stop")
    public WireMockServer wireMockServer() {
        WireMockServer wireMockServer = new WireMockServer(
                options().port(9558)
        );

        System.out.println("Stub mapping size: " + wireMockServer.getStubMappings().size());

        return wireMockServer;
    }

}