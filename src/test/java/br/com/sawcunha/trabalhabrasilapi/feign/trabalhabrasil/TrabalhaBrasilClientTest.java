package br.com.sawcunha.trabalhabrasilapi.feign.trabalhabrasil;

import br.com.sawcunha.trabalhabrasilapi.model.City;
import br.com.sawcunha.trabalhabrasilapi.model.CityParam;
import br.com.sawcunha.trabalhabrasilapi.model.Job;
import br.com.sawcunha.trabalhabrasilapi.model.JobParam;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
class TrabalhaBrasilClientTest {

    @Autowired
    private WireMockServer wireMockServer;

    @Autowired
    private TrabalhaBrasilClient trabalhaBrasilClient;

    @Test
    void whenGetCities_thenCitiesShouldBeReturned() {
        CityParam jobParam = new CityParam();

        jobParam.setPartialDesc("Barba");

        List<City> jobs = trabalhaBrasilClient.findCity(jobParam);

        assertFalse(jobs.isEmpty());
        assertTrue(jobs.stream().anyMatch(job -> job.getId() == 4786));
        assertTrue(jobs.stream().anyMatch(job -> job.getId() == 9835));
        assertTrue(jobs.stream().anyMatch(job -> job.getId() == 539));
        assertTrue(jobs.stream().anyMatch(job -> job.getId() == 1083));

        assertTrue(jobs.stream().anyMatch(job -> job.getDescricao().equals("Águas de Santa Bárbara / SP")));
        assertTrue(jobs.stream().anyMatch(job -> job.getDescricao().equals("Barbalha / CE")));
        assertTrue(jobs.stream().anyMatch(job -> job.getDescricao().equals("Santa Bárbara / PR")));
        assertTrue(jobs.stream().anyMatch(job -> job.getDescricao().equals("Barbada / CE")));
    }

    @Test
    void whenGetJobs_thenJobsShouldBeReturned() {
        JobParam jobParam = new JobParam();

        jobParam.setIdCidade("1");
        jobParam.setIdFuncao("1");
        jobParam.setFlgHomeOffice(true);
        jobParam.setOrdenacao("Ordenacao");
        jobParam.setPesquisa("Pesquisa");
        jobParam.setPagina("1");

        List<Job> jobs = trabalhaBrasilClient.findJob(jobParam);

        assertFalse(jobs.isEmpty());
        assertTrue(jobs.stream().anyMatch(job -> job.getId() == 8526486));
        assertTrue(jobs.stream().anyMatch(job -> job.getId() == 8526485));

        assertTrue(jobs.stream()
                .anyMatch(
                        job -> job
                                .getTt()
                                .equals("Vaga de emprego para Recrutador na empresa Pontocom Consultoria De Inteligência Financeira em São Paulo / SP")
                )
        );
        assertTrue(jobs.stream()
                .anyMatch(
                        job -> job
                                .getTt()
                                .equals("Vaga de emprego para Consultor de Vendas na empresa Rhino Associação Mútua em Uberlândia / MG")
                )
        );

        assertTrue(jobs.stream().anyMatch(job -> job.getSl().equals("R$ 1.500,00")));
        assertTrue(jobs.stream().anyMatch(job -> job.getSl().equals("R$ 1.361,26")));
    }

}