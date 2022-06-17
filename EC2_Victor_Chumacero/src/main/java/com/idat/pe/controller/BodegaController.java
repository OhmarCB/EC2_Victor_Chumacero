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

import com.idat.pe.dto.BodegaDTORequest;
import com.idat.pe.dto.BodegaDTOResponse;
import com.idat.pe.service.IBodegaService;

@RestController
@RequestMapping("/bodega/v1")
public class BodegaController {

	@Autowired
	public IBodegaService service;
	
	@RequestMapping(path ="/listar", method = RequestMethod.GET)
	public ResponseEntity<List<BodegaDTOResponse>> listarBodegas(){
		
		return new ResponseEntity<List<BodegaDTOResponse>>(service.listarBodegas(),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody BodegaDTORequest bodega){
		service.guardarBodega(bodega);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<BodegaDTOResponse> listarPorId(@PathVariable Integer id) {
		
		BodegaDTOResponse b=service.obtenerBodega(id);
		if(b!=null)
			return new ResponseEntity<BodegaDTOResponse>(b,HttpStatus.OK);
		
		return new ResponseEntity<BodegaDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PATCH)
	public ResponseEntity<Void> editar(@RequestBody BodegaDTORequest bodega){
		
		BodegaDTOResponse b=service.obtenerBodega(bodega.getIdBodega());
		
		if(b!=null) {
			service.editarBodega(bodega);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		BodegaDTOResponse b=service.obtenerBodega(id);
		
		if(b!=null) {
			service.eliminarBodega(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
