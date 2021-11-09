package com.example.desafio1HibernatePatronDao.services;

import java.util.List;

import com.example.desafio1HibernatePatronDao.entities.Cliente;
import com.example.desafio1HibernatePatronDao.entities.Contrato;

public interface ContratoServiceI {
	
	public void save(Contrato c); //Añadir
	
	public Contrato searchById(Long idContrato); //Consulta por Id
	
	public Contrato searchByClienteId(Long idCliente); //Consulta por Nombre
	
	public List<Contrato> findAll();  //Consulta todos
	
	public void delete(Contrato c);  //Consulta todos
	
	public void update(Contrato c);  //Consulta todos
	
	


}
