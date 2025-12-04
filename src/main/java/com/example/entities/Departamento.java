package com.example.entities;

import java.io.Serializable;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departamentos")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Departamento implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

    // Las relaciones entre la entidades JPA son bidireccionales, a differencia
    // las relaciones que se establecen los sistemas de gestion BBDD relacionales
    // El padre no sabe nada de los hijos, los hijos saben si del padre.
    // La Foreign Key se crea del lado de los hijos y en padre no hay nada.
    // Aqui, si se sabe tanto en padre como en hijos.

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "departamento")
    private List<Empleado> empleados;
}
