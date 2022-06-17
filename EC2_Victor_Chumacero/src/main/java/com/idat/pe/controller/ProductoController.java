package com.idat.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.pe.dto.ProductoDTORequest;
import com.idat.pe.dto.ProductoDTOResponse;
import com.idat.pe.service.IProductoService;

@RestController
@RequestMapping("/producto/v1")
public class ProductoController {

	@Autowired
	public IProductoService service;
	
	@RequestMapping(path ="/listar", method = RequestMethod.GET)
	public ResponseEntity<List<ProductoDTOResponse>> listarProducto(){
		
		return new ResponseEntity<List<ProductoDTOResponse>>(service.listarProductos(),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody ProductoDTORequest producto){
		service.guardarProducto(producto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProductoDTOResponse> listarPorId(@PathVariable Integer id) {
		
		ProductoDTOResponse p=service.obtenerProducto(id);
		if(p!=null)
			return new ResponseEntity<ProductoDTOResponse>(p,HttpStatus.OK);
		
		return new ResponseEntity<ProductoDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PATCH)
	public ResponseEntity<Void> editar(@RequestBody ProductoDTORequest producto){
		
		ProductoDTOResponse p=service.obtenerProducto(producto.getIdProductoDTO());
		
		if(p!=null) {
			service.editarProducto(producto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		ProductoDTOResponse p=service.obtenerProducto(id);
		
		if(p!=null) {
			service.eliminarProducto(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}
