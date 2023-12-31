package com.example.exameninterfaces;

import lombok.Data;

@Data
public class Cliente {
    private Long id;
    private String nombre;
    private String correo;

    @Override
    public String toString() {
        return  nombre ;
    }

    public Cliente(Long id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }
}
