package com.idat.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.pe.model.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Integer>{

}
