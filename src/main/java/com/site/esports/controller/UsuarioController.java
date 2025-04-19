package com.site.esports.controller;

import com.site.esports.model.Perfil;
import com.site.esports.model.Usuario;
import com.site.esports.repository.PerfilRepository;
import com.site.esports.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/criar")
    public ResponseEntity<String> criarUsuario(@RequestBody Usuario usuario) {
        try {
            if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
                return ResponseEntity.badRequest().body("Erro: O campo email é obrigatório!");
            }
            if (usuario.getLogin() == null || usuario.getLogin().isEmpty()) {
                return ResponseEntity.badRequest().body("Erro: O campo login é obrigatório!");
            }
            if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
                return ResponseEntity.badRequest().body("Erro: O campo senha é obrigatório!");
            }

            if (usuarioRepository.findByLogin(usuario.getLogin()).isPresent()) {
                return ResponseEntity.badRequest().body("Erro: Login já está em uso.");
            }
            if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
                return ResponseEntity.badRequest().body("Erro: Email já está em uso.");
            }

            String perfilCorrigido = usuario.getPerfil().getNome();
            if ("Administrador".equals(perfilCorrigido)) {
                perfilCorrigido = "Admin";
            }

            Optional<Perfil> perfil = perfilRepository.findByNome(perfilCorrigido);
            if (perfil.isEmpty()) {
                return ResponseEntity.badRequest().body("Erro: Perfil não encontrado no banco!");
            }

            usuario.setPerfil(perfil.get());

            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));

            usuarioRepository.save(usuario);

            return ResponseEntity.ok("Usuário criado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao criar usuário: " + e.getMessage());
        }
    }
}
