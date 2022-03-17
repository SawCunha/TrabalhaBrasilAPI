package br.com.sawcunha.trabalhabrasilapi.configuration;

import br.com.sawcunha.trabalhabrasilapi.commons.exception.TrabalhaBrasilExeption;
import br.com.sawcunha.trabalhabrasilapi.model.TrabalhaBrasilError;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.io.InputStream;

public class TrabalhaBrasilErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        TrabalhaBrasilError trabalhaBrasilError;
        try (InputStream bodyIs = response.body()
                .asInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            trabalhaBrasilError = mapper.readValue(bodyIs, TrabalhaBrasilError.class);
        } catch (IOException e) {
            return new Exception(e.getMessage());
        }

        return new TrabalhaBrasilExeption(response.status(), trabalhaBrasilError.getMessage());
    }
}
