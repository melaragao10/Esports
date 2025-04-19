package com.site.esports.model;

import jakarta.persistence.*;

@Entity
public class Dicas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private Integer codigo;

    @Column(name = "DESCRICAO", length = 255, nullable = false)
    private String descricao;

    @Column(name = "PONTUACAO", nullable = false)
    private Integer pontuacao;

    @ManyToOne
    @JoinColumn(name = "COD_JOGO", nullable = false)
    private Jogos jogo;

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

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Jogos getJogo() {
        return jogo;
    }

    public void setJogo(Jogos jogo) {
        this.jogo = jogo;
    }
}
