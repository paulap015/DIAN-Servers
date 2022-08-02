/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.Repositorio;

import java.util.ArrayList;
import java.util.List;
import servidor.view.VistaNotificacion;
import sop_corba.ControladorCompraIntPackage.CompraDTO;

/**
 *
 * @author Paula
 */
public class CompraRepositorio implements IntCompraRepository{

    private final ArrayList<CompraDTO> listaCompras;
    
    public CompraRepositorio() {
        this.listaCompras = new ArrayList();
    }
    
    
    @Override
    public boolean registrarCompra(CompraDTO objCompra) {
        boolean bandera;        
        bandera= this.listaCompras.add(objCompra);
        System.out.println("Archivo creado en el servidor");  
        
        
        return bandera;
    }

    @Override
    public List<CompraDTO> listarCompra() {
        System.out.println("Listando compras");
        return this.listaCompras;
    }
    
}
