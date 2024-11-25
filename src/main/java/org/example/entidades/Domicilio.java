package org.example.entidades;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Domicilio {
    private Long id;
    private String calle;
    private Integer numero;
    private Localidad localidad;
}
