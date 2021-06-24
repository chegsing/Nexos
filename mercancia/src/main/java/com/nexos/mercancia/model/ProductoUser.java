package com.nexos.mercancia.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.nexos.mercancia.constants.NexosErrors;

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
	
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	
}
