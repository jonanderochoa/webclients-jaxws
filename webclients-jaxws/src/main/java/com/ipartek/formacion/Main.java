package com.ipartek.formacion;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

import com.ipartek.peliculas.Pelicula;
import com.ipartek.peliculas.PeliculaMensaje;
import com.ipartek.peliculas.PeliculaServiceWSImp;
import com.ipartek.peliculas.Peliculasservice;

public class Main {

	public static void main(String[] args)  {
		Peliculasservice cliente = new Peliculasservice();
		PeliculaServiceWSImp clientesoap = cliente.getPeliculaServiceWSImpPort();
		
		//ENGANCHAREMOS A LA PETICION LOS DATOS DE LA VALIDACION
		//Capturo el contexto asociado a la peticion y lo guardamos en un map
		Map<String, Object> requestContext = ((BindingProvider) clientesoap).getRequestContext();
		
		//Genero la estructura necesaria para enviar los datos
		Map<String, List<String>> requestHeaders = new HashMap<String, List<String>>();
		requestHeaders.put("sessionid", Collections.singletonList("ipsession"));
		
		//Introduzco los datos en el encabezado de la peticion
		requestContext.put(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);
		
		//Si la validacion es correcta se obtiene la respuesta
		PeliculaMensaje respuesta = clientesoap.obtenerporid(3);
		clientesoap.obtenertodo();
		if(respuesta.getPelicula() == null){
			System.out.println(respuesta.getMensaje());
		}else{
			Pelicula pelicula = respuesta.getPelicula();
			System.out.println(pelicula.getTitulo());
		}
		
		
	}
}
