package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Proveedor;
import com.empresa.repository.ProveedorRepository;
 
@Service
public class ProveedorServiceImpl implements ProveedorService{

	@Autowired
	private ProveedorRepository repository;
	
	@Override  
	public Proveedor insertaProveedor(Proveedor obj) {
		return repository.save(obj);
	}

	@Override
	public List<Proveedor> listaProveedorNombreIgual(String nombre) {
		return repository.listaProveedorNombreIgual(nombre);
	}

	@Override
	public List<Proveedor> listaProveedorDniIgual(String dni) {
		return repository.listaProveedorDniIgual(dni);
	}

}
