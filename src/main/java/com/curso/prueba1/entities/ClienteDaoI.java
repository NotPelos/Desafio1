package com.curso.prueba1.entities;

import java.util.List;

public interface ClienteDaoI {
	
	public Long insertarCliente(Cliente cliente);
	
	public List<Cliente> searchAll();
	
	public Cliente searchById(Long id);
	
	public void actualizarCliente(Cliente cliente);

}
