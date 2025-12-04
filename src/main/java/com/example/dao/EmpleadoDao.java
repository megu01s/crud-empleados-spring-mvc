package com.example.dao;

import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import com.example.entities.Empleado;
import java.util.List;


@Repository
public interface EmpleadoDao extends JpaRepository<Empleado, Integer>{

    List<Empleado> findByNombre(String nombre);
    boolean existsBySalario(double salario);
}
