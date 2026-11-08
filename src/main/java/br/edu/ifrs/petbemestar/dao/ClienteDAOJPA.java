package br.edu.ifrs.petbemestar.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifrs.petbemestar.dominio.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class ClienteDAOJPA implements ClienteDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Cliente> listarTodos() {
        return em.createQuery("SELECT c FROM Cliente c", Cliente.class)
                .getResultList();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return em.find(Cliente.class, id);
    }

    @Override
    public void salvar(Cliente cliente) {
        em.persist(cliente);
    }

    @Override
    public void atualizar(Cliente cliente) {
        em.merge(cliente);
    }

    @Override
    public void remover(Long id) {
        Cliente cliente = em.find(Cliente.class, id);
        if (cliente != null) {
            em.remove(cliente);
        }
    }
}
