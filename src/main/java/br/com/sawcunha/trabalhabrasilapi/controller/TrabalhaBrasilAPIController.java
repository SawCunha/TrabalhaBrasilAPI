package br.com.sawcunha.trabalhabrasilapi.controller;

import br.com.sawcunha.trabalhabrasilapi.commons.dto.JobDTO;
import br.com.sawcunha.trabalhabrasilapi.model.JobParam;
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
    public ResponseEntity<List<JobDTO>> findJob(@SpringQueryMap JobParam jobParam) {
        List<JobDTO> jobsDTO = trabalhaBrasilServiceBean.findJob(jobParam);
        return ResponseEntity.ok(jobsDTO);
    }

}
