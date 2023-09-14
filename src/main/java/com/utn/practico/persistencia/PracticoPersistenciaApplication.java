package com.utn.practico.persistencia;

import com.utn.practico.persistencia.Entidades.Cliente;
import com.utn.practico.persistencia.Entidades.Domicilio;
import com.utn.practico.persistencia.repositorio.ClienteRepository;
import com.utn.practico.persistencia.repositorio.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PracticoPersistenciaApplication {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	DomicilioRepository domicilioRepository;

	public static void main(String[] args) {
		SpringApplication.run(PracticoPersistenciaApplication.class, args);
		System.out.println("Estoy funcionando");
	}

	@Bean
	CommandLineRunner init(ClienteRepository clienteRepository) {
		return args -> {
			System.out.println("-------funciono-------");

			Domicilio domicilio1 = Domicilio.builder()
					.calle("calle 1")
					.numero(123)

					.build();

			Domicilio domicilio2 = Domicilio.builder()
					.calle("calle infanta isabel ")
					.numero(1045)

					.build();

			Cliente cliente1 = Cliente.builder()
					.nombre("Facundo")
					.apellido("Pino")
					.telefono(2613)
					.email("facundoj42@gmail.com")
					.build();



			cliente1.agregarDomicilio(domicilio1);
			cliente1.agregarDomicilio(domicilio2);


			//guardar el objeto persona en la base de datos

			clienteRepository.save(cliente1);
		};
	}

}




