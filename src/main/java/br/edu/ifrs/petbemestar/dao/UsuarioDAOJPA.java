package br.edu.ifrs.petbemestar.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifrs.petbemestar.dominio.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class UsuarioDAOJPA implements UsuarioDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public Usuario buscarPorNomeUsuario(String nomeUsuario) {
        List<Usuario> usuarios = em
                .createQuery("SELECT u FROM Usuario u WHERE u.nomeUsuario = :nomeUsuario", Usuario.class)
                .setParameter("nomeUsuario", nomeUsuario)
                .getResultList();
        return usuarios.isEmpty() ? null : usuarios.get(0);
    }
}
