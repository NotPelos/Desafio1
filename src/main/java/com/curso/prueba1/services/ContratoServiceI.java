package com.curso.prueba1.services;

import java.util.List;

import com.curso.prueba1.entities.Contrato;

public interface ContratoServiceI {
	
	public Long insertarContratoe(Contrato contrato);
	
	public List<Contrato> buscarContratos();
	
	public Contrato buscarContratoPorId(Long id);
	
	public void actualizarContrato(Contrato contrato);
	
	public void eliminarContrato(Contrato contrato);

}
