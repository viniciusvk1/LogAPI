package com.github.viniciusvk1.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.viniciusvk1.domain.model.Cliente;

@RestController
public class ClienteController {

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		Cliente cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Vinicius Almeida");
		cliente1.setEmail("vinicius@email.com");
		cliente1.setTelefone("11 99576-2272");

		Cliente cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Camile Righetti");
		cliente2.setEmail("camile@email.com");
		cliente2.setTelefone("11 99532-6422");

		return Arrays.asList(cliente1, cliente2);
	}

}
