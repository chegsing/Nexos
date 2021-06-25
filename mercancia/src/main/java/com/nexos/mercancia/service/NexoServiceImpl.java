package com.nexos.mercancia.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nexos.mercancia.entity.Producto;
import com.nexos.mercancia.entity.Usuario;
import com.nexos.mercancia.entity.UsuarioProducto;
import com.nexos.mercancia.mapper.NexoMapper;
import com.nexos.mercancia.model.ProductoUser;
import com.nexos.mercancia.repository.ProductoRepository;
import com.nexos.mercancia.repository.UsuarioProductoRepository;
import com.nexos.mercancia.repository.UsuarioRepository;

@Service(value = "nexoService")
public class NexoServiceImpl implements NexoService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	UsuarioProductoRepository usuarioProductoRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	NexoMapper nexoMapper;

	@Override
	public List<Producto> getProductos(String nombreProducto) {
		if(productoRepository.findAllByNombreProductoIgnoreCase(nombreProducto).isEmpty()) {
			throw new ValidationException("Product no Found");
		}else {
			return productoRepository.findAllByNombreProductoIgnoreCase(nombreProducto);
		}
	}

	@Override
	@Transactional
	public String saveProductoUser(ProductoUser productoUser) {
		logger.debug("saveProductoUser: {}", productoUser.getNombreProducto());
		
		if (productoRepository.existsById(productoUser.getNombreProducto())) {
			logger.debug("saveProductoUser: {}", "Producto repetido");
			throw new ValidationException("Registro duplicado");
		}
		Producto producto = nexoMapper.productoUserToProducto(productoUser);
		
		producto = productoRepository.save(producto);
		saveUsuarioProducto(productoUser);
		return producto.getNombreProducto();
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveUsuarioProducto(ProductoUser productoUser) {
		
		UsuarioProducto usuarioProducto = new UsuarioProducto();
		usuarioProducto.setNombreProducto(productoUser.getNombreProducto());
		usuarioProducto.setIdentificacion(productoUser.getUsuarioId());
		usuarioProducto.setFechaModificacion(productoUser.getFechaIngreso());
		usuarioProductoRepository.save(usuarioProducto);
		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Producto getProducto(String nombreProducto) {
		
		if (!productoRepository.existsById(nombreProducto)) {
			throw new ObjectNotFoundException("Product Not found", nombreProducto);
		}
		
		return productoRepository.findByNombreProducto(nombreProducto);

	}

	@Override
	public List<Usuario> getUsuarios() {
		
		return usuarioRepository.findAll();
	}

	@Override
	public Boolean updateProductoUser(@Valid ProductoUser productoUser) {
		// TODO Auto-generated method stub
		return false;
	}

}
