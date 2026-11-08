package br.edu.ifrs.petbemestar.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifrs.petbemestar.dao.AnimalDAO;
import br.edu.ifrs.petbemestar.dao.ClienteDAO;
import br.edu.ifrs.petbemestar.dominio.Animal;
import br.edu.ifrs.petbemestar.dominio.Especie;
import br.edu.ifrs.petbemestar.dominio.Porte;
import jakarta.validation.Valid;

@Controller
public class AnimalController {

    private final AnimalDAO animalDAO;
    private final ClienteDAO clienteDAO;

    public AnimalController(AnimalDAO animalDAO, ClienteDAO clienteDAO) {
        this.animalDAO = animalDAO;
        this.clienteDAO = clienteDAO;
    }

    private void carregarOpcoesFormulario(Model model) {
        model.addAttribute("clientes", clienteDAO.listarTodos());
        model.addAttribute("especies", Especie.values());
        model.addAttribute("portes", Porte.values());
    }

    @GetMapping({"/animais/novo", "/bichos/novo"})
    public String novo(Model model) {
        model.addAttribute("animal", new Animal());
        carregarOpcoesFormulario(model);
        return "form-animal";
    }

    @PostMapping({"/animais", "/animais/salvar", "/bichos", "/bichos/salvar"})
    public String salvar(@Valid @ModelAttribute("animal") Animal animal, BindingResult result, Model model) {
        if (result.hasErrors()) {
            carregarOpcoesFormulario(model);
            return "form-animal";
        }
        if (animal.getId() == null) {
            animalDAO.salvar(animal);
        } else {
            animalDAO.atualizar(animal);
        }
        return "redirect:/animais";
    }
}
