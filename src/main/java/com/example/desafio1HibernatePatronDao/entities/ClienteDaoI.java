package com.example.desafio1HibernatePatronDao.entities;

import java.util.List;

public interface ClienteDaoI {
	
	public void save(Cliente c); //Añadir
	
	public Cliente searchById(Long idCliente); //Consulta por Id
	
	public Cliente searchByNombre(String nombre); //Consulta por Nombre
	
	public Cliente searchByApellido(String apellido); //Consulta por Apellido
	
	public List<Cliente> findAll();  //Consulta todos
	
	public void delete(Cliente c);  //Consulta todos
	
	public void update(Cliente c);  //Consulta todos
	
	


}
