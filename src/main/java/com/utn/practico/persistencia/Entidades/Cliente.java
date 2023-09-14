package com.utn.practico.persistencia.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "cliente")
public class Cliente implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //se genera la PK incremental y autonumerico
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "telefono")
    private int telefono;
    @Column(name = "email")
    private String email;


    //RELACIOM ONE TO MANY CLIENTE 1=>N DOMICILIO
    //cuando las relaciones son UNIDIRECCIONALES se caracteriza una sola relacion
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    //orphanRemoval: es para asegurarme de que si borro una persona, no me deje ningun objeto huerfano en una relacion que tenga, es decir, me borra domicilio
    //Fetch: necesita la carga temprana para que no produzca error.
    @JoinColumn(name="cliente_fk") //esto es para mapear la FK en la tabla con el nombre de "persona_fk"
    @Builder.Default //se necesita porque sino da error. Lo necesitamos por lombok
    private List<Domicilio> domicilios = new ArrayList<>();

    public void agregarDomicilio(Domicilio domi){

        domicilios.add(domi);
    }

    public void mostrarDomicilio() {
        System.out.println("Domicilios de " + nombre + " " + apellido + ":" );

        for (Domicilio domicilio : domicilios){
            System.out.println("calle: " + domicilio.getCalle());
        }
    }
}
