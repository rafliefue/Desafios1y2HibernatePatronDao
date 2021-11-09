package com.example.desafio1HibernatePatronDao.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="ALUMNO", schema="hibernate")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ALUMNO", precision = 15)
	private Long id;
	
	@JoinColumn(name = "NOMBRE", nullable = false)
	private String nombre;
	
	@Column(name = "PRIMER_APELLIDO", nullable = false, precision = 50)
	private String primerApellido;
	
	@Column(name = "SEGUNDO_APELLIDO", nullable = false, precision = 50)
	private String segundoApellido;
	
	@Column(name = "DNI", nullable = false, precision = 9, unique = true)
	private String dni;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY , mappedBy = "clienteId")
	private List<Contrato> listaContratos;

}
