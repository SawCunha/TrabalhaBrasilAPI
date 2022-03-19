package br.com.sawcunha.trabalhabrasilapi.configuration;

import br.com.sawcunha.trabalhabrasilapi.commons.exception.TrabalhaBrasilExeption;
import br.com.sawcunha.trabalhabrasilapi.model.SalarioBRError;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class SalarioBRErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        SalarioBRError salarioBRError;
        try (InputStream bodyIs = response.body()
                .asInputStream()) {

            String text = new BufferedReader(
                    new InputStreamReader(bodyIs, StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"));

            System.out.println("AAAAAAAAAAAAA: " + text);

            ObjectMapper mapper = new ObjectMapper();
            salarioBRError = mapper.readValue(bodyIs, SalarioBRError.class);
        } catch (IOException e) {
            e.printStackTrace();
            return new Exception(e.getMessage());
        }

        StringBuilder messageBuilder = new StringBuilder();

        salarioBRError.getErros().forEach(messageBuilder::append);

        return new TrabalhaBrasilExeption(response.status(), messageBuilder.toString());
    }
}
