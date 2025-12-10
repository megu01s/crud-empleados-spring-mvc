package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dao.CorreoDao;
import com.example.entities.Correo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class CorreoServiceImpl implements CorreoService {

private final CorreoDao correoDao;
@Override
public List<Correo> getAllCorrreos() {
return correoDao.findAll();
}

@Override
public Correo saveCorreo(Correo correo) {
return correoDao.save(correo);
}

}