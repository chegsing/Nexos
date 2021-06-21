package com.nexos.mercancia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nexos.mercancia.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, String> {
	
	List<Producto> findAllByNombreProductoIgnoreCase(String nombreProducto);
	
	Producto findByNombreProducto(String nombreProducto);
	
}
