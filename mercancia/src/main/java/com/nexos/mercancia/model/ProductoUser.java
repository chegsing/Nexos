package com.nexos.mercancia.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.nexos.mercancia.constants.NexosErrors;

import lombok.Data;

@Data
public class ProductoUser {
	
	@NotBlank(message = NexosErrors.REQUIRED)
	private String nombreProducto;
	@NotBlank(message = NexosErrors.REQUIRED)
	private Integer cantidad;
	@NotBlank(message = NexosErrors.REQUIRED)
	private Date fechaIngreso;
	@NotBlank(message = NexosErrors.REQUIRED)
	private String descripcion;
	@NotBlank(message = NexosErrors.REQUIRED)
	private String usuarioId;
	
}
