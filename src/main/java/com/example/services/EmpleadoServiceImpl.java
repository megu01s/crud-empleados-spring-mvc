package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entities.Empleado;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Override
    public List<Empleado> getAllEmpleados() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllEmpleados'");
    }

    @Override
    public Empleado getEmpleado() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmpleado'");
    }

    @Override
    public Empleado saveEmpleado() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveEmpleado'");
    }

    @Override
    public void deleteEmpleado(Empleado empleado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteEmpleado'");
    }

    @Override
    public Empleado updateEmpleado(int empleadoId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateEmpleado'");
    }

    @Override
    public List<Empleado> findByNombre(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByNombre'");
    }

    @Override
    public boolean existsBySalario(double salario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsBySalario'");
    }

}
