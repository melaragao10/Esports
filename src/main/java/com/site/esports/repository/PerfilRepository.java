package com.site.esports.repository;

import com.site.esports.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PerfilRepository extends JpaRepository<Perfil, Integer> {
    Optional<Perfil> findByNome(String nome);
}
