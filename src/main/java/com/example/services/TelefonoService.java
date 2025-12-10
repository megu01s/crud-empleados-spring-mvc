package com.example.services;

import java.util.List;

import com.example.entities.Telefono;

public interface TelefonoService {
List<Telefono> getTelefonos();
Telefono saveTelefono(Telefono telefono);
}
