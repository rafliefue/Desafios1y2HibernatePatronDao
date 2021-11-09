package com.example.desafio1HibernatePatronDao.entities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDaoImpl implements ClienteDaoI{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public void save(Cliente c) {
		
		Session s = entityManager.unwrap(Session.class);	
		s.save(c);
		s.close();
		
	}

	@Override
	public Cliente searchById(Long idCliente) {
		
		Session s = entityManager.unwrap(Session.class);	
		Cliente c = (Cliente) s.createQuery("FROM Cliente WHERE id =" + idCliente).uniqueResult();		
		s.close();
		
		return c;
	}
	

	@Override
	public List<Cliente> findAll() {
		Session s = entityManager.unwrap(Session.class);	
		List<Cliente> l = (List<Cliente>) s.createQuery("FROM Cliente").getResultList();		
		s.close();
		
		return l;
		
	}

	@Override
	public void delete(Cliente c) {
		Session s = entityManager.unwrap(Session.class);	
		s.delete(c);
		s.close();
		
	}

	@Override
	public void update(Cliente c) {
		Session s = entityManager.unwrap(Session.class);	
		s.update(c);
		s.close();
		
	}

	@Override
	public Cliente searchByNombre(String nombre1) {
		
		Session s = entityManager.unwrap(Session.class);	
		Cliente c = (Cliente) s.createQuery("FROM Cliente WHERE nombre = " + nombre1).uniqueResult();		

		s.close();
		return c;
	}

	@Override
	public Cliente searchByApellido(String apellido) {
		Session s = entityManager.unwrap(Session.class);	
		Cliente c = (Cliente) s.createQuery("FROM Cliente WHERE primerApellido or segundoApellido = " + apellido).uniqueResult();		
		s.close();
		
		return c;
	}

}
