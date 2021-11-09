package com.curso.prueba1;

import java.util.List;
import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.curso.prueba1.services.ContratoServiceImpl;
import com.curso.prueba1.entities.Contrato;

import com.curso.prueba1.entities.Cliente;
import com.curso.prueba1.services.ClienteServiceImpl;

@SpringBootApplication
public class Prueba1Application implements CommandLineRunner {
	
	@Autowired
	public ClienteServiceImpl clienteService;
	
	@Autowired
	public ContratoServiceImpl contratoService;


	public static void main(String[] args) {
		SpringApplication.run(Prueba1Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		Cliente c1 = new Cliente("Ismael","Sanchez","Aguilera","85321548A");
		Cliente c2 = new Cliente("Francisco","Torres","Garcia","12345678A");
		Cliente c3 = new Cliente("Lucia","Ruiz","Torres","87654321C");
		
		Contrato contrato1 = new Contrato(Date.valueOf("2019/01/25"),Date.valueOf("2019/01/25"),25.0);
		Contrato contrato2 = new Contrato(Date.valueOf("2019-05-1"),Date.valueOf("2019-05-1"),70.0);
		c1.setContratos(new ArrayList<Contrato>());
		c1.addContrato(contrato1);
		c1.addContrato(contrato2);
		
		Long c1ID = clienteService.insertarCliente(c1);
		Long c2ID = clienteService.insertarCliente(c2);
		Long c3ID = clienteService.insertarCliente(c3);
		
		System.out.println("Clientes:");
		List<Cliente> listado = clienteService.buscarClientes();
		for (Cliente cliente : listado) {
			System.out.println(cliente);
		}
		
		
		System.out.println("\nBuscar cliente:");
		for (Cliente cliente : listado) {
			Cliente buscado = clienteService.buscarClientePorId(cliente.getId());
			System.out.println(buscado);
		}
		
		String nNombre = "Alberto";
		c1 = clienteService.buscarClientePorId(c1ID);
		c1.setNombre(nNombre);
		System.out.println(c1);
		clienteService.actualizarCliente(c1);
		System.out.println("Cliente modificado:"+clienteService.buscarClientePorId(c1ID));				
	}

}
