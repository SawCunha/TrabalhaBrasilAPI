package br.com.sawcunha.trabalhabrasilapi.feign.salariobr;

import br.com.sawcunha.trabalhabrasilapi.model.Position;
import br.com.sawcunha.trabalhabrasilapi.model.PositionParam;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
class SalarioBRClientTest {

    @Autowired
    private WireMockServer wireMockServer;

    @Autowired
    private SalarioBRClient salarioBRClient;

    @Test
    void whenGetPosition_thenPositionShouldBeReturned() {
        PositionParam positionParam = new PositionParam();

        positionParam.setFuncao("Desenvolvedor");
        positionParam.setOrigem("sine");

        List<Position> positionList = salarioBRClient.findPosition(positionParam).getFuncoes();

        assertFalse(positionList.isEmpty());
        assertTrue(positionList.stream().anyMatch(position -> position.getId() == 3540));
        assertTrue(positionList.stream().anyMatch(position -> position.getId() == 12143));
        assertTrue(positionList.stream().anyMatch(position -> position.getId() == 12307));
        assertTrue(positionList.stream().anyMatch(position -> position.getId() == 11594));

        assertTrue(positionList.stream().anyMatch(position -> position.getDescricao().equals("Desenvolvedor Frontend")));
        assertTrue(positionList.stream().anyMatch(position -> position.getDescricao().equals("Desenvolvedor Mobile")));
        assertTrue(positionList.stream().anyMatch(position -> position.getDescricao().equals("Desenvolvedor JAVA")));
        assertTrue(positionList.stream().anyMatch(position -> position.getDescricao().equals("Desenvolvedor IOS")));
    }

}