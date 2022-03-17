package br.com.sawcunha.trabalhabrasilapi.controller;

import br.com.sawcunha.trabalhabrasilapi.commons.dto.CityDTO;
import br.com.sawcunha.trabalhabrasilapi.commons.dto.CityQueryParamDTO;
import br.com.sawcunha.trabalhabrasilapi.commons.dto.JobDTO;
import br.com.sawcunha.trabalhabrasilapi.commons.dto.JobQueryParamDTO;
import br.com.sawcunha.trabalhabrasilapi.commons.dto.PositionDTO;
import br.com.sawcunha.trabalhabrasilapi.commons.dto.PositionQueryParamDTO;
import br.com.sawcunha.trabalhabrasilapi.service.TrabalhaBrasilServiceBean;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class TrabalhaBrasilAPIController {

    private final TrabalhaBrasilServiceBean trabalhaBrasilServiceBean;

    @GetMapping("/v1/job")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<JobDTO>> findJob(@SpringQueryMap JobQueryParamDTO jobQueryParamDTO) {
        List<JobDTO> jobsDTO = trabalhaBrasilServiceBean.findJob(jobQueryParamDTO);
        return ResponseEntity.ok(jobsDTO);
    }

    @GetMapping("/v1/city")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CityDTO>> findCity(@SpringQueryMap CityQueryParamDTO cityQueryParamDTO) {
        List<CityDTO> cities = trabalhaBrasilServiceBean.findCity(cityQueryParamDTO);
        return ResponseEntity.ok(cities);
    }

    @GetMapping("/v1/position")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<PositionDTO>> findPosition(@SpringQueryMap PositionQueryParamDTO positionQueryParamDTO) {
        List<PositionDTO> positions = trabalhaBrasilServiceBean.findPosition(positionQueryParamDTO);
        return ResponseEntity.ok(positions);
    }

}
