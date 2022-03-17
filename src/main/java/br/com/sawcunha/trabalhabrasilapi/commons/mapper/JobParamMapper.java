package br.com.sawcunha.trabalhabrasilapi.commons.mapper;

import br.com.sawcunha.trabalhabrasilapi.commons.dto.JobQueryParamDTO;
import br.com.sawcunha.trabalhabrasilapi.model.JobParam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface JobParamMapper {

    @Mapping(target = "idFuncao", source = "positionID", defaultValue = "")
    @Mapping(target = "idCidade", source = "cityID", defaultValue = "")
    @Mapping(target = "pagina", source = "page", defaultValue = "1")
    @Mapping(target = "pesquisa", source = "research", defaultValue = "")
    @Mapping(target = "ordenacao", source = "order", defaultValue = "1")
    @Mapping(target = "idUsuario", source = "userID", defaultValue = "")
    @Mapping(target = "flgHomeOffice", source = "isHomeOffice", defaultValue = "false")
    JobParam toDefault(JobQueryParamDTO jobQueryParamDTO);

}
