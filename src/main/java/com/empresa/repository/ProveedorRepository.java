package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.entity.Proveedor;
   
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer>{
	@Query("select p from Proveedor p where p.nombre like ?1")
	public List<Proveedor> listaProveedorNombreIgual(String nombre);

	@Query("select p from Proveedor p where p.dni = ?1")
	public List<Proveedor> listaProveedorDniIgual(String dni);
}
