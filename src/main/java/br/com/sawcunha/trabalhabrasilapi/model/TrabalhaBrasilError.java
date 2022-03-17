package br.com.sawcunha.trabalhabrasilapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TrabalhaBrasilError {

    @JsonProperty("Message")
    private String message;

}
