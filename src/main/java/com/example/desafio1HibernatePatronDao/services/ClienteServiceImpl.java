package com.example.desafio1HibernatePatronDao.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.desafio1HibernatePatronDao.entities.Cliente;
import com.example.desafio1HibernatePatronDao.entities.ClienteDaoI;

@Service
public class ClienteServiceImpl implements ClienteServiceI{
	
	@Autowired
	private ClienteDaoI clienteDao;

	@Override
	public void save(Cliente c) {
		clienteDao.save(c);	
	}

	@Override
	public Cliente searchById(Long idCliente) {
		return clienteDao.searchById(idCliente);
	}

	@Override
	public List<Cliente> findAll() {
		return clienteDao.findAll();
	}

	@Override
	public void delete(Cliente c) {
		clienteDao.delete(c);		
	}

	@Override
	@Transactional
	public void update(Cliente c) {
		clienteDao.update(c);	
	}

	@Override
	public Cliente searchByNombre(String nombre) {
		return clienteDao.searchByNombre(nombre);
	}

	@Override
	public Cliente searchByApellido(String apellido) {
		return clienteDao.searchByApellido(apellido);
	}


}
