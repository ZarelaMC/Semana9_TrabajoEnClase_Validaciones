package com.empresa.service;

import java.util.List;

import com.empresa.entity.Proveedor;

public interface ProveedorService {   

	public abstract Proveedor insertaProveedor(Proveedor obj);
	
	//--------------- Mètodos para VALIACIÒN - Semana 09 --------------------------
		public abstract List<Proveedor> listaProveedorNombreIgual(String nombre);
		public abstract List<Proveedor> listaProveedorDniIgual(String dni);
}
