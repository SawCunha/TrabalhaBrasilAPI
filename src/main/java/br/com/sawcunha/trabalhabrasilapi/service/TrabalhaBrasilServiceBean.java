package br.com.sawcunha.trabalhabrasilapi.service;

import br.com.sawcunha.trabalhabrasilapi.commons.dto.JobDTO;
import br.com.sawcunha.trabalhabrasilapi.commons.mapper.JobMapper;
import br.com.sawcunha.trabalhabrasilapi.commons.mapper.JobParamMapper;
import br.com.sawcunha.trabalhabrasilapi.feign.trabalhabrasil.TrabalhaBrasilJobClient;
import br.com.sawcunha.trabalhabrasilapi.model.Job;
import br.com.sawcunha.trabalhabrasilapi.model.JobParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TrabalhaBrasilServiceBean {

    private final TrabalhaBrasilJobClient trabalhaBrasilJobClient;
    private final JobParamMapper jobParamMapper;
    private final JobMapper jobMapper;

    public List<JobDTO> findJob(final JobParam jobParam){
        List<Job> jobList = trabalhaBrasilJobClient.findJob(
                jobParamMapper.toDefault(jobParam)
        );

        return jobMapper.toDTOs(jobList);
    }

}
