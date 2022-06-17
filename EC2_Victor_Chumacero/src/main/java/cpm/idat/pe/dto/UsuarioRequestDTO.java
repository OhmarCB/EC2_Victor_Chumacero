package com.idat.pe.dto;

public class UsuarioRequestDTO {

	private String usuario;
	private String contrasena;
	
	public UsuarioRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UsuarioRequestDTO(String usuario, String contrasena) {
		super();
		this.usuario = usuario;
		this.contrasena = contrasena;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
}
