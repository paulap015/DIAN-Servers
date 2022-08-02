package co.unicauca.servidor.declaracion.servidordeclaracion.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Compra {
    private int idUsuario;
    private String tipoIdentificacion;
    private double valorCompra;
    private String lugarCompra;
    private String fechaCompra;
    private String medioPago;
    private String nitEmpresa;
}
