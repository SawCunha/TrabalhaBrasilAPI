package br.com.sawcunha.trabalhabrasilapi.feign.salariobr;

import br.com.sawcunha.trabalhabrasilapi.configuration.SalarioBRFeingConfiguration;
import br.com.sawcunha.trabalhabrasilapi.model.PositionParam;
import br.com.sawcunha.trabalhabrasilapi.model.Positions;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        value = "SalarioBR",
        url = "${salarioBR.url}",
        configuration = { SalarioBRFeingConfiguration.class }
)
public interface SalarioBRClient {

    @GetMapping(value = "/Funcoes/converter")
    Positions findPosition(@SpringQueryMap(encoded = true) PositionParam positionParam);
}
