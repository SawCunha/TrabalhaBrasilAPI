package br.com.sawcunha.trabalhabrasilapi.commons.mapper;

import br.com.sawcunha.trabalhabrasilapi.commons.dto.PositionDTO;
import br.com.sawcunha.trabalhabrasilapi.model.Position;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PositionMapper {

    @Mapping(source = "descricao", target = "description")
    PositionDTO toDTO(Position position);

    List<PositionDTO> toDTOs(List<Position> positions);

}
