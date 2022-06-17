package com.idat.pe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.dto.ClienteDTORequest;
import com.idat.pe.dto.ClienteDTOResponse;
import com.idat.pe.model.Cliente;
import com.idat.pe.repository.IClienteRepository;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	public IClienteRepository repository;
	
	@Override
	public void guardarCliente(ClienteDTORequest cli) {
		
		Cliente c=new Cliente();
		c.setIdCliente(cli.getIdClienteDTO());
		c.setNombre(cli.getNombreDTO());
		c.setDni(cli.getDniDTO());
		c.setDireccion(cli.getDireccionDTO());
		
		repository.save(c);
	}

	@Override
	public void editarCliente(ClienteDTORequest cli) {
		Cliente c=new Cliente();
		c.setIdCliente(cli.getIdClienteDTO());
		c.setNombre(cli.getNombreDTO());
		c.setDni(cli.getDniDTO());
		c.setDireccion(cli.getDireccionDTO());
		
		repository.saveAndFlush(c);
	}

	@Override
	public void eliminarCliente(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<ClienteDTOResponse> listarClientes() {
		
		List<ClienteDTOResponse>lista=new ArrayList<ClienteDTOResponse>();
		ClienteDTOResponse c=null;
		
		for (Cliente clientes : repository.findAll()) {
			c=new ClienteDTOResponse();
			c.setIdClienteDTO(clientes.getIdCliente());
			c.setNombreDTO(clientes.getNombre());
			c.setDniDTO(clientes.getDni());
			c.setDireccionDTO(clientes.getDireccion());
			
			lista.add(c);
		}
		
		return lista;
	}

	@Override
	public ClienteDTOResponse obtenerCliente(Integer id) {
		
		ClienteDTOResponse c=new ClienteDTOResponse();
		Cliente cliente=repository.findById(id).orElse(null);
		
		c.setIdClienteDTO(cliente.getIdCliente());
		c.setNombreDTO(cliente.getNombre());
		c.setDniDTO(cliente.getDni());
		c.setDireccionDTO(cliente.getDireccion());
		
		return c;
	}

}
