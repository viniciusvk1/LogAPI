package com.github.viniciusvk1.LogAPI.api.controller;

import com.github.viniciusvk1.LogAPI.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> listar() {
        Cliente cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Vinicius");
        cliente1.setTelefone("11 99576-2272");
        cliente1.setEmail("vinicius@email.com");

        Cliente cliente2 = new Cliente();
        cliente2.setId(1L);
        cliente2.setNome("Camile");
        cliente2.setTelefone("11 99531-2398");
        cliente2.setEmail("camile@email.com");

        return Arrays.asList(cliente1, cliente2);
    }
}