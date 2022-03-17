package br.com.sawcunha.trabalhabrasilapi.commons.mapper;

import br.com.sawcunha.trabalhabrasilapi.commons.dto.CityQueryParamDTO;
import br.com.sawcunha.trabalhabrasilapi.commons.utils.StringUtils;
import br.com.sawcunha.trabalhabrasilapi.model.CityParam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        imports = {
            StringUtils.class
        }
)
public interface CityParamMapper {

    @Mapping(target = "partialDesc", expression = "java(StringUtils.encodeValue(cityQueryParamDTO.getName()))")
    CityParam toDefault(CityQueryParamDTO cityQueryParamDTO);

}
