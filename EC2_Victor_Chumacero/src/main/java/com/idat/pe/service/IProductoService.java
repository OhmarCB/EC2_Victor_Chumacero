package com.idat.pe.service;

import java.util.List;

import com.idat.pe.dto.ProductoDTORequest;
import com.idat.pe.dto.ProductoDTOResponse;

public interface IProductoService {

	public void guardarProducto(ProductoDTORequest prod);
	
	public void editarProducto(ProductoDTORequest prod);
	
	public void eliminarProducto(Integer id);
	
	public List<ProductoDTOResponse> listarProductos();
	
	public ProductoDTOResponse obtenerProducto(Integer id);
}
