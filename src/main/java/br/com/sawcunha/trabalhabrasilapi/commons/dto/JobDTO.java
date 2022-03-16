package br.com.sawcunha.trabalhabrasilapi.commons.dto;

import lombok.Data;

import java.util.Set;

@Data
public class JobDTO {

    private Long id;
    private String descricao;
    private String df;
    private String empresa;
    private String url;
    private String cidade;
    private String uf;
    private String css;
    private String qv;
    private Set<String> pcd;
    private String titulo;
    private String pagina;
    private String st;
    private String salario;
    private String cn;
    private Boolean homeOfficce;
    private Boolean ca;

}
