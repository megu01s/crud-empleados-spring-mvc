package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dao.EmpleadoDao;
import com.example.entities.Empleado;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

    // Se necesita connectarse al DAO
    // Anteriormente esto se hacia usando una anotacion @Autowired
    // cuando se crease un objeto de tipo EmpleadoService tb se crease un objeto de la capa DAO
    // Esta anotacion esta obsoleta, porque actualmente es mas eficiente inyectar el objeto
    // de la capa dao mediante el constructor de la clase de servicio EmpleadoServiceImpl,
    // lo cual ha sido mejorado con una anotacion de lombok

    //TRADICIONALMENTE: inyeccion de dependencia via constructor para inyectar el DAO
    //@Autowired
    private final EmpleadoDao empleadoDao;

/*     public EmpleadoServiceImpl(EmpleadoDao empleadoDao) {
        this.empleadoDao = empleadoDao;
    } */

    @Override
    public List<Empleado> getAllEmpleados() {
        return empleadoDao.findAll();
    }

    @Override
    public Empleado getEmpleado(int empleadoId) {
        return empleadoDao.findById(empleadoId).get();
    }

    @Override
    public Empleado saveEmpleado(Empleado empleado) {
        return empleadoDao.save(empleado);
    }

    @Override
    public void deleteEmpleado(Empleado empleado) {
        empleadoDao.delete(empleado);
    }

    @Override
    public Empleado updateEmpleado(int empleadoId) {
        return empleadoDao.save(empleadoDao.findById(empleadoId).get());
    }

    @Override
    public List<Empleado> findByNombre(String nombre) {
        return empleadoDao.findByNombre(nombre);
    }

    @Override
    public boolean existsBySalario(double salario) {
        return empleadoDao.existsBySalario(salario);
    }
    @Override
    public void eliminarEmpleado(int empleadoId) {
        empleadoDao.delete(empleadoDao.findById(empleadoId).get());
    }

}
