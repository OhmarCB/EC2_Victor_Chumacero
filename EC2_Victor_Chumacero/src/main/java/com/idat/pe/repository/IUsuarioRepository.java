package com.idat.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.pe.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{

	Usuario findByUsuario(String usuario);
}
