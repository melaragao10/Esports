package com.site.esports.model;

import jakarta.persistence.*;

@Entity
public class Funcao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private Integer codigo;

    @Column(name = "DESCRICAO")
    private String descricao;

    public Integer getCodigo() { return codigo; }
    public void setCodigo(Integer codigo) { this.codigo = codigo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
