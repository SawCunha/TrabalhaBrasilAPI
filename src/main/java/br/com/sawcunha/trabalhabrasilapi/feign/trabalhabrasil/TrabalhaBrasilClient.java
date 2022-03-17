package br.com.sawcunha.trabalhabrasilapi.feign.trabalhabrasil;

import br.com.sawcunha.trabalhabrasilapi.configuration.TrabalhaBrasilFeingConfiguration;
import br.com.sawcunha.trabalhabrasilapi.model.City;
import br.com.sawcunha.trabalhabrasilapi.model.CityParam;
import br.com.sawcunha.trabalhabrasilapi.model.Job;
import br.com.sawcunha.trabalhabrasilapi.model.JobParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(
        value = "TrabalhaBrasilAPI",
        url = "${trabalhaBrasil.url}",
        configuration = { TrabalhaBrasilFeingConfiguration.class }
)
public interface TrabalhaBrasilClient {

    @GetMapping(value = "/job/List")
    List<Job> findJob(@SpringQueryMap(encoded = true) JobParam jobParam);

    @GetMapping(value = "/Cidade/List")
    List<City> findCity(@SpringQueryMap(encoded = true) CityParam cityParam);
}
