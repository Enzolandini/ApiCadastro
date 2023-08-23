package com.cadastro.Service;

import org.springframework.stereotype.Service;

import com.cadastro.model.Usuario;

@Service
public interface CadastroService {

    public Usuario cadastrar(Usuario usuario);
    
}

