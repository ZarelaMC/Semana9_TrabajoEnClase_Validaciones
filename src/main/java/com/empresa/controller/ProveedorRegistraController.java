package com.empresa.controller;

import java.util.Date;
import java.util.HashMap; 
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empresa.entity.Proveedor;
import com.empresa.service.ProveedorService;

@Controller
public class ProveedorRegistraController {

	@Autowired
	private ProveedorService proveedorService;
	
	@GetMapping(value = "/verRegistraProveedor" )
	public String verProveedor() {return "registraProveedor";}

	
	@PostMapping("/registraProveedor")
	@ResponseBody
	public Map<String, String> registra(Proveedor obj) {
		HashMap<String, String> map = new HashMap<String, String>();
		obj.setFechaRegistro(new Date());
		obj.setFechaActualizacion(new Date());
		obj.setEstado(1);
		Proveedor objSalida = proveedorService.insertaProveedor(obj);
		if (objSalida == null) {
			map.put("MENSAJE", "Error en el registro");
		} else {
			map.put("MENSAJE", "Registro exitoso");
		}
		return map;
	}
	
	//--------------- Mètodos para VALIACIÒN - Semana 09 --------------------------
		@GetMapping("/buscaProveedorPorNombre")
		@ResponseBody
		public String validaNombre(String nombre) {
			List<Proveedor> lst = proveedorService.listaProveedorNombreIgual(nombre);
			if(CollectionUtils.isEmpty(lst)) {
				return "{\"valid\":true}";
			}else {
				return "{\"valid\":false}";
			}
		}
		
		@GetMapping("/buscaProveedorPorDni")
		@ResponseBody
		public String validaDni(String dni) {
			List<Proveedor> lst = proveedorService.listaProveedorDniIgual(dni);
			if(CollectionUtils.isEmpty(lst)) {
				return "{\"valid\":true}";
			}else {
				return "{\"valid\":false}";
			}
		}

}
