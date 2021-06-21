package com.nexos.mercancia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexos.mercancia.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
