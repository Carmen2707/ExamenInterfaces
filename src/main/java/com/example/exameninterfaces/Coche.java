package com.example.exameninterfaces;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Coche {
    private String matricula;
    private String modelo;
private Cliente cliente;
private String tarifa;
private LocalDate fEntrada;
private LocalDate fSalida;
private Integer coste;
}
