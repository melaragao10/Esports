package com.site.esports.model;

import jakarta.persistence.*;

@Entity
public class JogoEquipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private Integer codigo;

    @ManyToOne
    @JoinColumn(name = "COD_JOGO", nullable = false)
    private Jogos jogo;

    @ManyToOne
    @JoinColumn(name = "COD_EQUIPE", nullable = false)
    private Equipe equipe;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Jogos getJogo() {
        return jogo;
    }

    public void setJogo(Jogos jogo) {
        this.jogo = jogo;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}
