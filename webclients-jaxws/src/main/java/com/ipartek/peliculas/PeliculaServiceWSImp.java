
package com.ipartek.peliculas;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "PeliculaServiceWSImp", targetNamespace = "http://pelicula.ws.formacion.ipartek.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PeliculaServiceWSImp {


    /**
     * 
     * @return
     *     returns com.ipartek.peliculas.PeliculasColection
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenertodo", targetNamespace = "http://pelicula.ws.formacion.ipartek.com/", className = "com.ipartek.peliculas.Obtenertodo")
    @ResponseWrapper(localName = "obtenertodoResponse", targetNamespace = "http://pelicula.ws.formacion.ipartek.com/", className = "com.ipartek.peliculas.ObtenertodoResponse")
    public PeliculasColection obtenertodo();

    /**
     * 
     * @param arg0
     * @return
     *     returns com.ipartek.peliculas.PeliculaMensaje
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerporid", targetNamespace = "http://pelicula.ws.formacion.ipartek.com/", className = "com.ipartek.peliculas.Obtenerporid")
    @ResponseWrapper(localName = "obtenerporidResponse", targetNamespace = "http://pelicula.ws.formacion.ipartek.com/", className = "com.ipartek.peliculas.ObtenerporidResponse")
    public PeliculaMensaje obtenerporid(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

}
