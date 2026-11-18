package br.edu.ifrs.petbemestar.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrs.petbemestar.dominio.Tutor;
import br.edu.ifrs.petbemestar.service.TutorService;

@RestController
@RequestMapping("/tutores")
public class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping
    public List<Tutor> listarTodos() {
        return tutorService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutor> buscarPorId(@PathVariable Long id) {
        Tutor tutor = tutorService.buscarPorId(id);
        if (tutor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tutor);
    }

    @PostMapping
    public ResponseEntity<Tutor> salvar(@RequestBody Tutor tutor) {
        tutorService.salvar(tutor);
        return ResponseEntity.status(HttpStatus.CREATED).body(tutor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tutor> atualizar(@PathVariable Long id, @RequestBody Tutor tutor) {
        Tutor existente = tutorService.buscarPorId(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        tutor.setId(id);
        tutorService.atualizar(tutor);
        return ResponseEntity.ok(tutor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        Tutor existente = tutorService.buscarPorId(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        tutorService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
