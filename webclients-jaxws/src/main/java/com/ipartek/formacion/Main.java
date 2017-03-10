package com.ipartek.formacion;

import java.net.MalformedURLException;
import java.util.Map;

import javax.xml.ws.BindingProvider;

import com.ipartek.peliculas.PeliculaMensaje;
import com.ipartek.peliculas.PeliculaServiceWSImp;
import com.ipartek.peliculas.Peliculasservice;

public class Main {
	
	public static void main(String[] args) throws MalformedURLException {
		Peliculasservice cliente = new Peliculasservice();
		//El interfaz es el que encapsula las funcionalidades
		PeliculaServiceWSImp clientesoap = cliente.getPeliculaServiceWSImpPort();
		//ENGANCHAREMOS LOS DATOS DE LA VALIDACION
		
		Map<String, Object> requestHeaders = ((BindingProvider) cliente).getRequestContext();
		//Si la validacion es correcta se obtiene la respuesta
		PeliculaMensaje respuesta = clientesoap.obtenerporid(1);
		
		
	}
}
