package br.com.sawcunha.trabalhabrasilapi.commons.mapper;

import br.com.sawcunha.trabalhabrasilapi.commons.dto.JobDTO;
import br.com.sawcunha.trabalhabrasilapi.model.Job;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JobMapper {

    JobDTO toDTO(Job job);
    List<JobDTO> toDTOs(List<Job> job);

}
