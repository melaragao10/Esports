package com.site.esports.model;

import jakarta.persistence.*;

@Entity
public class Permissao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private Integer codigo;

    @ManyToOne
    @JoinColumn(name = "COD_PERFIL", nullable = false)
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "COD_FUNCAO", nullable = false)
    private Funcao funcao;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }
}
