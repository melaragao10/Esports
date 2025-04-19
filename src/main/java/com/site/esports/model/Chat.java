package com.site.esports.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private Integer codigo;

    @ManyToOne
    @JoinColumn(name = "COD_USUARIO_ORIGEM", nullable = false)
    private Usuario usuarioOrigem;

    @ManyToOne
    @JoinColumn(name = "COD_USUARIO_DESTINO", nullable = false)
    private Usuario usuarioDestino;

    @Column(name = "DATA_HORA", nullable = false)
    private LocalDateTime dataHora;

    @Column(name = "MENSAGEM", columnDefinition = "TEXT", nullable = false)
    private String mensagem;

    @ManyToOne
    @JoinColumn(name = "COD_EQUIPE")
    private Equipe equipe;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Usuario getUsuarioOrigem() {
        return usuarioOrigem;
    }

    public void setUsuarioOrigem(Usuario usuarioOrigem) {
        this.usuarioOrigem = usuarioOrigem;
    }

    public Usuario getUsuarioDestino() {
        return usuarioDestino;
    }

    public void setUsuarioDestino(Usuario usuarioDestino) {
        this.usuarioDestino = usuarioDestino;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}
