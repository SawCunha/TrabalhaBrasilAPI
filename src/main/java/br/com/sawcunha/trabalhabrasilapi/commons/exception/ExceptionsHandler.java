package br.com.sawcunha.trabalhabrasilapi.commons.exception;

import br.com.sawcunha.trabalhabrasilapi.commons.dto.TrabalhaBrasilExeptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    private TrabalhaBrasilExeptionDTO createResponse(int status, String message){
        return TrabalhaBrasilExeptionDTO.builder()
                .status(status)
                .message(message)
                .build();
    }

    @ExceptionHandler(TrabalhaBrasilExeption.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected TrabalhaBrasilExeptionDTO handleSecurity(TrabalhaBrasilExeption exception){
        return createResponse(exception.getStatus(), exception.getMessage());
    }

}
