package com.site.esports.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comentarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private Integer codigo;

    @ManyToOne
    @JoinColumn(name = "COD_JOGO")
    private Jogos jogo;

    @ManyToOne
    @JoinColumn(name = "COD_EVENTO")
    private Eventos evento;

    @ManyToOne
    @JoinColumn(name = "COD_USUARIO", nullable = false)
    private Usuario usuario;

    @Column(name = "DATA_HORA")
    private LocalDateTime dataHora;

    @Column(name = "TEXTO", columnDefinition = "TEXT", nullable = false)
    private String texto;

    @Column(name = "ANONIMO")
    private Boolean anonimo;

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

    public Eventos getEvento() {
        return evento;
    }

    public void setEvento(Eventos evento) {
        this.evento = evento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Boolean getAnonimo() {
        return anonimo;
    }

    public void setAnonimo(Boolean anonimo) {
        this.anonimo = anonimo;
    }
}
