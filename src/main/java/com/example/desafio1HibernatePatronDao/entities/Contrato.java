package com.example.desafio1HibernatePatronDao.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="CONTRATO", schema="hibernate")
public class Contrato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_UNIVERSIDAD", precision = 15)
	private Long id;
	
	@Column(name = "FECHA_VIGENCIA")
	@Temporal(TemporalType.DATE)
	private Date fechaVigencia;
	
	@Column(name = "FECHA_CADUCIDAD")
	@Temporal(TemporalType.DATE)
	private Date fechaCaducidad;
	
	@Column(name = "PRECIO", nullable = false, precision = 50)
	private Double precio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_CLIENTE", nullable = false)
	private Cliente clienteId;


}
