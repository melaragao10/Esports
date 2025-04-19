package com.site.esports.model;

import jakarta.persistence.*;

@Entity
public class ChatArquivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private Integer codigo;

    @ManyToOne
    @JoinColumn(name = "COD_CHAT", nullable = false)
    private Chat chat;

    @ManyToOne
    @JoinColumn(name = "COD_ARQUIVO", nullable = false)
    private Arquivo arquivo;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public Arquivo getArquivo() {
        return arquivo;
    }

    public void setArquivo(Arquivo arquivo) {
        this.arquivo = arquivo;
    }
}
