package com.site.esports.model;

import jakarta.persistence.*;

@Entity
@Table(name = "perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private Integer codigo;

    @Column(name = "NOME", length = 255, nullable = false, unique = true)
    private String nome;

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
}
