package br.edu.ifrs.petbemestar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifrs.petbemestar.dao.TutorDAO;
import br.edu.ifrs.petbemestar.dominio.Tutor;

@Service
public class TutorService {

    private final TutorDAO tutorDAO;

    public TutorService(TutorDAO tutorDAO) {
        this.tutorDAO = tutorDAO;
    }

    public List<Tutor> listarTodos() {
        return tutorDAO.listarTodos();
    }

    public Tutor buscarPorId(Long id) {
        return tutorDAO.buscarPorId(id);
    }

    public void salvar(Tutor tutor) {
        tutorDAO.salvar(tutor);
    }

    public void atualizar(Tutor tutor) {
        tutorDAO.atualizar(tutor);
    }

    public void remover(Long id) {
        tutorDAO.remover(id);
    }
}
