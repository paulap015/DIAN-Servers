/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import model.Compra;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 *
 * @author Paula
 */
public class CompraService implements IntCompraService{
    
    private String endPoint;
    private Client objCompraPeticiones;
    
    public CompraService(){
        this.endPoint="http://localhost:8080/api/compra";
        this.objCompraPeticiones= ClientBuilder.newClient().register(new JacksonFeature());
    }

    @Override
    public Compra registrarCompra(Compra compra) {
        Compra objCompra;
        
        WebTarget target = this.objCompraPeticiones.target(this.endPoint+"?idUsuario="+compra.getIdUsuario()+"&tipoId="+compra.getTipoIdentificacion());	    
		
        Entity<Compra> data = Entity.entity(compra, MediaType.APPLICATION_JSON_TYPE);

        Invocation.Builder objPeticion=target.request(MediaType.APPLICATION_JSON_TYPE);

        objCompra = objPeticion.post(data, Compra.class);
        
        return objCompra;
    }
    
    
}
