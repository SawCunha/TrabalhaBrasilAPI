package br.com.sawcunha.trabalhabrasilapi.commons.dto;

import lombok.Data;

@Data
public class JobQueryParamDTO {

    private String positionID;
    private String cityID;
    private String page;
    private String research;
    private String order;
    private String userID;
    private Boolean isHomeOffice;

}
