package br.edu.ifrs.petbemestar.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.edu.ifrs.petbemestar.dao.UsuarioDAO;
import br.edu.ifrs.petbemestar.dominio.Usuario;

public class UsuarioService {
	private final UsuarioDAO dao;
	private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	public UsuarioService(UsuarioDAO dao) {
	    this.dao = dao;
	}
	public void cadastrar(Usuario usuario) {
	    if (dao.buscarPorNomeUsuario(usuario.getNomeUsuario()) != null) {
	        throw new RegraDeNegocioException("Este nome de usuário já está em uso.");
	    }
	    usuario.setSenha(encoder.encode(usuario.getSenha()));
	    dao.salvar(usuario);
	}
}
