package com.curso.prueba1.services;

import java.util.List;

import com.curso.prueba1.entities.Cliente;

public interface ClienteServiceI {
	
	public Long insertarCliente(Cliente cliente);
	
	public List<Cliente> buscarClientes();
	
	public Cliente buscarClientePorId(Long id);
	
	public void actualizarCliente(Cliente cliente);

}
