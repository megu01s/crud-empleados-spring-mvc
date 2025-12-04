package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dao.DepartamentoDao;
import com.example.entities.Departamento;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartamentoServiceImpl implements DepartamentService  {

    private final DepartamentoDao departamentoDao;

    @Override
    public Departamento saveDepartamento(Departamento departamento) {
        return departamentoDao.save(departamento);
    }

    @Override
    public List<Departamento> getAllDepartamentos() {
        return departamentoDao.findAll();
    }

}
