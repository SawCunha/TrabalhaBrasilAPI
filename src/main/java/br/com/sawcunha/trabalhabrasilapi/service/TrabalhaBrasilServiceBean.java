package br.com.sawcunha.trabalhabrasilapi.service;

import br.com.sawcunha.trabalhabrasilapi.commons.dto.CityDTO;
import br.com.sawcunha.trabalhabrasilapi.commons.dto.CityQueryParamDTO;
import br.com.sawcunha.trabalhabrasilapi.commons.dto.JobDTO;
import br.com.sawcunha.trabalhabrasilapi.commons.dto.JobQueryParamDTO;
import br.com.sawcunha.trabalhabrasilapi.commons.dto.PositionDTO;
import br.com.sawcunha.trabalhabrasilapi.commons.dto.PositionQueryParamDTO;
import br.com.sawcunha.trabalhabrasilapi.commons.mapper.CityMapper;
import br.com.sawcunha.trabalhabrasilapi.commons.mapper.CityParamMapper;
import br.com.sawcunha.trabalhabrasilapi.commons.mapper.JobMapper;
import br.com.sawcunha.trabalhabrasilapi.commons.mapper.JobParamMapper;
import br.com.sawcunha.trabalhabrasilapi.commons.mapper.PositionMapper;
import br.com.sawcunha.trabalhabrasilapi.commons.mapper.PositionParamMapper;
import br.com.sawcunha.trabalhabrasilapi.feign.salariobr.SalarioBRClient;
import br.com.sawcunha.trabalhabrasilapi.feign.trabalhabrasil.TrabalhaBrasilClient;
import br.com.sawcunha.trabalhabrasilapi.model.City;
import br.com.sawcunha.trabalhabrasilapi.model.Job;
import br.com.sawcunha.trabalhabrasilapi.model.Positions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TrabalhaBrasilServiceBean {

    private final TrabalhaBrasilClient trabalhaBrasilJobClient;
    private final SalarioBRClient salarioBRClient;
    private final JobParamMapper jobParamMapper;
    private final CityParamMapper cityParamMapper;
    private final PositionParamMapper positionParamMapper;
    private final JobMapper jobMapper;
    private final PositionMapper positionMapper;
    private final CityMapper cityMapper;

    public List<JobDTO> findJob(final JobQueryParamDTO jobQueryParamDTO){
        List<Job> jobList = trabalhaBrasilJobClient.findJob(
                jobParamMapper.toDefault(jobQueryParamDTO)
        );

        return jobMapper.toDTOs(jobList);
    }

    public List<CityDTO> findCity(final CityQueryParamDTO cityQueryParamDTO){
        List<City> cities = trabalhaBrasilJobClient.findCity(
                cityParamMapper.toDefault(cityQueryParamDTO)
        );

        return cityMapper.toDTOs(cities);
    }

    public List<PositionDTO> findPosition(final PositionQueryParamDTO positionQueryParamDTO){
        Positions positions = salarioBRClient.findPosition(
                positionParamMapper.toDefault(positionQueryParamDTO)
        );

        return positionMapper.toDTOs(positions.getFuncoes());
    }

}
