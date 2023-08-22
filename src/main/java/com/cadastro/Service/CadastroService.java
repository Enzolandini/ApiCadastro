package com.cadastro.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.Repository.UsuarioRepository;
import com.cadastro.Validacao.Validacoes;
import com.cadastro.model.Usuario;

@Service
public class CadastroService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public CadastroService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastrar(Usuario usuario) {
    	if (Validacoes.validarCpf(usuario.getCpf())) {
            throw new IllegalArgumentException("CPF inválido");
        }
        return usuarioRepository.save(usuario);
    }
}

