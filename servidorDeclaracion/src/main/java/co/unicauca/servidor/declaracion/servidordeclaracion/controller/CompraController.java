package co.unicauca.servidor.declaracion.servidordeclaracion.controller;

import co.unicauca.servidor.declaracion.servidordeclaracion.model.Compra;
import co.unicauca.servidor.declaracion.servidordeclaracion.service.ICompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CompraController {
    //Dependence inyection
    @Autowired
    private ICompraService compraService;

    //Methods
    @PostMapping("/compra")
    public ResponseEntity<Compra> guardarCompra(@RequestParam int idUsuario, @RequestParam String tipoId, @RequestBody Compra save){
        save.setIdUsuario(idUsuario);
        save.setTipoIdentificacion(tipoId);
        //System.out.println("Apunto de guardar compra");
        Compra saveRepository = this.compraService.guardarCompra(save);
        
        if(saveRepository != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(saveRepository);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Compra.builder().build());
    }
}
