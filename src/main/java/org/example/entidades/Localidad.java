package org.example.entidades;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Localidad {
    private Long id;
    private String nombre;
    private Provincia provincia;


}
