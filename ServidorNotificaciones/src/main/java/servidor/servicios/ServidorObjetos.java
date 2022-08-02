/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.servicios;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;
import servidor.Repositorio.CompraRepositorio;
import servidor.Repositorio.IntCompraRepository;
import servidor.controladores.CompraControladorImpl;
import servidor.utilidades.UtilidadesRegistroS;
/**
 *
 * @author Paula
 */
public class ServidorObjetos {
    public static void main(String[] args) {
       
        try {
            String[] vectorDatosLocalizarNS = new String[4];//almacena la información para localizar el ns
            vectorDatosLocalizarNS[0] = "-ORBInitialHost";
            //System.out.println("Ingrese la dirección IP donde escucha el n_s");
            vectorDatosLocalizarNS[1] = "localhost";//UtilidadesConsola.leerCadena();
            vectorDatosLocalizarNS[2] = "-ORBInitialPort";
            //System.out.println("Ingrese el puerto donde escucha el n_s");
            vectorDatosLocalizarNS[3] = "2020";//UtilidadesConsola.leerCadena();
            
            
            CompraRepositorio objRepository = new CompraRepositorio();
            CompraControladorImpl objRemotoGestionCanciones = new CompraControladorImpl(objRepository);
      
            UtilidadesRegistroS.registrarObjetoRemoto(vectorDatosLocalizarNS, objRemotoGestionCanciones,"idObjetoRemoto");
            
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace(System.out);
        }
    }
      
}
