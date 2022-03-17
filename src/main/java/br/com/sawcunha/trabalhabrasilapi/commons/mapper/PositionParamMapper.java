package br.com.sawcunha.trabalhabrasilapi.commons.mapper;

import br.com.sawcunha.trabalhabrasilapi.commons.dto.PositionQueryParamDTO;
import br.com.sawcunha.trabalhabrasilapi.commons.utils.StringUtils;
import br.com.sawcunha.trabalhabrasilapi.model.PositionParam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        imports = {
                StringUtils.class
        }
)
public interface PositionParamMapper {

    @Mapping(
            target = "funcao",
            expression = "java(StringUtils.encodeValue(positionQueryParamDTO.getPosition()))"
    )
    @Mapping(target = "origem", constant = "sine")
    PositionParam toDefault(PositionQueryParamDTO positionQueryParamDTO);

}
