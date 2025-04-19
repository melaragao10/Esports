package com.site.esports.repository;

import com.site.esports.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByLogin(String login);
    Optional<Usuario> findByEmail(String email);
}
