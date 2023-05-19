package com.github.viniciusvk1.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.viniciusvk1.domain.model.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long>{

}
