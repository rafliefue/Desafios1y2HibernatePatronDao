package com.example.desafio1HibernatePatronDao.entities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContratoDaoImpl implements ContratoDaoI{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public void save(Contrato c) {
		
		Session s = entityManager.unwrap(Session.class);	
		s.save(c);
		s.close();
		
	}

	@Override
	public Contrato searchById(Long idContrato) {
		
		Session s = entityManager.unwrap(Session.class);	
		Contrato c = (Contrato) s.createQuery("FROM Contrato WHERE id =" + idContrato).uniqueResult();		
		s.close();
		
		return c;
	}
	
	@Override
	public Contrato searchByClienteId(Long idCliente) {
		Session s = entityManager.unwrap(Session.class);	
		Contrato c = (Contrato) s.createQuery("FROM Contrato WHERE cliente.id =" + idCliente).uniqueResult();		
		s.close();
		return c;
	}
	

	@Override
	public List<Contrato> findAll() {
		Session s = entityManager.unwrap(Session.class);	
		List<Contrato> l = (List<Contrato>) s.createQuery("FROM Contrato").getResultList();		
		s.close();
		
		return l;
		
	}

	@Override
	public void delete(Contrato c) {
		Session s = entityManager.unwrap(Session.class);	
		entityManager.remove(entityManager.merge(c));
		s.close();
		
	}

	@Override
	public void update(Contrato c) {
		Session s = entityManager.unwrap(Session.class);	
		s.update(c);
		s.close();
		
	}

	

	

}
