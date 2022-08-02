package co.unicauca.servidor.declaracion.servidordeclaracion.service;

import co.unicauca.servidor.declaracion.servidordeclaracion.model.Compra;
import sop_corba.ControladorCompraIntPackage.CompraDTO;

public interface INotificarService {
    public boolean notificar(CompraDTO c);
    public void init(Compra c);
}
