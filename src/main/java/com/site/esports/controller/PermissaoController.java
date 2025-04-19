package com.site.esports.controller;

import com.site.esports.model.Permissao;
import com.site.esports.model.Funcao;
import com.site.esports.service.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class PermissaoController {

    private final PermissaoService permissaoService;

    @Autowired
    public PermissaoController(PermissaoService permissaoService) {
        this.permissaoService = permissaoService;
    }

    @GetMapping("/permissoes")
    public List<Permissao> listarPermissoes(@RequestParam Integer codPerfil) {
        return permissaoService.listarPorPerfil(codPerfil);
    }

    @GetMapping("/funcoes")
    public List<Funcao> listarFuncoes() {
        return permissaoService.listarTodasAsFuncoes();
    }

    @PostMapping("/atualizar-permissoes")
    public ResponseEntity<String> atualizarPermissoes(@RequestParam Integer codPerfil, @RequestBody List<Integer> codFuncoes) {
        permissaoService.atualizarPermissoes(codPerfil, codFuncoes);
        return ResponseEntity.ok("Permissões atualizadas com sucesso!");
    }
}
