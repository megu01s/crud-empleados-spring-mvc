package com.example.services;

import java.util.List;

import com.example.entities.Empleado;

public interface EmpleadoService {

    List<Empleado> getAllEmpleados();
    Empleado getEmpleado(int empleadoId);
    Empleado saveEmpleado(Empleado empleado);
    void deleteEmpleado(Empleado empleado);
    Empleado updateEmpleado(int empleadoId);
    List<Empleado> findByNombre(String nombre);
    boolean existsBySalario(double salario);


    
}
