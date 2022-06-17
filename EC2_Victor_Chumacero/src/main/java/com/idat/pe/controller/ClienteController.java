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

import com.idat.pe.dto.ClienteDTORequest;
import com.idat.pe.dto.ClienteDTOResponse;
import com.idat.pe.service.IClienteService;

@RestController
@RequestMapping("/cliente/v1")
public class ClienteController {

	@Autowired
	public IClienteService service;
	
	@RequestMapping(path ="/listar", method = RequestMethod.GET)
	public ResponseEntity<List<ClienteDTOResponse>> listarClientes(){
		
		return new ResponseEntity<List<ClienteDTOResponse>>(service.listarClientes(),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody ClienteDTORequest cliente){
		service.guardarCliente(cliente);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<ClienteDTOResponse> listarPorId(@PathVariable Integer id) {
		
		ClienteDTOResponse c=service.obtenerCliente(id);
		if(c!=null)
			return new ResponseEntity<ClienteDTOResponse>(c,HttpStatus.OK);
		
		return new ResponseEntity<ClienteDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PATCH)
	public ResponseEntity<Void> editar(@RequestBody ClienteDTORequest cliente){
		
		ClienteDTOResponse c=service.obtenerCliente(cliente.getIdClienteDTO());
		
		if(c!=null) {
			service.editarCliente(cliente);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		ClienteDTOResponse p=service.obtenerCliente(id);
		
		if(p!=null) {
			service.eliminarCliente(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
