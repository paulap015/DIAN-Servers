package co.unicauca.servidor.declaracion.servidordeclaracion.dao;

import co.unicauca.servidor.declaracion.servidordeclaracion.model.Compra;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class CompraRepositoryImpl implements ICompraRepository{
    private HashMap<Integer, ArrayList<Compra>> registroCompras;
    public CompraRepositoryImpl(){
        this.registroCompras = new HashMap<>();
    }
    @Override
    public Compra guardarCompra(Compra save) {
        try{
            if (!this.registroCompras.containsKey(save.getIdUsuario())) {
                this.registroCompras.put(save.getIdUsuario(), new ArrayList<Compra>());
            }
            this.registroCompras.get(save.getIdUsuario()).add(save);
            System.out.println("Compra guardada del usuario "+save.getIdUsuario());
            return this.registroCompras.get(save.getIdUsuario()).get(this.registroCompras.get(save.getIdUsuario()).size()-1);
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public boolean requiereNotificacion(int identificacionCliente) {
        double totalCompraUsuario = 0;
        for(Compra c : this.registroCompras.get(identificacionCliente)){
            totalCompraUsuario += c.getValorCompra();
        }
        if (totalCompraUsuario > 45000000){
            return true;
        }
        return false;
    }
}
