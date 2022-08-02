/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.controladores;

import servidor.Repositorio.IntCompraRepository;
import servidor.view.VistaNotificacion;
import sop_corba.ControladorCompraIntPOA;
import sop_corba.ControladorCompraIntPackage.CompraDTO;

/**
 *
 * @author Paula
 */
public class CompraControladorImpl extends ControladorCompraIntPOA{

    private final IntCompraRepository objCompraRepositorio;
    private VistaNotificacion vista;
    public CompraControladorImpl(IntCompraRepository objCompraRepositorio) {
        this.objCompraRepositorio = objCompraRepositorio;
    }
            
    
    @Override
    public boolean registrarCompra(CompraDTO objCompra) {
        boolean bandera=false;
        System.out.println("Registrando la compra wiii "+objCompra.idUsuario);
        if(this.objCompraRepositorio.registrarCompra(objCompra))
        {
             bandera=true;
             //lamar gui
            vista=new VistaNotificacion(objCompra);
            vista.setVisible(true);
        }
        return bandera;
    }

    @Override
    public CompraDTO[] listarCanciones() {
        CompraDTO[] vector=new CompraDTO[objCompraRepositorio.listarCompra().size()];
        this.objCompraRepositorio.listarCompra().toArray(vector);
        return vector;
    }
    
}
