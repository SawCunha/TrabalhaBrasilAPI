package br.com.sawcunha.trabalhabrasilapi.configuration;

import br.com.sawcunha.trabalhabrasilapi.commons.exception.TrabalhaBrasilExeption;
import br.com.sawcunha.trabalhabrasilapi.model.SalarioBRError;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.io.InputStream;

public class SalarioBRErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        SalarioBRError salarioBRError;
        try (InputStream bodyIs = response.body()
                .asInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            salarioBRError = mapper.readValue(bodyIs, SalarioBRError.class);
        } catch (IOException e) {
            return new Exception(e.getMessage());
        }

        StringBuilder messageBuilder = new StringBuilder();

        salarioBRError.getErros().forEach(messageBuilder::append);

        return new TrabalhaBrasilExeption(response.status(), messageBuilder.toString());
    }
}
