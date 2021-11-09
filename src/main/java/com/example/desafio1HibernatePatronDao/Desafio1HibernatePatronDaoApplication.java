package com.example.desafio1HibernatePatronDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.desafio1HibernatePatronDao.entities.Cliente;
import com.example.desafio1HibernatePatronDao.services.ClienteServiceI;


@SpringBootApplication
public class Desafio1HibernatePatronDaoApplication implements CommandLineRunner{
	
	@Autowired
	private ClienteServiceI clienteService;

	public static void main(String[] args) {
		SpringApplication.run(Desafio1HibernatePatronDaoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		
		//Creando cliente
		
		Cliente c = new Cliente();
		c.setDni("11111111A");
		c.setNombre("Rafael");
		c.setPrimerApellido("Liebana");
		c.setSegundoApellido("Fuentes");
		
		System.out.println("***CREACIÓN***");
		System.out.println(c.getNombre() + " " + c.getPrimerApellido() + " " + c.getSegundoApellido()); //Mostramos el cliente creado
		System.out.println("================================");
		clienteService.save(c); //Guardamos el cliente en la bbdd
		
		Long clienteId = c.getId();
		Cliente c2 = clienteService.searchById(clienteId);
		
		System.out.println("***Búsqueda en BBDD POR ID***");
		System.out.println(c2.getNombre() + " " + c2.getPrimerApellido() + " " + c2.getSegundoApellido()); //Mostramos a traves de bbdd
		System.out.println("================================");
		//Insertando varios clientes
		
		Cliente c3 = new Cliente();
		c3.setDni("12111111A");
		c3.setNombre("Jorge");
		c3.setPrimerApellido("Lopez");
		c3.setSegundoApellido("Fuentes");
		
		Cliente c4 = new Cliente();
		c4.setDni("13111111A");
		c4.setNombre("Pedro");
		c4.setPrimerApellido("Suarez");
		c4.setSegundoApellido("Robles");
		
		clienteService.save(c3); //Guardamos el cliente en la bbdd
		clienteService.save(c4); //Guardamos el cliente en la bbdd
		
		
		//Búsqueda de todos los clientes
		
		List<Cliente> l = clienteService.findAll(); //Guardamos el cliente en la bbdd
		
		System.out.println("***Búsqueda GENERAL en BBDD***");
		for (Cliente a : l) {
			System.out.println(a.getNombre() + " " + a.getPrimerApellido() + " " + a.getSegundoApellido()); //Mostramos a traves de bbdd
		}
		System.out.println("================================");
		//Eliminando un cliente
		
		System.out.println("***ACTUALIZANDO CLIENTE en BBDD***");
		
		Cliente c5 = clienteService.searchById((long) 1);
		
		c5.setNombre("RafaelActualizado");
		
		clienteService.update(c5); //Actualizamos
		
		Cliente c6 = clienteService.searchById(c5.getId());
		System.out.println(c5.getNombre() + " " + c6.getPrimerApellido() + " " + c6.getSegundoApellido()); //Mostramos el cliente creado
		
		System.out.println("================================");
		//Búsqueda por Nombre
		
		System.out.println("***Búsqueda en BBDD POR NOMBRE (Pedro)***");
		Cliente c7 = clienteService.searchByNombre("Pedro");
		System.out.println(c7.getNombre() + " " + c7.getPrimerApellido() + " " + c7.getSegundoApellido()); //Mostramos a traves de bbdd
		System.out.println("================================");		
		//Búsqueda por Apellido
				
		System.out.println("***Búsqueda en BBDD POR NOMBRE (Lopez)***");
		Cliente c8 = clienteService.searchByApellido("Lopez");
		System.out.println(c8.getNombre() + " " + c8.getPrimerApellido() + " " + c8.getSegundoApellido()); //Mostramos a traves de bbdd
		System.out.println("================================");		
	
	}

}
