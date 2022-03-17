package br.com.sawcunha.trabalhabrasilapi.commons.mapper;

import br.com.sawcunha.trabalhabrasilapi.commons.dto.CityDTO;
import br.com.sawcunha.trabalhabrasilapi.model.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {

    @Mapping(source = "descricao", target = "description")
    CityDTO toDTO(City city);

    List<CityDTO> toDTOs(List<City> cities);

}
