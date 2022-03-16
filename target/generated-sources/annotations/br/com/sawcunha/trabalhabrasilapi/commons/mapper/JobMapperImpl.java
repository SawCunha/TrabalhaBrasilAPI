package br.com.sawcunha.trabalhabrasilapi.commons.mapper;

import br.com.sawcunha.trabalhabrasilapi.commons.dto.JobDTO;
import br.com.sawcunha.trabalhabrasilapi.model.Job;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-15T21:40:34-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class JobMapperImpl implements JobMapper {

    @Override
    public JobDTO toDTO(Job job) {
        if ( job == null ) {
            return null;
        }

        JobDTO jobDTO = new JobDTO();

        jobDTO.setId( job.getId() );
        jobDTO.setDf( job.getDf() );
        jobDTO.setUf( job.getUf() );
        jobDTO.setCss( job.getCss() );
        jobDTO.setQv( job.getQv() );
        Set<String> set = job.getPcd();
        if ( set != null ) {
            jobDTO.setPcd( new HashSet<String>( set ) );
        }
        jobDTO.setSt( job.getSt() );
        jobDTO.setCn( job.getCn() );
        jobDTO.setCa( job.getCa() );

        return jobDTO;
    }

    @Override
    public List<JobDTO> toDTOs(List<Job> job) {
        if ( job == null ) {
            return null;
        }

        List<JobDTO> list = new ArrayList<JobDTO>( job.size() );
        for ( Job job1 : job ) {
            list.add( toDTO( job1 ) );
        }

        return list;
    }
}
