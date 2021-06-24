package com.nexos.mercancia.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.nexos.mercancia.entity.Producto;
import com.nexos.mercancia.model.ProductoUser;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface NexoMapper {
	
	Logger log = LoggerFactory.getLogger(NexoMapper.class);
	
	Producto productoUserToProducto(ProductoUser productoUser);

}
