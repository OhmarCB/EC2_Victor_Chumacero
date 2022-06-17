package com.idat.pe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.dto.BodegaDTORequest;
import com.idat.pe.dto.BodegaDTOResponse;
import com.idat.pe.model.Bodega;
import com.idat.pe.repository.IBodegaRepository;

@Service
public class BodegaServiceImpl implements IBodegaService{

	@Autowired
	public IBodegaRepository repository;
	
	@Override
	public void guardarBodega(BodegaDTORequest bod) {
		
		Bodega b=new Bodega();
		b.setIdBodega(bod.getIdBodega());
		b.setNombre(bod.getNombre());
		b.setDireccion(bod.getDireccion());
		
		repository.save(b);
	}

	@Override
	public void editarBodega(BodegaDTORequest bod) {
		Bodega b=new Bodega();
		b.setIdBodega(bod.getIdBodega());
		b.setNombre(bod.getNombre());
		b.setDireccion(bod.getDireccion());
		
		repository.saveAndFlush(b);
	}

	@Override
	public void eliminarBodega(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<BodegaDTOResponse> listarBodegas() {
		
		List<BodegaDTOResponse>lista=new ArrayList<BodegaDTOResponse>();
		BodegaDTOResponse b=null;
		
		for (Bodega bodegas : repository.findAll()) {
			b=new BodegaDTOResponse();
			b.setIdBodega(bodegas.getIdBodega());
			b.setNombre(bodegas.getNombre());
			b.setDireccion(bodegas.getDireccion());
			
			lista.add(b);
		}
		
		return lista;
	}

	@Override
	public BodegaDTOResponse obtenerBodega(Integer id) {
		BodegaDTOResponse b=new BodegaDTOResponse();
		Bodega bodega=repository.findById(id).orElse(null);
		
		b.setIdBodega(bodega.getIdBodega());
		b.setNombre(bodega.getNombre());
		b.setDireccion(bodega.getDireccion());
		
		return b;
	}

}
