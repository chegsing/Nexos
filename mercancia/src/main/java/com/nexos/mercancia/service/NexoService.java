package com.nexos.mercancia.service;

import java.util.List;

import javax.validation.Valid;

import com.nexos.mercancia.entity.Producto;
import com.nexos.mercancia.entity.Usuario;
import com.nexos.mercancia.model.ProductoUser;

public interface NexoService {

	public List<Producto> getProductos(String nombreProducto);
	
	public String saveProductoUser(ProductoUser productoUser);

	public Producto getProducto(String nombreProducto);

	public List<Usuario> getUsuarios();

	public String updateProductoUser(@Valid ProductoUser productoUser);
}
