package com.site.esports.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_jogo") 
public class TipoJogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private Integer codigo;

    @Column(name = "DESCRICAO", length = 255, nullable = false)
    private String descricao;

    @Column(name = "SIGLA", length = 10, nullable = false)
    private String sigla;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
