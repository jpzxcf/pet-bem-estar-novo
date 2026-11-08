package br.edu.ifrs.petbemestar.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrs.petbemestar.dao.TutorDAO;
import br.edu.ifrs.petbemestar.dominio.Tutor;

@RestController
@RequestMapping("/tutores")
public class TutorController {

    private final TutorDAO tutorDAO;

    public TutorController(TutorDAO tutorDAO) {
        this.tutorDAO = tutorDAO;
    }

    @GetMapping
    public List<Tutor> listarTodos() {
        return tutorDAO.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutor> buscarPorId(@PathVariable Long id) {
        Tutor tutor = tutorDAO.buscarPorId(id);
        if (tutor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tutor);
    }

    @PostMapping
    public ResponseEntity<Tutor> salvar(@RequestBody Tutor tutor) {
        tutorDAO.salvar(tutor);
        return ResponseEntity.status(HttpStatus.CREATED).body(tutor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tutor> atualizar(@PathVariable Long id, @RequestBody Tutor tutor) {
        Tutor existente = tutorDAO.buscarPorId(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        tutor.setId(id);
        tutorDAO.atualizar(tutor);
        return ResponseEntity.ok(tutor);
    }
}
