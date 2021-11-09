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
import com.example.desafio1HibernatePatronDao.entities.Contrato;
import com.example.desafio1HibernatePatronDao.entities.ContratoDaoI;

@Service
public class ContratoServiceImpl implements ContratoServiceI{
	
	@Autowired
	private ContratoDaoI contratoDao;

	@Override
	@Transactional
	public void save(Contrato c) {
		contratoDao.save(c);	
	}
	
	@Override
	@Transactional
	public Contrato searchById(Long idContrato) {
		return contratoDao.searchById(idContrato);
	}

	@Override
	@Transactional
	public Contrato searchByClienteId(Long idCliente) {
		return contratoDao.searchById(idCliente);
	}
	

	@Override
	@Transactional
	public List<Contrato> findAll() {
		return contratoDao.findAll();
	}

	@Override
	@Transactional
	public void delete(Contrato c) {
		contratoDao.delete(c);		
	}

	@Override
	@Transactional
	public void update(Contrato c) {
		contratoDao.update(c);	
	}


}
