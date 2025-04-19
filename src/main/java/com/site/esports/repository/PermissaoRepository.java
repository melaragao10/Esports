package com.site.esports.repository;

import com.site.esports.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PermissaoRepository extends JpaRepository<Permissao, Integer> {
    List<Permissao> findByPerfilCodigo(Integer perfilId);
    void deleteByPerfilCodigo(Integer perfilId);
}
