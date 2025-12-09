package com.example.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
