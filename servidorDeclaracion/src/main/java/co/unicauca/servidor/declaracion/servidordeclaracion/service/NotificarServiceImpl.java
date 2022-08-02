package co.unicauca.servidor.declaracion.servidordeclaracion.service;


import co.unicauca.servidor.declaracion.servidordeclaracion.model.Compra;
import co.unicauca.servidor.declaracion.servidordeclaracion.service.utilidades.UtilidadesRegistroC;
import org.springframework.stereotype.Service;
import sop_corba.ControladorCompraInt;
import sop_corba.ControladorCompraIntPackage.CompraDTO;

@Service
public class NotificarServiceImpl implements INotificarService, Runnable{
    private CompraDTO compraNotificar;
    private  ControladorCompraInt objRemoto;

//    public NotificarServiceImpl(ControladorCompraInt objRemoto) {
//        this.objRemoto = objRemoto;
//    }
    
    @Override
    public boolean notificar(CompraDTO c) {
        //TO DO: Consultar el OR y acceder el métoodo remoto.
        String[] vectorDatosLocalizarNS = new String[4];
        vectorDatosLocalizarNS[0] = "-ORBInitialHost";
        //System.out.println("Ingrese la dirección IP donde escucha el n_s");
        vectorDatosLocalizarNS[1] = "localhost";//UtilidadesConsola.leerCadena();
        vectorDatosLocalizarNS[2] = "-ORBInitialPort";
        //System.out.println("Ingrese el puerto donde escucha el n_s");
        vectorDatosLocalizarNS[3] ="2020";// UtilidadesConsola.leerCadena();

        objRemoto = UtilidadesRegistroC.obtenerObjRemoto(vectorDatosLocalizarNS,"idObjetoRemoto");
        //System.out.println("Obtiene el obj Remoto" +objRemoto);
        
        if(this.objRemoto.registrarCompra(c)) return true;
        return false;
    }

    @Override
    public void init(Compra c){
        this.compraNotificar = new CompraDTO(c.getIdUsuario(),c.getTipoIdentificacion(),c.getValorCompra(),c.getLugarCompra(),c.getFechaCompra(),c.getMedioPago(),c.getNitEmpresa());
    }
    @Override
    public void run() {
        System.out.println("Envíar notificación");
        notificar(this.compraNotificar);
    }
}
