package org.example;

import lombok.*;
import org.example.entidades.*;
import org.example.repositorio.InMemoryRepository;

import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        InMemoryRepository<Empresa> repoEmpresas= new InMemoryRepository<>();
        InMemoryRepository<Sucursal> repoSucursales= new InMemoryRepository<>();
        InMemoryRepository<Domicilio> repoDomicilios= new InMemoryRepository<>();
        InMemoryRepository<Localidad> repoLocalidades= new InMemoryRepository<>();
        InMemoryRepository<Provincia> repoProvincias= new InMemoryRepository<>();
        InMemoryRepository<Pais> repoPais= new InMemoryRepository<>();

        //creo el pais
        Pais argentina = Pais.builder()
                .nombre("Argentina")
                .build();
        repoPais.save(argentina);
        //creo buenos aires
        Provincia buenosAires=Provincia.builder()
                .nombre("Buenos Aires")
                .pais(argentina)
                .build();
        repoProvincias.save(buenosAires);
        //creo caba de la provincia buenos aires
        Localidad caba=Localidad.builder()
                .nombre("CABA")
                .provincia(buenosAires)
                .build();
        repoLocalidades.save(caba);
        //creo el primer domicilio de caba
        Domicilio domicilioCaba=Domicilio.builder()
                .calle("San martin")
                .numero(195)
                .localidad(caba)
                .build();
        repoDomicilios.save(domicilioCaba);
        //creo otra localidad para buenos aires
        Localidad laPlata= Localidad.builder()
                .provincia(buenosAires)
                .nombre("La Plata")
                .build();
        repoLocalidades.save(laPlata);
        //creo un domicilio para la plata
        Domicilio domicilioLaplata=Domicilio.builder()
                .calle("Boulogne Sur Mer")
                .numero(2000)
                .localidad(laPlata)
                .build();
        repoDomicilios.save(domicilioLaplata);
        //creo cordoba
        Provincia cordoba = Provincia.builder()
                .nombre("Córdoba")
                .pais(argentina)
                .build();
        repoProvincias.save(cordoba);
        //creo cordoba capital y lo asigno a cordoba
        Localidad cordobaCapital = Localidad.builder()
                .nombre("Córdoba Capital")
                .provincia(cordoba)
                .build();
        repoLocalidades.save(cordobaCapital);
        //creo el domicilio para cordoba capital
        Domicilio domicilioCordobaCapital = Domicilio.builder()
                .calle("Avenida Colón")
                .numero(500)
                .localidad(cordobaCapital)
                .build();
        repoDomicilios.save(domicilioCordobaCapital);
        //creo Villa carlos paz para cordoba
        Localidad villaCarlosPaz = Localidad.builder()
                .nombre("Villa Carlos Paz")
                .provincia(cordoba)
                .build();
        repoLocalidades.save(villaCarlosPaz);
        //creo el domicilio de Villa carlos paz
        Domicilio domicilioVillaCarlosPaz = Domicilio.builder()
                .calle("San Roque")
                .numero(123)
                .localidad(villaCarlosPaz)
                .build();
        repoDomicilios.save(domicilioVillaCarlosPaz);
        //sucursal 1 en caba
        Sucursal sucursal1=Sucursal.builder()
                .nombre("Sucursal 1 - CABA")
                .horarioApartura(LocalTime.of(16,0))
                .horarioCierre(LocalTime.of(22,0))
                .domicilio(domicilioCaba)
                .build();
        repoSucursales.save(sucursal1);
        //sucursal 2 la plata
        Sucursal sucursal2= Sucursal.builder()
                .nombre("Sucursal 2 - La Plata")
                .horarioApartura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(18, 0))
                .domicilio(domicilioLaplata)
                .build();
        repoSucursales.save(sucursal2);
        //sucursal 3 cordoba capital
        Sucursal sucursal3 = Sucursal.builder()
                .nombre("Sucursal 3 - Córdoba Capital")
                .horarioApartura(LocalTime.of(10, 0))
                .horarioCierre(LocalTime.of(19, 0))
                .domicilio(domicilioCordobaCapital)
                .build();
        repoSucursales.save(sucursal3);
        //sucursal 4 villa carlos paz
        Sucursal sucursal4= Sucursal.builder()
                .nombre("Sucursal 4 - Villa Carlos Paz")
                .horarioApartura(LocalTime.of(11, 0))
                .horarioCierre(LocalTime.of(20, 0))
                .domicilio(domicilioVillaCarlosPaz)
                .build();
        repoSucursales.save(sucursal4);
        //creo la empresa 1
        Empresa empresa1 = Empresa.builder()
                .cuil(20987654)
                .nombre("Empresa 1")
                .razonSocial("Razon Social")
                .build();
        HashSet<Sucursal>empresa1Sucursales=new HashSet<>(Arrays.asList(sucursal1,sucursal2));
        empresa1.setSucursales(empresa1Sucursales);
        repoEmpresas.save(empresa1);
        //creo la empresa 2
        Empresa empresa2 = Empresa.builder()
                .cuil(20987655)
                .nombre("Empresa 2")
                .razonSocial("Razon Social 2")
                .build();
        HashSet<Sucursal> empresa2Sucursales = new HashSet<>(Arrays.asList(sucursal3, sucursal4));
        empresa2.setSucursales(empresa2Sucursales);
        repoEmpresas.save(empresa2);

        //muestro todas las empresas
        List<Empresa> empresas=repoEmpresas.findAll();
        Empresa.mostrarEmpresas(empresas);

        //busco empresa por su id
        System.out.println("empresa 2 buscada por su id");
        Optional<Empresa> empresaBuscada = repoEmpresas.findById(2L);
        empresaBuscada.ifPresentOrElse(
                empresa -> {Empresa.mostrarEmpresa(empresa);},
                () -> System.out.println("No se encontró la empresa con ID 2")
        );

        //busco empresa por su nombre
        List<Empresa> empresabuscada2=repoEmpresas.genericFindByField("nombre","Empresa 1");
        Empresa.mostrarEmpresas(empresabuscada2);

        //elimino empresa buscando por su id
        Empresa empresaEliminada = repoEmpresas.genericDelete(1L).orElse(null);
        if (empresaEliminada != null) {
            System.out.println("Empresa eliminada: " + empresaEliminada.getNombre());
        } else {
            System.out.println("No se encontró la empresa con ID 1 para eliminar");
        }

    }
}