package br.edu.ifrs.petbemestar.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.ifrs.petbemestar.dominio.Animal;
import br.edu.ifrs.petbemestar.dominio.Especie;
import br.edu.ifrs.petbemestar.dominio.Porte;
import br.edu.ifrs.petbemestar.service.AnimalService;
import br.edu.ifrs.petbemestar.service.ClienteService;
import jakarta.validation.Valid;

@Controller
public class AnimalController {

    private final AnimalService animalService;
    private final ClienteService clienteService;

    public AnimalController(AnimalService animalService, ClienteService clienteService) {
        this.animalService = animalService;
        this.clienteService = clienteService;
    }

    private void carregarOpcoesFormulario(Model model) {
        model.addAttribute("clientes", clienteService.listarTodos());
        model.addAttribute("especies", Especie.values());
        model.addAttribute("portes", Porte.values());
    }

    @GetMapping({"/animais", "/bichos"})
    public String listar(Model model) {
        model.addAttribute("animais", animalService.listarTodos());
        return "animais";
    }

    @GetMapping({"/animais/novo", "/bichos/novo"})
    public String novo(Model model) {
        model.addAttribute("animal", new Animal());
        carregarOpcoesFormulario(model);
        return "form-animal";
    }

    @GetMapping({"/animais/editar/{id}", "/bichos/editar/{id}"})
    public String editar(@PathVariable Long id, Model model) {
        Animal animal = animalService.buscarPorId(id);
        model.addAttribute("animal", animal);
        carregarOpcoesFormulario(model);
        return "form-animal";
    }

    @GetMapping({"/animais/editar", "/bichos/editar"})
    public String editarPorParametro(@RequestParam Long id, Model model) {
        Animal animal = animalService.buscarPorId(id);
        model.addAttribute("animal", animal);
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
            animalService.salvar(animal);
        } else {
            animalService.atualizar(animal);
        }
        return "redirect:/animais";
    }

    @PostMapping({"/animais/remover/{id}", "/bichos/remover/{id}"})
    public String remover(@PathVariable Long id) {
        animalService.remover(id);
        return "redirect:/animais";
    }

    @PostMapping({"/animais/remover", "/bichos/remover"})
    public String removerPorParametro(@RequestParam Long id) {
        animalService.remover(id);
        return "redirect:/animais";
    }
}
