package br.com.sawcunha.trabalhabrasilapi.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class JobParam {

    private String idFuncao;
    private String idCidade;
    private String pagina;
    private String pesquisa;
    private String ordenacao;
    private String idUsuario;
    private Boolean flgHomeOffice;
}
