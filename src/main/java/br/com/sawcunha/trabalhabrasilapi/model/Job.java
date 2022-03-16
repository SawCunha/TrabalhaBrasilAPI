package br.com.sawcunha.trabalhabrasilapi.model;

import lombok.Data;
import lombok.ToString;

import java.util.Set;

@Data
@ToString
public class Job {

    private Long id;
    private String d;
    private String df;
    private String ne;
    private String u;
    private String dc;
    private String uf;
    private String css;
    private String qv;
    private Set<String> pcd;
    private String tt;
    private String pg;
    private String st;
    private String sl;
    private String cn;
    private Boolean ho;
    private Boolean ca;

}
