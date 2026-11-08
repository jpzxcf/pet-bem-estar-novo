package br.edu.ifrs.petbemestar.dao;

import java.util.List;

import br.edu.ifrs.petbemestar.dominio.Animal;

public interface AnimalDAO {
    List<Animal> listarTodos();
    Animal buscarPorId(Long id);
    void salvar(Animal animal);
    void atualizar(Animal animal);
    void remover(Long id);
}
