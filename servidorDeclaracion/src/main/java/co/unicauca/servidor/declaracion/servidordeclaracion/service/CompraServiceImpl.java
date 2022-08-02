package co.unicauca.servidor.declaracion.servidordeclaracion.service;

import co.unicauca.servidor.declaracion.servidordeclaracion.dao.ICompraRepository;
import co.unicauca.servidor.declaracion.servidordeclaracion.model.Compra;
import co.unicauca.servidor.declaracion.servidordeclaracion.service.utilidades.UtilidadesRegistroC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sop_corba.ControladorCompraInt;

@Service
public class CompraServiceImpl implements  ICompraService{
    //Dependece inyection
    @Autowired
    private ICompraRepository compraRepository;
    @Autowired
    private INotificarService notificarService;

//    private ControladorCompraInt objRemoto;
//    public CompraServiceImpl() {
//        this.objRemoto=obtenerObjRemoto();
//    }
    
    
    @Override
    public Compra guardarCompra(Compra save) {
        Compra saveRepository = this.compraRepository.guardarCompra(save);
        if(this.compraRepository.requiereNotificacion(save.getIdUsuario())){
            this.notificarService.init(save);
            Thread notificacion = new Thread((Runnable) notificarService);
            
            notificacion.run();
            
//            NotificarServiceImpl notificar = new NotificarServiceImpl();
//            notificar.init(save);
//            notificar.run();
        }
        return saveRepository;
    }
    private ControladorCompraInt obtenerObjRemoto(){
        ControladorCompraInt objRemoto;
        String[] vectorDatosLocalizarNS = new String[4];
        vectorDatosLocalizarNS[0] = "-ORBInitialHost";
        //System.out.println("Ingrese la dirección IP donde escucha el n_s");
        vectorDatosLocalizarNS[1] = "localhost";//UtilidadesConsola.leerCadena();
        vectorDatosLocalizarNS[2] = "-ORBInitialPort";
        //System.out.println("Ingrese el puerto donde escucha el n_s");
        vectorDatosLocalizarNS[3] ="2020";// UtilidadesConsola.leerCadena();

        objRemoto = UtilidadesRegistroC.obtenerObjRemoto(vectorDatosLocalizarNS,"idObjetoRemoto");
        
        return objRemoto;
    }
}
