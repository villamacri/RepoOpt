package ejercicio.service;

import ejercicio.errors.FormatoTextoException;
import ejercicio.errors.OperacionNumericaException;

public class GestionPedidos {

    public void validarCodigo (String codigo) throws FormatoTextoException {
        if (!codigo.startsWith("PROD") || codigo.isEmpty()) {
            throw new FormatoTextoException("Error, el código no empieza por PROD o está vacío");
        }
    }

    public void validarDireccion(String direccion) throws FormatoTextoException{
        int tope=10;
        if(direccion.length()<tope){
            throw new FormatoTextoException("Error, la dirección tiene menos de 10 caracteres");
        }
    }

    public void validarPrecio(double precio) throws OperacionNumericaException {
        double tope = 0.0;
        if ( precio<tope){
            throw new OperacionNumericaException("Error, el precio no puede ser menor a 0");
        }
    }
}
