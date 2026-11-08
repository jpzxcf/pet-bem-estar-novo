package br.edu.ifrs.petbemestar.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.ifrs.petbemestar.dao.ClienteDAO;
import br.edu.ifrs.petbemestar.dominio.Cliente;
import jakarta.validation.Valid;

@Controller
public class ClienteController {

    private final ClienteDAO clienteDAO;

    public ClienteController(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    @GetMapping("/clientes")
    public String listar(Model model) {
        model.addAttribute("clientes", clienteDAO.listarTodos());
        return "clientes";
    }

    @GetMapping("/clientes/novo")
    public String novo(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "form-cliente";
    }

    @GetMapping("/clientes/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Cliente cliente = clienteDAO.buscarPorId(id);
        model.addAttribute("cliente", cliente);
        return "form-cliente";
    }

    @GetMapping("/clientes/editar")
    public String editarPorParametro(@RequestParam Long id, Model model) {
        Cliente cliente = clienteDAO.buscarPorId(id);
        model.addAttribute("cliente", cliente);
        return "form-cliente";
    }

    @PostMapping({"/clientes", "/clientes/salvar"})
    public String salvar(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult result) {
        if (result.hasErrors()) {
            return "form-cliente";
        }
        if (cliente.getId() == null) {
            clienteDAO.salvar(cliente);
        } else {
            clienteDAO.atualizar(cliente);
        }
        return "redirect:/clientes";
    }

    @PostMapping("/clientes/remover/{id}")
    public String remover(@PathVariable Long id) {
        clienteDAO.remover(id);
        return "redirect:/clientes";
    }

    @PostMapping("/clientes/remover")
    public String removerPorParametro(@RequestParam Long id) {
        clienteDAO.remover(id);
        return "redirect:/clientes";
    }
}
