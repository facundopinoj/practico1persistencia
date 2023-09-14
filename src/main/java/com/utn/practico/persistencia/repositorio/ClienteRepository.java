package com.utn.practico.persistencia.repositorio;

import com.utn.practico.persistencia.Entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente, Long> {


}
