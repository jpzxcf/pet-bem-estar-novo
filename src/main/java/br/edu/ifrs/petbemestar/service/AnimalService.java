package br.edu.ifrs.petbemestar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifrs.petbemestar.dao.AnimalDAO;
import br.edu.ifrs.petbemestar.dominio.Animal;

@Service
public class AnimalService {
    
	private final AnimalDAO animalDAO;
	
	public AnimalService(AnimalDAO animalDao) {
		this.animalDAO = animalDao;
	}
	
	public List<Animal> listarTodos() {
		return animalDAO.listarTodos();
	}
	
	public Animal buscarPorId(Long id) {
		return animalDAO.buscarPorId(id);
	}
	
	public void salvar(Animal animal) {
		animalDAO.salvar(animal);
	}
	
	public void atualizar(Animal animal) { 
		animalDAO.atualizar(animal);
	}
	
	public void remover(Long id) {
		animalDAO.remover(id);
	}
	
}
