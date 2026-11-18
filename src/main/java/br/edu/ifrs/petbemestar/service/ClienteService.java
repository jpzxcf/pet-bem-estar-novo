package br.edu.ifrs.petbemestar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifrs.petbemestar.dao.AnimalDAO;
import br.edu.ifrs.petbemestar.dao.ClienteDAO;
import br.edu.ifrs.petbemestar.dominio.Animal;
import br.edu.ifrs.petbemestar.dominio.Cliente;

@Service
public class ClienteService {

    private final ClienteDAO clienteDAO;
    private final AnimalDAO animalDAO;

    public ClienteService(ClienteDAO clienteDAO, AnimalDAO animalDAO) {
        this.clienteDAO = clienteDAO;
        this.animalDAO = animalDAO;
    }

    public List<Cliente> listarTodos() {
        return clienteDAO.listarTodos();
    }

    public Cliente buscarPorId(Long id) {
        return clienteDAO.buscarPorId(id);
    }

    	
    public List<Animal> listarAnimais(Long clienteId) {
        return animalDAO.listarPorCliente(clienteId);
    }
    
    public void salvar(Cliente cliente) {
    	validarTelefoneDuplicado(cliente);
        clienteDAO.salvar(cliente);
    }

    public void atualizar(Cliente cliente) {
    	validarTelefoneDuplicado(cliente);
        clienteDAO.atualizar(cliente);
    }

    private void validarTelefoneDuplicado(Cliente cliente) {
        Cliente existente = clienteDAO.buscarPorTelefone(cliente.getTelefone());
        if (existente != null && !existente.getId().equals(cliente.getId())) {
            throw new RegraDeNegocioException("Já existe outro cliente cadastrado com esse telefone.");
        }
    }
    
    public void remover(Long id) {
        Cliente cliente = clienteDAO.buscarPorId(id);
        if (cliente != null && !animalDAO.listarPorCliente(id).isEmpty()) {
            throw new RegraDeNegocioException(cliente.getNome() + " ainda tem bichos cadastrados e não pode ser removido.");
        }
        clienteDAO.remover(id);
    }
}
