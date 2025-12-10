package com.example.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entities.Correo;
import com.example.entities.Departamento;
import com.example.entities.Empleado;
import com.example.entities.Telefono;
import com.example.services.CorreoService;
import com.example.services.DepartamentService;
import com.example.services.EmpleadoService;
import com.example.services.TelefonoService;

import lombok.RequiredArgsConstructor;






@Controller
@RequestMapping("/empleados")
@RequiredArgsConstructor
public class EmpleadoController {

    private final EmpleadoService empleadoService;
    private final DepartamentService departamentoService;
    private final TelefonoService telefonoService;
    private final CorreoService correoService;

    private static final Logger LOGGER = LoggerFactory.getLogger("EmpleadoController"); // enregistrar différent messages niveau d'information (INFO, DEBUG, ERROR, WARN)

    // Al metodo siguiente recibira peticiones (requests), donde la URL
    //http://localhost:8080/empleados/listar
    @GetMapping("/listar")
    public String listarEmpleados(Model model) {

        // recuperar a través del servicio la lista de empleados
        List<Empleado> empleados = empleadoService.getAllEmpleados();
        model.addAttribute("empleados", empleados);

        return "listadoEmpleados";
    }

// Metodo que recibe peticiones para dar de alta un empleado

@GetMapping("/alta")
public String altaEmpleado(Model model) {
    // Como gestiona Spring Framework el formulario de alta de empleado?
    // pues envia un objeto Empleado vacio, para el caso de un alta nueva
    //y vincula los campos del formulario a las propiedades del objeto Empleado
    // con los controles del formulario, es decir de los elementos input, select, etc.
    //de tal manera que cuando se recogen los valores del los controles del formulario
    // en repuesta al evento submit, no hay que hacer absolumente nada, ya que Spring
    // se encarga de mapear los valores de los controles del formulario a las propiedades
    // del objeto Empleado. nada de .getParameter() en proyecto CRUD sin Spring MVC.

    // crear un objeto Empleado vacio
    Empleado empleado = new Empleado();
    model.addAttribute("empleado", empleado);

    // cargar el listado de departamentos para el select del formulario
    List<Departamento> departamentos = departamentoService.getAllDepartamentos();
    model.addAttribute("departamentos", departamentos);

    return "formularioAltaEmpleado";
}

@PostMapping("/guardar")
public String guardarEmpleado(@ModelAttribute Empleado empleado,
    @RequestParam(name = "numeroTelefono", required = false) String numeroTelefono,
    @RequestParam(name = "direccionCorreo", required = false) String direccionCorreo
) {

    LOGGER.info("Empleado guardado");
    //LOGGER.info(empleado.toString());

    // Guardar el empleado usando el servicio
    empleadoService.saveEmpleado(empleado);

    // vamos a comprobar si hay telefono y correo para cada empleado


    //Comprobar si me han enviado numeros de telefono
    if (numeroTelefono != null) {
        String[] telefonosArray = numeroTelefono.split(";");
        List<String> telefonosList = List.of(telefonosArray);
        telefonosList.forEach(numero ->{
            telefonoService.saveTelefono(
                Telefono.builder()
                .numero(numero)
                .empleado(empleado)
                .build()
                
            );
        });
                
    }

    //Comprobar si me han enviado direcciones de correo
    if (direccionCorreo != null) {
        String[] correosArray = direccionCorreo.split(";");
        List<String> correosList = List.of(correosArray);
        correosList.forEach(direccion ->{
            correoService.saveCorreo(
                Correo.builder()
                .email(direccion)
                .empleado(empleado)
                .build()
                
            );
        });
                
    }
    
    return "redirect:/empleados/listar";
}

@GetMapping("/pageliminar")
public String paginaEliminarEmpleado(Model model) {
    // Recuperar la lista de empleados para mostrar en el select
    List<Empleado> empleados = empleadoService.getAllEmpleados();
    model.addAttribute("empleados", empleados);
    model.addAttribute("empleado", new Empleado()); // Objeto empleado para el formulario

    return "eliminarEmpleados";
}
@DeleteMapping("/eliminar")
public String eliminarEmpleado(@RequestParam("id") int empleadoId) {
    // Eliminar el empleado usando el servicio
    empleadoService.eliminarEmpleado(empleadoId);
    LOGGER.info("Empleado eliminado con ID: " + empleadoId);
    return "redirect:/empleados/listar";
}


}

