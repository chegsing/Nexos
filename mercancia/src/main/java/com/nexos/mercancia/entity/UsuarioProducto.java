package com.nexos.mercancia.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.nexos.mercancia.constants.NexosErrors;

@Entity
public class UsuarioProducto {
	
	@NotBlank(message = NexosErrors.REQUIRED)
	private String identificacion;
	@NotBlank(message = NexosErrors.REQUIRED)
	private String nombreProducto;
	@NotBlank(message = NexosErrors.REQUIRED)
	private Date fechaModificacion;
	
	@Id
	
	@Column (name = "identificacion")
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	
	@Column (name = "nombre_producto")
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	
	@Column (name = "fecha_modificacion")
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	
	

}
