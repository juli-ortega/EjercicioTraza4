package org.example.entidades;

import lombok.*;

import java.util.HashSet;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Empresa {
    private Long id;
    private String nombre;
    private String razonSocial;
    private Integer cuil;
    @Builder.Default
    private HashSet<Sucursal>sucursales=new HashSet<>();

    public static void mostrarEmpresas(List<Empresa> empresas){

        for(Empresa empresa: empresas){
            System.out.println("--------------------------------------");

            System.out.println("id: "+empresa.getId());
            System.out.println("nombre: "+empresa.getNombre());
            System.out.println("razon social: "+empresa.getRazonSocial());
            System.out.println("cuil: "+empresa.getCuil());
            System.out.println("sucursales:");
            HashSet<Sucursal>sucursales=empresa.getSucursales();
            for(Sucursal sucursal: sucursales){
                System.out.println("--------------------------------------");
                System.out.println("nombre: "+sucursal.getNombre());
                System.out.println("horario apertura: "+sucursal.getHorarioApartura());
                System.out.println("horario cierre: "+sucursal.getHorarioCierre());
                System.out.println("--------------------------------------");

            }
            System.out.println("--------------------------------------");

        }

    }
    public static void mostrarEmpresa(Empresa empresa){


        System.out.println("--------------------------------------");

        System.out.println("id: "+empresa.getId());
        System.out.println("nombre: "+empresa.getNombre());
        System.out.println("razon social: "+empresa.getRazonSocial());
        System.out.println("cuil: "+empresa.getCuil());
        System.out.println("sucursales:");
        HashSet<Sucursal>sucursales=empresa.getSucursales();
        for(Sucursal sucursal: sucursales){
            System.out.println("--------------------------------------");
            System.out.println("nombre: "+sucursal.getNombre());
            System.out.println("horario apertura: "+sucursal.getHorarioApartura());
            System.out.println("horario cierre: "+sucursal.getHorarioCierre());
            System.out.println("--------------------------------------");

        }
        System.out.println("--------------------------------------");



    }



}
