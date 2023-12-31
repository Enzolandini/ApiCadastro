package com.cadastro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.Service.CadastroService;
import com.cadastro.model.Usuario;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {
	
	@Autowired
	private CadastroService cadastroService;
	
	  @RequestMapping(value = "${api.rest.pessoas.getCurriculos}", method = RequestMethod.GET, produces = {
	      MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = cadastroService.cadastrar(usuario);
        return ResponseEntity.ok(novoUsuario);
    }
	
}
