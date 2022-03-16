package br.com.sawcunha.trabalhabrasilapi.commons.mapper;

import br.com.sawcunha.trabalhabrasilapi.model.JobParam;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-15T21:40:34-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class JobParamMapperImpl implements JobParamMapper {

    @Override
    public JobParam toDefault(JobParam jobParam) {
        if ( jobParam == null ) {
            return null;
        }

        JobParam jobParam1 = new JobParam();

        if ( jobParam.getIdFuncao() != null ) {
            jobParam1.setIdFuncao( jobParam.getIdFuncao() );
        }
        else {
            jobParam1.setIdFuncao( "" );
        }
        if ( jobParam.getIdCidade() != null ) {
            jobParam1.setIdCidade( jobParam.getIdCidade() );
        }
        else {
            jobParam1.setIdCidade( "" );
        }
        if ( jobParam.getPagina() != null ) {
            jobParam1.setPagina( jobParam.getPagina() );
        }
        else {
            jobParam1.setPagina( "1" );
        }
        if ( jobParam.getPesquisa() != null ) {
            jobParam1.setPesquisa( jobParam.getPesquisa() );
        }
        else {
            jobParam1.setPesquisa( "" );
        }
        if ( jobParam.getOrdenacao() != null ) {
            jobParam1.setOrdenacao( jobParam.getOrdenacao() );
        }
        else {
            jobParam1.setOrdenacao( "1" );
        }
        if ( jobParam.getIdUsuario() != null ) {
            jobParam1.setIdUsuario( jobParam.getIdUsuario() );
        }
        else {
            jobParam1.setIdUsuario( "" );
        }
        if ( jobParam.getFlgHomeOffice() != null ) {
            jobParam1.setFlgHomeOffice( jobParam.getFlgHomeOffice() );
        }
        else {
            jobParam1.setFlgHomeOffice( false );
        }

        return jobParam1;
    }
}
