package br.com.sawcunha.trabalhabrasilapi.commons.exception;

import lombok.Getter;

@Getter
public class TrabalhaBrasilExeption extends RuntimeException{

    private final int status;
    private final String message;
    public TrabalhaBrasilExeption(int status, String message) {
        super(message);
        this.message = message;
        this.status = status;
    }
}
