package br.edu.ifrs.petbemestar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifrs.petbemestar.dao.ClienteDAO;
import br.edu.ifrs.petbemestar.dominio.Cliente;

@Service
public class ClienteService {

    private final ClienteDAO clienteDAO;

    public ClienteService(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public List<Cliente> listarTodos() {
        return clienteDAO.listarTodos();
    }

    public Cliente buscarPorId(Long id) {
        return clienteDAO.buscarPorId(id);
    }

    public void salvar(Cliente cliente) {
        clienteDAO.salvar(cliente);
    }

    public void atualizar(Cliente cliente) {
        clienteDAO.atualizar(cliente);
    }

    public void remover(Long id) {
        clienteDAO.remover(id);
    }
}
