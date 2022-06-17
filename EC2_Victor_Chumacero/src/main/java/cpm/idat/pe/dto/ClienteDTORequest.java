package com.idat.pe.dto;

public class ClienteDTORequest {

	private Integer idClienteDTO;
	private String nombreDTO;
	private String direccionDTO;
	private String dniDTO;
	public Integer getIdClienteDTO() {
		return idClienteDTO;
	}
	public void setIdClienteDTO(Integer idClienteDTO) {
		this.idClienteDTO = idClienteDTO;
	}
	public String getNombreDTO() {
		return nombreDTO;
	}
	public void setNombreDTO(String nombreDTO) {
		this.nombreDTO = nombreDTO;
	}
	public String getDireccionDTO() {
		return direccionDTO;
	}
	public void setDireccionDTO(String direccionDTO) {
		this.direccionDTO = direccionDTO;
	}
	public String getDniDTO() {
		return dniDTO;
	}
	public void setDniDTO(String dniDTO) {
		this.dniDTO = dniDTO;
	}
}
