package com.example.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entities.Empleado;
import com.example.services.EmpleadoService;

import lombok.RequiredArgsConstructor;




@Controller
@RequestMapping("/empleados")
@RequiredArgsConstructor
public class EmpleadoController {

    private final EmpleadoService empleadoService;

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
    

    return "formularioAltaEmpleado";
}

@PostMapping("/guardar")
public String guardarEmpleado(Empleado empleado) {
    // El objeto Empleado ya tiene los valores mapeados de los controles del formulario
    // por lo que solo hay que invocar al servicio para guardar el empleado
    empleadoService.saveEmpleado(empleado);
    // redirigir a la lista de empleados
    return "redirect:/empleados/listar";     
}







}