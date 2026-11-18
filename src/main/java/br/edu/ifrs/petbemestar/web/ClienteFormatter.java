package br.edu.ifrs.petbemestar.web;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import br.edu.ifrs.petbemestar.dominio.Cliente;
import br.edu.ifrs.petbemestar.service.ClienteService;

@Component
public class ClienteFormatter implements Formatter<Cliente> {

    private final ClienteService clienteService;

    public ClienteFormatter(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Override
    public String print(Cliente cliente, Locale locale) {
        if (cliente == null || cliente.getId() == null) {
            return "";
        }
        return cliente.getId().toString();
    }

    @Override
    public Cliente parse(String id, Locale locale) throws ParseException {
        if (id == null || id.isBlank()) {
            return null;
        }
        return clienteService.buscarPorId(Long.valueOf(id));
    }
}
