package com.example.services;

import java.util.List;

import com.example.entities.Correo;

public interface CorreoService {
List<Correo> getAllCorrreos();
Correo saveCorreo(Correo correo);
}
