package com.utn.practico.persistencia.repositorio;

import com.utn.practico.persistencia.Entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomicilioRepository extends JpaRepository <Domicilio, Long> {

}
