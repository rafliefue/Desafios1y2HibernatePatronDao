package com.example.desafio1HibernatePatronDao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.desafio1HibernatePatronDao.entities.Cliente;
import com.example.desafio1HibernatePatronDao.entities.Contrato;
import com.example.desafio1HibernatePatronDao.services.ClienteServiceI;
import com.example.desafio1HibernatePatronDao.services.ContratoServiceI;


@SpringBootApplication
public class Desafio1HibernatePatronDaoApplication implements CommandLineRunner{
	
	@Autowired
	private ClienteServiceI clienteService;
	
	@Autowired
	private ContratoServiceI contratoService;

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
		
		System.out.println("***Búsqueda en BBDD POR ID (1)***");
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
		
		//Búsqueda por Nombre
		
		System.out.println("***Búsqueda en BBDD POR NOMBRE (Pedro)***");
		Cliente c7 = clienteService.searchByNombre("Pedro");
		System.out.println(c7.getNombre() + " " + c7.getPrimerApellido() + " " + c7.getSegundoApellido()); //Mostramos a traves de bbdd
		System.out.println("================================");		
		//Búsqueda por Apellido
				
		System.out.println("***Búsqueda en BBDD POR APELLIDO (Lopez)***");
		Cliente c8 = clienteService.searchByApellido("Lopez");
		System.out.println(c8.getNombre() + " " + c8.getPrimerApellido() + " " + c8.getSegundoApellido()); //Mostramos a traves de bbdd
		System.out.println("================================");		
	
	
		
		
		//Búsqueda de todos los clientes
		
		List<Cliente> l = clienteService.findAll(); //Guardamos el cliente en la bbdd
		
		System.out.println("***Búsqueda GENERAL en BBDD***");
		for (Cliente a : l) {
			System.out.println(a.getNombre() + " " + a.getPrimerApellido() + " " + a.getSegundoApellido()); //Mostramos a traves de bbdd
		}
		System.out.println("================================");
		
		//Actualizando un cliente
		
		System.out.println("***ACTUALIZANDO CLIENTE en BBDD***");
		
		Cliente c5 = clienteService.searchById((long) 1);
		
		c5.setNombre("RafaelActualizado");
		
		clienteService.update(c5); //Actualizamos
		
		Cliente c6 = clienteService.searchById(c5.getId());
		System.out.println(c5.getNombre() + " " + c6.getPrimerApellido() + " " + c6.getSegundoApellido()); //Mostramos el cliente creado
		System.out.println("================================");
		
		//Eliminando un cliente
		
		Cliente c9 = clienteService.searchById((long) 3);
						
		clienteService.delete(c9); //Actualizamos
				
		//Búsqueda de todos los clientes
		
		List<Cliente> l2 = clienteService.findAll(); //Guardamos el cliente en la bbdd
				
		System.out.println("***Búsqueda GENERAL en BBDD DESPUES DE BORRAR***");
			
		for (Cliente a : l2) {
				System.out.println(a.getNombre() + " " + a.getPrimerApellido() + " " + a.getSegundoApellido()); //Mostramos a traves de bbdd
		}
			
		System.out.println("================================");
		System.out.println("================================");
	
		
		//Creando contrato
		
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.MONTH, 01);
        ca.set(Calendar.DATE, 01);
        ca.set(Calendar.YEAR, 2021);
        Date fecha1 = ca.getTime();
        
        Calendar ca2 = Calendar.getInstance();
        ca2.set(Calendar.MONTH, 01);
        ca2.set(Calendar.DATE, 01);
        ca2.set(Calendar.YEAR, 2022);
        Date fecha2 = ca2.getTime();
 
		Contrato co = new Contrato();
		co.setId((long) 1);
		co.setClienteId(clienteService.searchById((long) 1));
		co.setFechaVigencia(fecha1);
		co.setFechaCaducidad(fecha2);
		co.setPrecio(3000.0);
		
		
		System.out.println("***CREACIÓN***");
		System.out.println("Contrato de id: " + co.getId() + " y precio: " + co.getPrecio() + " €" ); //Mostramos el cliente creado
		System.out.println("================================");
		contratoService.save(co); //Guardamos el contrato en la bbdd
		
		//Busqueda por Id
		
		Contrato co2 = contratoService.searchById(co.getId());
		
		System.out.println("***Búsqueda en BBDD POR ID (1)***");
		System.out.println("Contrato de id: " + co2.getId() + " y precio: " + co2.getPrecio() + " €"); //Mostramos el cliente creado
		System.out.println("================================");
		
		//Creamos otro contrato
		
		Contrato co3 = new Contrato();
		co3.setClienteId(clienteService.searchById((long) 2));
		co3.setFechaVigencia(fecha1);
		co3.setFechaCaducidad(fecha2);
		co3.setPrecio(5000.0);
		contratoService.save(co3);
		
		//Búsqueda de todos los contratos
		
		List<Contrato> l3 = contratoService.findAll(); //Guardamos el cliente en la bbdd
				
		System.out.println("***Búsqueda GENERAL en BBDD***");
		for (Contrato a : l3) {
			System.out.println("Contrato de id: " + a.getId() + " y precio: " + a.getPrecio() + " €"); //Mostramos el cliente creado
		}
		System.out.println("================================");
		
		//Busqueda por Id de cliente
		
		Contrato co4 = contratoService.searchByClienteId((long) 2);	
		System.out.println("***Búsqueda en BBDD POR ID de CLIENTE (2)***");
		System.out.println("Contrato de id: " + co4.getId() + " y precio: " + co4.getPrecio() + " €"); //Mostramos el cliente creado
		System.out.println("================================");
		
		//Actualizando Contrato
		
		System.out.println("***ACTUALIZANDO CONTRATO en BBDD***");
		
		Contrato co5 = contratoService.searchByClienteId((long) 2);	
		
		co5.setPrecio(100.0);
		
		contratoService.update(co5); //Actualizamos
		
		Contrato co6 = contratoService.searchById(co5.getId());
		System.out.println("Contrato de id: " + co5.getId() + " y precio: " + co5.getPrecio() + " €"); //Mostramos el cliente creado
		System.out.println("================================");
		
		//Eliminando Contrato
		
		Contrato co7 = contratoService.searchByClienteId((long) 2);	
		
		contratoService.delete(co7); //Borramos
		
		List<Contrato> l4 = contratoService.findAll(); //Guardamos el cliente en la bbdd
		
		System.out.println("***Búsqueda GENERAL en BBDD DESPUES DE BORRAR***");
		for (Contrato a : l4) {
			System.out.println("Contrato de id: " + a.getId() + " y precio: " + a.getPrecio() + " €"); //Mostramos el cliente creado
		}
		System.out.println("================================");
		
		
		
	}
}
