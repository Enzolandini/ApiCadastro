package com.cadastro.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cadastro.Repository.UsuarioRepository;
import com.cadastro.Service.CadastroService;
import com.cadastro.Validacao.Validacoes;
import com.cadastro.model.Usuario;

public class CadastroServiceImpl implements CadastroService {

	private final UsuarioRepository usuarioRepository;

	@Autowired
	public CadastroServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public Usuario cadastrar(Usuario usuario) {
		if (!Validacoes.validarCpf(usuario.getCpf())) {
			throw new IllegalArgumentException("CPF inválido");
		}

		if (!Validacoes.validarCelular(usuario.getCelular())) {
			throw new IllegalArgumentException("Celular invalido");
		}

		if (!Validacoes.validarEmail(usuario.getEmail())) {
			throw new IllegalArgumentException("Email invalido");
		}
		return usuarioRepository.save(usuario);
	}

}
