package br.edu.ifrs.petbemestar.dao;

import java.util.List;

import br.edu.ifrs.petbemestar.dominio.Tutor;

public interface TutorDAO {
    List<Tutor> listarTodos();
    Tutor buscarPorId(Long id);
    void salvar(Tutor tutor);
    void atualizar(Tutor tutor);
    void remover(Long id);
}
