package com.site.esports.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario") 
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private Integer codigo;

    @Column(name = "LOGIN", length = 100, nullable = false, unique = true)
    private String login;

    @Column(name = "EMAIL", length = 255, nullable = false, unique = true)
    private String email;

    @Column(name = "SENHA", length = 255, nullable = false)
    private String senha;

    @ManyToOne
    @JoinColumn(name = "COD_PERFIL", nullable = false)
    private Perfil perfil;

    public Integer getCodigo() { return codigo; }
    public void setCodigo(Integer codigo) { this.codigo = codigo; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public Perfil getPerfil() { return perfil; }
    public void setPerfil(Perfil perfil) { this.perfil = perfil; }
}
