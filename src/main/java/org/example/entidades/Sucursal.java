package org.example.entidades;

import lombok.*;

import java.time.LocalTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Sucursal {
    private Long id;
    private String nombre;
    private LocalTime horarioApartura;
    private LocalTime horarioCierre;
    private Domicilio domicilio;






}
