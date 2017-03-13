package com.ipartek.formacion;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

import com.ipartek.peliculas.Pelicula;
import com.ipartek.peliculas.PeliculaMensaje;
import com.ipartek.peliculas.PeliculaServiceWSImp;
import com.ipartek.peliculas.PeliculasColection;
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
		//Metemos en el header del contexto los valores que mandamos
		requestHeaders.put("sessionid", Collections.singletonList("ipsession"));
		requestHeaders.put("user", Collections.singletonList("jon"));
		requestHeaders.put("password", Collections.singletonList("thor"));
		
		
		//Introduzco los datos en el encabezado de la peticion
		requestContext.put(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);
		
		System.out.println("_______________________________getById(3)___________________________");
		//Si la validacion es correcta se obtiene la respuesta
		PeliculaMensaje respuesta = clientesoap.obtenerporid(3);
		if(respuesta.getPelicula() == null){
			System.out.println(respuesta.getMensaje());
		}else{
			Pelicula pelicula = respuesta.getPelicula();
			System.out.println(pelicula.getTitulo());
		}
		
		PeliculasColection coleccion = clientesoap.obtenertodo();
		if(coleccion.getPeliculas() == null){
			System.out.println("Coleccion vacia");
		}else{
			List<Pelicula> listaPeliculas = coleccion.getPeliculas();
			System.out.println("_______________________________getAll()______________________________");
			Iterator<Pelicula> it = listaPeliculas.iterator();
			while(it.hasNext()){
				Pelicula aux = it.next();
				System.out.println("codigo: "+aux.getCodigo()+", titulo: "+ aux.getTitulo()+
						", genero: "+aux.getGenero().getNombre()+", fecha de estreno: "+aux.getFestreno().getDay()+"/"+aux.getFestreno().getMonth()+1+"/"+aux.getFestreno().getYear());
			}
		}
		
	}
}
