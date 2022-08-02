package co.unicauca.servidor.declaracion.servidordeclaracion.dao;

import co.unicauca.servidor.declaracion.servidordeclaracion.model.Compra;

public interface ICompraRepository {
    public Compra guardarCompra(Compra save);
    public boolean requiereNotificacion(int identificacionCliente);
}
