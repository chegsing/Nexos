package com.nexos.mercancia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import com.nexos.mercancia.entity.Producto;
import com.nexos.mercancia.model.ProductoUser;
import com.nexos.mercancia.service.NexoService;

@SpringBootTest
@ContextConfiguration(classes = { MercanciaApplication.class })
class MercanciaApplicationTests {
	
	@MockBean
	private NexoService nexoService;
	
    
	@Test
	void contextLoads() {
	}
	
	@Test
	void getProducto() {
		
		Producto producto = new Producto();
		producto.setCantidad(10);
		producto.setNombreProducto("Producto Ejemplo 6");
		producto.setFechaIngreso(new Date());
		producto.setDescripcion("Producto Ejemplo 6");
		Mockito.when(nexoService.getProducto("Producto Ejemplo 6")).thenReturn(producto);
		assertNotNull(nexoService.getProducto("Producto Ejemplo 6"));
	}
	
	@Test
	void getProductoNotExists() {

		Mockito.when(nexoService.getProducto("Producto Ejemplo X")).thenReturn(null);
		assertNull(nexoService.getProducto("Producto Ejemplo 6"));
	}
	
	@Test
	void saveProductoUser() {		
		ProductoUser productoUser = new ProductoUser();
		productoUser.setCantidad(10);
		productoUser.setNombreProducto("Producto Ejemplo 7");
		productoUser.setFechaIngreso(new Date());
		productoUser.setDescripcion("Producto Ejemplo 7");
		productoUser.setUsuarioId("1010");
		Mockito.when(nexoService.saveProductoUser(productoUser)).thenReturn("Producto Ejemplo 7");
		assertEquals("Producto Ejemplo 7",nexoService.saveProductoUser(productoUser));
	}
	
	@Test
	void updateProductoUser() {
		ProductoUser productoUser = new ProductoUser();
		productoUser.setCantidad(10);
		productoUser.setNombreProducto("Producto Ejemplo 7");
		productoUser.setFechaIngreso(new Date());
		productoUser.setDescripcion("Producto Ejemplo 7");
		productoUser.setUsuarioId("1010");
		Mockito.when(nexoService.updateProductoUser(productoUser)).thenReturn(Boolean.TRUE);
		assertTrue(nexoService.updateProductoUser(productoUser));
	}

}
