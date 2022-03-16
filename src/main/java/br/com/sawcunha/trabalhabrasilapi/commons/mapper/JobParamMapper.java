package br.com.sawcunha.trabalhabrasilapi.commons.mapper;

import br.com.sawcunha.trabalhabrasilapi.model.JobParam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface JobParamMapper {

    @Mapping(target = "idFuncao", source = "idFuncao", defaultValue = "")
    @Mapping(target = "idCidade", source = "idCidade", defaultValue = "")
    @Mapping(target = "pagina", source = "pagina", defaultValue = "1")
    @Mapping(target = "pesquisa", source = "pesquisa", defaultValue = "")
    @Mapping(target = "ordenacao", source = "ordenacao", defaultValue = "1")
    @Mapping(target = "idUsuario", source = "idUsuario", defaultValue = "")
    @Mapping(target = "flgHomeOffice", source = "flgHomeOffice", defaultValue = "false")
    JobParam toDefault(JobParam jobParam);

}
