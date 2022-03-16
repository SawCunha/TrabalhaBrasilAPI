package br.com.sawcunha.trabalhabrasilapi.feign.trabalhabrasil;

import br.com.sawcunha.trabalhabrasilapi.model.Job;
import br.com.sawcunha.trabalhabrasilapi.model.JobParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "job", url = "https://www.trabalhabrasil.com.br/api/v1.0/")
public interface TrabalhaBrasilJobClient {

    @RequestMapping(method = RequestMethod.GET, value = "/job/List")
    List<Job> findJob(@SpringQueryMap(encoded = true) JobParam jobParam);

}
