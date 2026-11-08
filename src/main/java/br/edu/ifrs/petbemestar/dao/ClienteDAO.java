package br.edu.ifrs.petbemestar.dao;

import java.util.List;

import br.edu.ifrs.petbemestar.dominio.Cliente;

public interface ClienteDAO {
    List<Cliente> listarTodos();
    Cliente buscarPorId(Long id);
    void salvar(Cliente cliente);
    void atualizar(Cliente cliente);
    void remover(Long id);
}
