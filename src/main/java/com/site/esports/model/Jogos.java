package com.site.esports.model;

import jakarta.persistence.*;

@Entity
public class Jogos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private Integer codigo;

    @Column(name = "NOME", length = 255, nullable = false)
    private String nome;

    @Column(name = "DESCRICAO", length = 255, nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "TIPO", nullable = false)
    private TipoJogo tipoJogo;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoJogo getTipoJogo() {
        return tipoJogo;
    }

    public void setTipoJogo(TipoJogo tipoJogo) {
        this.tipoJogo = tipoJogo;
    }
}
