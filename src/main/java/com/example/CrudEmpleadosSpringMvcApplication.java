package com.example;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entities.Correo;
import com.example.entities.Departamento;
import com.example.entities.Empleado;
import com.example.entities.Telefono;
import com.example.models.Genero;
import com.example.services.CorreoService;
import com.example.services.DepartamentService;
import com.example.services.EmpleadoService;
import com.example.services.TelefonoService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class CrudEmpleadosSpringMvcApplication implements CommandLineRunner {

	private final EmpleadoService empleadoService;
	private final DepartamentService departamentService;
	private final TelefonoService telefonoService;
	private final CorreoService correoService;

	public static void main(String[] args) {
		SpringApplication.run(CrudEmpleadosSpringMvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Vamos a crear departamentos y despues empleados
		Departamento departamento1 = Departamento.builder()
				.nombre("RRHH")
				.build();
		Departamento departamento2 = Departamento.builder()
				.nombre("INFORMATICA")
				.build();
		Departamento departamento3 = Departamento.builder()
				.nombre("CONTABILIDAD")
				.build();
		Departamento departamento4 = Departamento.builder()
				.nombre("FINANZAS")
				.build();

		// Persistir los departamentos
		departamentService.saveDepartamento(departamento1);
		departamentService.saveDepartamento(departamento2);
		departamentService.saveDepartamento(departamento3);
		departamentService.saveDepartamento(departamento4);

		Empleado empleado1 = Empleado.builder()
				.nombre("Luis")
				.primerApellido("Hernandez")
				.segundoApellido("Gomez")
				.genero(Genero.HOMBRE)
				.salario(2500.0)
				.fechaAlta(LocalDate.of(2022, 5, 15))
				.departamento(departamento2)
				.build();
				
		Empleado empleado2 = Empleado.builder()
				.nombre("Ana")
				.primerApellido("Lopez")
				.segundoApellido("Martinez")
				.genero(Genero.MUJER)
				.salario(3000.0)
				.fechaAlta(LocalDate.of(2000, 10, 20))
				.departamento(departamento1)
				.build();

		Empleado empleado3 = Empleado.builder()
				.nombre("Carlos")
				.primerApellido("Sanchez")
				.segundoApellido("Diaz")
				.genero(Genero.HOMBRE)
				.salario(2800.0)
				.fechaAlta(LocalDate.of(2025, 10, 15))
				.departamento(departamento3)
				.build();

		empleadoService.saveEmpleado(empleado1);
		empleadoService.saveEmpleado(empleado2);
		empleadoService.saveEmpleado(empleado3);

		//Agregar los telefonos a los empleados

		Telefono telefono1 = Telefono.builder()
				.numero("123456789")
				.empleado(empleado1)
				.build();

		Telefono telefono2 = Telefono.builder()
				.numero("987654321")
				.empleado(empleado2)
				.build();

		Telefono telefono3 = Telefono.builder()
				.numero("555555555")
				.empleado(empleado3)
				.build();

		telefonoService.saveTelefono(telefono1);
		telefonoService.saveTelefono(telefono2);
		telefonoService.saveTelefono(telefono3);

		// Agregar los correos a los empleados
		Correo correo1 = Correo.builder()
				.email("test1@gmail.com")
				.empleado(empleado1)
				.build();
		Correo correo2 = Correo.builder()
				.email("test2@gmail.com")
				.empleado(empleado2)
				.build();
		Correo correo3 = Correo.builder()
				.email("test3@gmail.com")
				.empleado(empleado3)
				.build();
		correoService.saveCorreo(correo1);
		correoService.saveCorreo(correo2);
		correoService.saveCorreo(correo3);
		

	}

}
