package br.com.sawcunha.trabalhabrasilapi.commons.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TrabalhaBrasilExeptionDTO {

    private String message;
    private int status;

}
