package com.site.esports.service;

import com.site.esports.model.Permissao;
import com.site.esports.model.Perfil;
import com.site.esports.model.Funcao;
import com.site.esports.repository.PermissaoRepository;
import com.site.esports.repository.FuncaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;

    @Autowired
    private FuncaoRepository funcaoRepository;

    public List<Permissao> listarPorPerfil(Integer codPerfil) {
        return permissaoRepository.findByPerfilCodigo(codPerfil);
    }

    public List<Funcao> listarTodasAsFuncoes() {
        return funcaoRepository.findAll();
    }

    @Transactional
    public void atualizarPermissoes(Integer codPerfil, List<Integer> codFuncoes) {
        permissaoRepository.deleteByPerfilCodigo(codPerfil);

        for (Integer codFuncao : codFuncoes) {
            Permissao permissao = new Permissao();

            Perfil perfil = new Perfil();
            perfil.setCodigo(codPerfil);
            permissao.setPerfil(perfil);

            Funcao funcao = new Funcao();
            funcao.setCodigo(codFuncao);
            permissao.setFuncao(funcao);

            permissaoRepository.save(permissao);
        }
    }
}
