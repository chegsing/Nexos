package com.nexos.mercancia.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.xml.bind.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nexos.mercancia.entity.Producto;
import com.nexos.mercancia.entity.Usuario;
import com.nexos.mercancia.model.ProductoUser;
import com.nexos.mercancia.service.NexoService;



@RestController
@RequestMapping("api")
public class NexosController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "nexoService")
	private NexoService nexoService;
	
	@GetMapping (value = "/productos")
	public List<Producto> getProductos(@RequestParam (required = true) final String nombreProducto ) {
		return nexoService.getProductos(nombreProducto);
	}
	
	@PostMapping (value = "/productos")
	public String crearProducto(@Valid @RequestBody ProductoUser addProducto) {
		
		String nombreProducto = "";
		try {
			nombreProducto =nexoService.saveProductoUser(addProducto);
		}catch(Exception ve) {
			return "Producto Repetido";
		}
		
		if (nombreProducto.isEmpty()) {
			return "producto no pudo ser insertado";
		}else {
			return "producto insertado correctamente";
		}
	}
	
	@PutMapping (value = "/updateProductos")
	public String updateProducto(@Valid @RequestBody ProductoUser productoUser) {
		
		boolean producto = nexoService.updateProductoUser(productoUser);
		
		
		if (Boolean.FALSE.equals(producto)) {
			return "producto no pudo ser insertado";
		}else {
			return "producto insertado correctamente";
		}
	}
	
	@GetMapping (value = "/usuarios")
	public List<Usuario> getUsuarios() {
		return nexoService.getUsuarios();
	}

}
