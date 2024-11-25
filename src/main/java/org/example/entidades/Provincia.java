package org.example.entidades;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Provincia {
    private Long id;
    private String nombre;
    private Pais pais;


}
