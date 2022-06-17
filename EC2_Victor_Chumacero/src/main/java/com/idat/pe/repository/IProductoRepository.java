package com.idat.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.pe.model.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Integer>{

}
